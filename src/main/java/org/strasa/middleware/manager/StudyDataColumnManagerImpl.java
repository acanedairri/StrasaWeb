package org.strasa.middleware.manager;

import java.util.List;

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
	
	public List<StudyDataColumn> getStudyDataColumnByStudyId(int studyId,String datatype,int dataset){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);

		try{

			StudyDataColumnExample example = new StudyDataColumnExample();
			if(datatype.equals("rd")){
				example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("rd").andDatasetEqualTo(dataset);
			}else{
				example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("dd").andDatasetEqualTo(dataset);
			}
			return mapper.selectByExample(example);

		}finally{
			session.close();
		}

	}
	public void removeStudyDataColumnByStudyId(int studyId, String datatype,int dataset){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);

		try{

			StudyDataColumnExample example = new StudyDataColumnExample();
			if(datatype.equals("rd")){
				example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("rd").andDatasetEqualTo(dataset);
			}else{
				example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("dd").andDatasetEqualTo(dataset);
			}
			mapper.deleteByExample(example);
			

		}finally{
			session.commit();
			session.close();
		}
	}
	
	public void addStudyDataColumn(int studyId,String[] columns, boolean isRaw, Integer dataset){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);
		String datatype;
		datatype = "dd";
		if(isRaw) datatype = "rd";
		
		try{
			System.out.println("DataType: " +datatype);
			for(String col : columns){
				StudyDataColumn newCol = new StudyDataColumn();
				newCol.setStudyid(studyId);
				newCol.setColumnheader(col);
				newCol.setDatatype(datatype);
				newCol.setDataset(dataset);
				mapper.insert(newCol);
			}
			session.commit();
			
		
		}finally{
			session.close();
		}

	}




}