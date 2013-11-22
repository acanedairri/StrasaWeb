package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyDataColumnMapper;
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.middleware.model.StudyDataColumnExample;

public class StudyDataColumnManagerImpl {


	public List<StudyDataColumn> getStudyDataColumnByStudyId(int studyId,String datatype){
		SqlSession session =new ConnectionFactory().getSqlSessionFactory().openSession();
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);

		try{

			StudyDataColumnExample example = new StudyDataColumnExample();
			if(datatype.equals("rd")){
				example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("rd");
			}else{
				example.createCriteria().andStudyidEqualTo(studyId).andDatatypeEqualTo("dd");
			}
			return mapper.selectByExample(example);

		}finally{
			session.close();
		}

	}
	
	public void addStudyDataColumn(int studyId,String[] columns, String datatype){
		SqlSession session =new ConnectionFactory().getSqlSessionFactory().openSession(ExecutorType.BATCH);
		StudyDataColumnMapper mapper = session.getMapper(StudyDataColumnMapper.class);

		try{
			
			for(String col : columns){
				StudyDataColumn newCol = new StudyDataColumn();
				newCol.setStudyid(studyId);
				newCol.setColumnheader(col);
				newCol.setDatatype(datatype);
				mapper.insert(newCol);
			}
			session.commit();
			
		
		}finally{
			session.close();
		}

	}




}
