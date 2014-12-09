package org.strasa.middleware.model.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.strasa.middleware.manager.StudyDataColumnManagerImpl;
import org.strasa.web.managegermplasm.view.model.AcrossQueryException;

import com.mysql.jdbc.PreparedStatement;

public class StudyDataDynamicColumnQueryBuilder {
	public boolean isRaw;
	public ArrayList<Queries> arrQueries = new ArrayList<Queries>();

	public StudyDataDynamicColumnQueryBuilder(boolean isRaw) {
		this.isRaw = isRaw;
	}

	public StudyDataDynamicColumnQueryBuilder andEqualTo(String column, String value) {

		arrQueries.add(new Queries(column, "=", value));
		return this;
	}

	public StudyDataDynamicColumnQueryBuilder andNotEqualTo(String column, String value) {

		arrQueries.add(new Queries(column, "!=", value));
		return this;
	}

	public StudyDataDynamicColumnQueryBuilder andGreaterThan(String column, String value) {

		arrQueries.add(new Queries(column, ">", value));
		return this;
	}

	public StudyDataDynamicColumnQueryBuilder andGreaterThanOrEqual(String column, String value) {

		arrQueries.add(new Queries(column, ">=", value));
		return this;
	}

	public StudyDataDynamicColumnQueryBuilder andLessThan(String column, String value) {

		arrQueries.add(new Queries(column, "<", value));
		return this;
	}

	public StudyDataDynamicColumnQueryBuilder andLessThanOrEqual(String column, String value) {

		arrQueries.add(new Queries(column, "<=", value));
		return this;
	}

	public StudyDataDynamicColumnQueryBuilder andLike(String column, String value) {

		arrQueries.add(new Queries(column, "=", value));
		return this;
	}

	public StudyDataDynamicColumnQueryBuilder addOtherVariable(String column) {
		arrQueries.add(new Queries(column, null, null));
		return this;
	}

	public PreparedStatement buildQuery(java.sql.Connection con) throws SQLException, AcrossQueryException {
		StringBuilder strBaseQuery = new StringBuilder();
		System.out.print("BUILDING QUERY");
		HashSet<String> lstDuplicate = new HashSet<String>();

		strBaseQuery.append("SELECT * from (SELECT studyid, COLUMN_GET(dynamic_cols, 'GName' as char) AS Gname ");

		for (Queries q : arrQueries) {
			if (lstDuplicate.add(q.column) && !q.column.equals("GName"))
				strBaseQuery.append(", COLUMN_GET(dynamic_cols, '" + q.column + "' as char) AS '" + q.column + "'");

		}
		List<Integer> lstCols = new StudyDataColumnManagerImpl().getDatasetIdsFromColumns(((isRaw) ? "rd" : "dd"), getQueriesColumn());
		if (lstCols.isEmpty()) {
			throw new AcrossQueryException("No study is using this study");
		}
		strBaseQuery.append("FROM  " + ((isRaw) ? "studyrawdatadynacol" : "studyderivedatadynacol") + " WHERE dataset IN (");
		strBaseQuery.append(StringUtils.join(lstCols.toArray(), ","));
		strBaseQuery.append(")) as s WHERE ");
		ArrayList<String> arrWhereSQL = new ArrayList<String>();
		for (Queries q : arrQueries) {
			if (q.value != null)
				arrWhereSQL.add("" + q.column + " " + q.operator + " ?");
		}
		strBaseQuery.append(StringUtils.join(arrWhereSQL.toArray(), " AND "));
		strBaseQuery.append(";");

		PreparedStatement query = (PreparedStatement) con.prepareStatement(strBaseQuery.toString());

		for (int i = 0; i < arrQueries.size(); i++) {
			if (arrQueries.get(i).value != null) {
				if (arrQueries.get(i).isInt) {
					query.setInt(i + 1, Integer.parseInt(arrQueries.get(i).value));
				} else {
					query.setString(i + 1, arrQueries.get(i).value);
				}
			}
		}

		return query;

	}

	public ArrayList<String> getQueriesColumn() {
		ArrayList<String> returnVal = new ArrayList<String>();
		HashSet<String> hshDup = new HashSet<String>();
		for (Queries q : arrQueries) {
			if (hshDup.add(q.column))
				returnVal.add(q.column);
		}

		return returnVal;
	}

	public class Queries {
		public String operator, column, value;
		public boolean isInt;

		public Queries(String column, String operator, String value) {
			this.column = column;
			this.operator = operator;
			this.value = value;
			isInt = StringUtils.isNumeric(value);

		}
	}

}
