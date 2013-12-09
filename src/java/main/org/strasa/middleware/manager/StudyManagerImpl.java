package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.model.ProjectExample;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyExample;

public class StudyManagerImpl {

	
	public Study getStudyById(int studyid){
		SqlSession session = new ConnectionFactory().sqlSessionFactory.openSession();
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		try{
			return mapper.selectByPrimaryKey(studyid);
		}
		finally{
			session.close();
		}
	}

	public List<Study> getStudiesByUserID(int userID) {
		// TODO Auto-generated method stub
		SqlSession session = new ConnectionFactory().sqlSessionFactory.openSession();
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		try{
			StudyExample example = new StudyExample();
			example.createCriteria().andUseridEqualTo(userID);
			return mapper.selectByExample(example);
		}
		finally{
			session.close();
		}
	}

	public void deleteStudyById(Integer studyId) {
		// TODO Auto-generated method stub
		SqlSession session = new ConnectionFactory().sqlSessionFactory.openSession();
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		try{
			mapper.deleteByPrimaryKey(studyId);
		}
		finally{
			session.close();
		}
	}
}
