package org.strasa.middleware.manager;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.factory.MariaDBConnectionSettings;
import org.strasa.middleware.mapper.other.StudyRawDataBatch;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.middleware.model.StudySite;
import org.strasa.middleware.model.custom.StudyDataDynamicColumnQueryBuilder;
import org.strasa.middleware.model.custom.StudyRawDataDynCol;
import org.strasa.web.common.api.ExcelHelper;
import org.strasa.web.crossstudyquery.view.model.AcrossStudyData;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class StudyDataDynamicColumnManager {

	@WireVariable
	ConnectionFactory connectionFactory;

	String databaseURL = MariaDBConnectionSettings.databaseURL;
	String user = MariaDBConnectionSettings.user;
	String password = MariaDBConnectionSettings.password;

	private boolean isRaw;

	public StudyDataDynamicColumnManager(boolean isRaw) {
		this.isRaw = isRaw;
	}

	public void addStudyDataFromCsv(Study study, List<String> header, List<String[]> rawCSVData, int dataset, boolean isRawData, Integer userid) {

		java.sql.Connection con;
		String sql = "INSERT INTO " + ((isRaw) ? "studyrawdatadynacol" : "studyderivedatadynacol") + "(studyid,dataset,datarow,dynamic_cols) VALUES (?, ?, ?, COLUMN_CREATE(";
		ArrayList<String> tmpArrColumns = new ArrayList<String>();
		ArrayList<String> lstTemp = new StudyVariableManagerImpl().correctVariableCase(header);
		header.clear();
		header.addAll(lstTemp);

		for (String h : header) {
			tmpArrColumns.add("'" + h + "'");
			tmpArrColumns.add("?");

		}
		sql = sql + StringUtils.join(tmpArrColumns, ",") + "));";
		System.out.println(sql);

		try {
			con = DriverManager.getConnection(databaseURL, user, password);
			java.sql.PreparedStatement ps = con.prepareStatement(sql);
			int count = 1;
			for (String[] arrRow : rawCSVData) {

				ps.setInt(1, study.getId());
				ps.setInt(2, dataset);
				ps.setInt(3, count++);
				int subcount = 4;
				for (String cell : arrRow) {
					if (!StringUtils.isEmpty(cell))
						ps.setString(subcount++, cell);
					else
						ps.setString(subcount++, " ");
				}

				ps.addBatch();
			}

			ps.executeBatch();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Germplasm> getStudyGermplasmFromDataset(Integer studyID, Integer dataset) {
		ArrayList<Germplasm> returnVal = new ArrayList<Germplasm>();
		ArrayList<String> columns = new ArrayList<String>();
		columns.add("GID");
		columns.add("GName");

		ArrayList<HashMap<String, String>> lstRawData = getRawData(studyID, dataset, columns);

		HashSet<String> hshUniq = new HashSet<String>();

		for (HashMap<String, String> row : lstRawData) {
			if (hshUniq.add(StringUtils.join(row))) {
				Germplasm germ = new Germplasm();
				if (row.containsKey("GID"))
					germ.setGid(Integer.parseInt(row.get("GID")));
				if (row.containsKey("GName"))
					germ.setGermplasmname(row.get("GName"));

				returnVal.add(germ);
			}
		}
		return returnVal;
	}

	public List<StudySite> getStudySiteFromDataset(Integer studyID, Integer dataset) {
		ArrayList<StudySite> returnVal = new ArrayList<StudySite>();
		ArrayList<String> columns = new ArrayList<String>();
		columns.add("Site");
		columns.add("Location");
		columns.add("Year");
		columns.add("Season");

		ArrayList<HashMap<String, String>> lstRawData = getRawData(studyID, dataset, columns);

		HashSet<String> hshUniq = new HashSet<String>();

		for (HashMap<String, String> row : lstRawData) {
			if (hshUniq.add(StringUtils.join(row.values()))) {
				StudySite site = new StudySite();
				if (row.containsKey("Site"))
					site.setSitename(row.get("Site"));
				if (row.containsKey("Location"))
					site.setSitelocation(row.get("Location"));
				if (row.containsKey("Year"))
					site.setYear(row.get("Year"));
				if (row.containsKey("Season"))
					site.setSeason(row.get("Season"));
				returnVal.add(site);
			}
		}
		return returnVal;

	}

	public ArrayList<HashMap<String, String>> getRawData(Integer studyID, Integer dataset, ArrayList<String> columns) {
		ArrayList<HashMap<String, String>> returnVal = new ArrayList<HashMap<String, String>>();

		java.sql.Connection con;
		try {
			con = DriverManager.getConnection(databaseURL, user, password);
			java.sql.Statement stmt = con.createStatement();

			ArrayList<String> lstColumns = new StudyDataColumnManagerImpl().getExistingColumn(studyID, ((isRaw) ? "rd" : "dd"), dataset, columns);
			String query = "SELECT ";
			ArrayList<String> qs = new ArrayList<String>();
			for (String col : lstColumns) {
				qs.add("COLUMN_GET(dynamic_cols, '" + col + "' as char) AS '" + col + "'");
			}

			if (dataset != null)
				query = query + StringUtils.join(qs, ", ") + "  FROM " + ((isRaw) ? "studyrawdatadynacol" : "studyderivedatadynacol") + " WHERE studyid = " + String.valueOf(studyID) + " AND dataset = " + dataset + " ;";
			else
				query = query + StringUtils.join(qs, ", ") + " FROM " + ((isRaw) ? "studyrawdatadynacol" : "studyderivedatadynacol") + " WHERE studyid = " + String.valueOf(studyID) + ";";

			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				HashMap<String, String> retRow = new HashMap<String, String>();
				for (String col : lstColumns) {
					retRow.put(col, rs.getString(col));
				}
				returnVal.add(retRow);
			}

			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnVal;
	}

	public void addStudyRawDataFromSpreadsheetUsingDynaCols(Study study, ArrayList<String> header, Sheet sheet, int dataset, boolean isRawData, Integer userid) throws Exception {
		long startTime = System.nanoTime();
		int in = 0;
		SqlSession session = connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
		StudyRawDataBatch studyRawBatch = session.getMapper(StudyRawDataBatch.class);

		ArrayList<String> lstTemp = new StudyVariableManagerImpl().correctVariableCase(header);
		System.out.println(in++ + ": Elapsed Time = " + (System.nanoTime() - startTime) + " ns = " + ((double) (System.nanoTime() - startTime) / 1000000000) + " s");

		header.clear();
		header.addAll(lstTemp);

		try {
			java.sql.Connection con = DriverManager.getConnection(databaseURL, user, password);
			java.sql.Statement stmt = con.createStatement();
			new StudyRawDataManagerImpl().addStudy(study);
			System.out.println(in++ + ": Elapsed Time = " + (System.nanoTime() - startTime) + " ns = " + ((double) (System.nanoTime() - startTime) / 1000000000) + " s");

			Integer lastRow = new StudyRawDataManagerImpl().getLastDataRow(study.getId(), isRawData);
			System.out.println(in++ + ": Elapsed Time = " + (System.nanoTime() - startTime) + " ns = " + ((double) (System.nanoTime() - startTime) / 1000000000) + " s");

			System.out.println("StudyID: " + study.getId());
			ExcelHelper excelHelper = new ExcelHelper();

			ArrayList<StudyRawDataDynCol> lstData = new ArrayList<StudyRawDataDynCol>();
			String sql = "INSERT INTO " + ((isRaw) ? "studyrawdatadynacol" : "studyderivedatadynacol") + "(studyid,dataset,datarow,dynamic_cols) VALUES ";
			ArrayList<String> lstQueries = new ArrayList<String>();
			for (Row row : sheet) {
				if (row.getRowNum() > 0) {
					StudyRawDataDynCol rowData = new StudyRawDataDynCol();
					rowData.setDatarow(row.getRowNum() + 1 + lastRow);
					rowData.setDataset(dataset);
					rowData.setStudyid(study.getId());
					ArrayList<String> lstDynCols = new ArrayList<String>();
					lstDynCols.clear();
					for (Cell cell : row) {

						lstDynCols.add(header.get(cell.getColumnIndex()));
						lstDynCols.add(excelHelper.getCellValueToString(cell));

					}

					rowData.setRows(lstDynCols);
					lstData.add(rowData);
					// System.out.println(Arrays.toString(lstDynCols.toArray(new
					// String[lstDynCols.size()])));

					lstQueries.add(" (" + rowData.getStudyid() + "," + rowData.getDataset() + "," + rowData.getDatarow() + ",COLUMN_CREATE('" + StringUtils.join(lstDynCols.toArray(new String[lstDynCols.size()]), "','") + "'))");

				}

			}
			sql = sql + StringUtils.join(lstQueries.toArray(new String[lstQueries.size()]), ",");
			stmt.execute(sql);

			new StudyDataColumnManagerImpl().addStudyDataColumn(study.getId(), header.toArray(new String[header.size()]), isRawData, dataset);
			System.out.println(in++ + ": Elapsed Time = " + (System.nanoTime() - startTime) + " ns = " + ((double) (System.nanoTime() - startTime) / 1000000000) + " s");

		} finally {
			session.close();
		}

	}

	public ArrayList<ArrayList<String>> getStudyRawDataDynaCols(Integer studyid, Integer dataset, Integer start, Integer limit) {

		ArrayList<ArrayList<String>> returnVal = new ArrayList<ArrayList<String>>();

		java.sql.Connection con;
		try {
			con = DriverManager.getConnection(databaseURL, user, password);
			java.sql.Statement stmt = con.createStatement();

			List<StudyDataColumn> lstColumns = new StudyDataColumnManagerImpl().getStudyDataColumnByStudyId(studyid, ((isRaw) ? "rd" : "dd"), dataset);
			String query = "SELECT id, ";
			ArrayList<String> qs = new ArrayList<String>();
			for (StudyDataColumn col : lstColumns) {
				qs.add("COLUMN_GET(dynamic_cols, '" + col.getColumnheader() + "' as char) AS '" + col.getColumnheader() + "'");
			}

			if (dataset != null)
				query = query + StringUtils.join(qs, ", ") + "  FROM " + ((isRaw) ? "studyrawdatadynacol" : "studyderivedatadynacol") + " WHERE studyid = " + String.valueOf(studyid) + " AND dataset = " + dataset;
			else
				query = query + StringUtils.join(qs, ", ") + " FROM " + ((isRaw) ? "studyrawdatadynacol" : "studyderivedatadynacol") + " WHERE studyid = " + String.valueOf(studyid);

			if (start != null && limit != null) {
				query = query + " ORDER BY id LIMIT " + start + ", " + limit + ";";
			}
			System.out.println(query);

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ArrayList<String> retRow = new ArrayList<String>();
				for (StudyDataColumn col : lstColumns) {
					retRow.add(rs.getString(col.getColumnheader()));
				}
				returnVal.add(retRow);
			}

			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		return returnVal;

	}

	public ArrayList<AcrossStudyData> getAcrossStudyResult(StudyDataDynamicColumnQueryBuilder sqlBuilder) {

		ArrayList<AcrossStudyData> returnVal = new ArrayList<AcrossStudyData>();

		java.sql.Connection con;
		try {
			con = DriverManager.getConnection(databaseURL, user, password);

			System.out.println(sqlBuilder.buildQuery(con).toString());

			ResultSet rs = sqlBuilder.buildQuery(con).executeQuery();
			HashMap<Integer, String> hshStudy = new HashMap<Integer, String>();

			while (rs.next()) {
				AcrossStudyData across = new AcrossStudyData();
				// System.out.println("TOT: " + rs.getto)
				across.setStudyId(Integer.valueOf(rs.getString(1)));
				if (hshStudy.containsKey(across.getStudyId())) {
					across.setStudyname(hshStudy.get(across.getStudyId()));
				} else {
					String studyName = new StudyManagerImpl().getStudyById(across.getStudyId()).getName();
					hshStudy.put(across.getStudyId(), studyName);
					across.setStudyname(studyName);
				}
				across.setGname(rs.getString(2));
				across.setOtherdata(new ArrayList<String>());

				for (int i = 0; i < sqlBuilder.getQueriesColumn().size(); i++) {
					across.getOtherdata().add(rs.getString(i + 3));
				}
				returnVal.add(across);
			}

			// rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		return returnVal;

	}

	public Long countStudyDynamicCOl(Integer studyid, Integer dataset) {
		Long returnVal = new Long(0);

		java.sql.Connection con;
		try {
			con = DriverManager.getConnection(databaseURL, user, password);
			java.sql.Statement stmt = con.createStatement();
			String query = "SELECT COUNT(*) AS Total from " + ((isRaw) ? "studyrawdatadynacol" : "studyderivedatadynacol") + " ";

			if (dataset != null)
				query = query + "WHERE studyid = " + String.valueOf(studyid) + " AND dataset = " + dataset + ";";
			else
				query = query + "WHERE studyid = " + String.valueOf(studyid) + ";";

			System.out.println(query);

			ResultSet rs = stmt.executeQuery(query);

			rs.next();
			returnVal = rs.getLong(1);
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		return returnVal;

	}

}
