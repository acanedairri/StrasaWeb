package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyDataColumnMapper;
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.middleware.model.StudyDataColumnExample;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class StudyDataColumnManagerImpl {

	@WireVariable
	ConnectionFactory connectionFactory;

	public List<StudyDataColumn> getStudyDataColumnByStudyId(int studyId, String datatype, Integer dataset) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);

		try {

			StudyDataColumnExample example = new StudyDataColumnExample();
			if (datatype.equals("rd")) {
				if (dataset != null)
					example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("rd").andDatasetEqualTo(dataset);
				else
					example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("rd");

			} else {
				if (dataset != null)
					example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("dd").andDatasetEqualTo(dataset);
				else
					example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("dd");
			}

			if (dataset == null) {
				List<StudyDataColumn> arrCol = mapper.selectByExample(example);
				HashSet<String> noDup = new HashSet<String>();
				List<StudyDataColumn> arrReturnVal = new ArrayList<StudyDataColumn>();

				for (StudyDataColumn col : arrCol) {
					if (noDup.add(col.getColumnheader())) {
						arrReturnVal.add(col);
					}
				}

				return arrReturnVal;
			} else
				return mapper.selectByExample(example);

		} finally {
			session.close();
		}

	}

	public ArrayList<String> getExistingColumn(int studyId, String datatype, Integer dataset, List<String> list) {
		List<StudyDataColumn> lstColumns = getStudyDataColumnByStudyId(studyId, datatype, dataset);
		ArrayList<String> returnVal = new ArrayList<String>();

		for (StudyDataColumn col : lstColumns) {
			if (list.contains(col.getColumnheader())) {
				returnVal.add(col.getColumnheader());
			}
		}

		return returnVal;

	}

	public List<Integer> getDatasetIdsFromColumns(String datatype, ArrayList<String> columns) {

		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);
		List<Integer> returnVal = new ArrayList<Integer>();
		try {
			HashMap<Integer, Integer> hshIdCount = new HashMap<Integer, Integer>();

			for (String column : columns) {
				StudyDataColumnExample example = new StudyDataColumnExample();
				example.createCriteria().andColumnheaderEqualTo(column).andDatatypeEqualTo(datatype);
				List<StudyDataColumn> preResult = mapper.selectByExample(example);
				for (StudyDataColumn stCol : preResult) {
					if (hshIdCount.containsKey(stCol.getDataset())) {
						Integer curVal = hshIdCount.get(stCol.getDataset()) + 1;
						hshIdCount.put(stCol.getDataset(), curVal);
					} else {
						hshIdCount.put(stCol.getDataset(), 1);
					}
				}

			}
			System.out.println(hshIdCount.size() + " HASHCOUNT");

			for (Entry<Integer, Integer> entry : hshIdCount.entrySet()) {
				Integer key = entry.getKey();
				Integer value = entry.getValue();

				if (value == columns.size())
					returnVal.add(key);

			}
			System.out.println(returnVal.size() + " RETURNVALCOUNT");

		} finally {
			session.close();
		}

		return returnVal;

	}

	public List<StudyDataColumn> getStudyDataColumnByStudyId(int studyId, String datatype) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);

		try {

			StudyDataColumnExample example = new StudyDataColumnExample();
			if (datatype.equals("rd")) {
				example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("rd");
			} else {
				example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("dd");
			}
			return mapper.selectByExample(example);

		} finally {
			session.close();
		}

	}

	public void removeStudyDataColumnByStudyId(int studyId, String datatype, int dataset) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);

		try {

			StudyDataColumnExample example = new StudyDataColumnExample();
			if (datatype.equals("rd")) {
				example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("rd").andDatasetEqualTo(dataset);
			} else {
				example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("dd").andDatasetEqualTo(dataset);
			}
			mapper.deleteByExample(example);

		} finally {
			session.commit();
			session.close();
		}
	}

	public void updateStudyDataColumnByStudyId(int studyId, int dataset, String oldVar, String newVar) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);

		try {

			StudyDataColumnExample example = new StudyDataColumnExample();
			example.createCriteria().andStudyidEqualTo(studyId).andDatasetEqualTo(dataset).andColumnheaderEqualTo(oldVar);
			StudyDataColumn data = mapper.selectByExample(example).get(0);
			data.setColumnheader(newVar);
			mapper.updateByPrimaryKey(data);

		} finally {
			session.commit();
			session.close();
		}
	}

	public void addStudyDataColumn(int studyId, String[] columns, boolean isRaw, Integer dataset) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);
		String datatype;
		datatype = "dd";
		if (isRaw)
			datatype = "rd";

		try {
			System.out.println("DataType: " + datatype);
			for (String col : columns) {
				StudyDataColumn newCol = new StudyDataColumn();
				newCol.setStudyid(studyId);
				newCol.setColumnheader(col);
				newCol.setDatatype(datatype);
				newCol.setDataset(dataset);
				mapper.insert(newCol);
			}
			session.commit();

		} finally {
			session.close();
		}

	}

	public boolean existsStudyDataColumnByName(String varCode) {
		// TODO Auto-generated method stub
		SqlSession session = connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);

		StudyDataColumnExample example = new StudyDataColumnExample();
		example.createCriteria().andColumnheaderEqualTo(varCode);
		if (!mapper.selectByExample(example).isEmpty())
			return true;
		return false;
	}

}
