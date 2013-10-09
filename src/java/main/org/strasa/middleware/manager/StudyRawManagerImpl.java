package org.strasa.middleware.manager;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudyRawDataMapper;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyRawData;

public class StudyRawManagerImpl {



	private SqlSession session;


	public StudyRawManagerImpl(){
		ConnectionFactory con = new ConnectionFactory();
		session =con.getSqlSessionFactory().openSession();
	}

	public int addStudy(Study record){
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try{
			studyMapper.insert(record);
			session.commit();
		}
		finally{
			
		}
		return record.getId();
	}


	public void addStudyRawData(Study study, List<StudyRawData> studyData){
		StudyRawDataMapper studyDataMapper = session.getMapper(StudyRawDataMapper.class);
		StudyMapper studyMapper = session.getMapper(StudyMapper.class);
		try{
			studyMapper.insert(study);
			for(StudyRawData sdata:studyData){
				sdata.setStudyid(study.getId());
				studyDataMapper.insert(sdata);
			}
			session.commit();

		}finally{
			session.close();
		}

	}



}
