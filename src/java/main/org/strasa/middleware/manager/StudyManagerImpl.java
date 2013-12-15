package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyDataColumnMapper;
import org.strasa.middleware.mapper.StudyDerivedDataMapper;
import org.strasa.middleware.mapper.StudyDesignMapper;
import org.strasa.middleware.mapper.StudyFileMapper;
import org.strasa.middleware.mapper.StudyGermplasmMapper;
import org.strasa.middleware.mapper.StudyLocationMapper;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudyRawDataMapper;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.model.ProjectExample;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyDataColumnExample;
import org.strasa.middleware.model.StudyDerivedDataExample;
import org.strasa.middleware.model.StudyExample;
import org.strasa.middleware.model.StudyFileExample;
import org.strasa.middleware.model.StudyGermplasmExample;
import org.strasa.middleware.model.StudyLocationExample;
import org.strasa.middleware.model.StudyRawDataExample;
import org.strasa.middleware.model.StudySiteExample;

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
		StudySiteMapper siteMapper = session.getMapper(StudySiteMapper.class);
		StudyLocationMapper locMapper = session.getMapper(StudyLocationMapper.class);
		StudyDataColumnMapper dataColMapper = session.getMapper(StudyDataColumnMapper.class);
		StudyDerivedDataMapper derivedMapper = session.getMapper(StudyDerivedDataMapper.class);
		StudyRawDataMapper rawMapper = session.getMapper(StudyRawDataMapper.class);
		StudyFileMapper fileMapper = session.getMapper(StudyFileMapper.class);
		StudyGermplasmMapper germplasmMapper = session.getMapper(StudyGermplasmMapper.class);
		 
		
		try{
			StudySiteExample siteEx=new StudySiteExample();
			siteEx.createCriteria().andStudyidEqualTo(studyId);
			siteMapper.deleteByExample(siteEx);
			
			StudyLocationExample locEx=new StudyLocationExample();
			locEx.createCriteria().andStudyidEqualTo(studyId);
			locMapper.deleteByExample(locEx);
			
			StudyDataColumnExample dataColEx=new StudyDataColumnExample();
			dataColEx.createCriteria().andStudyidEqualTo(studyId);
			dataColMapper.deleteByExample(dataColEx);
			
			StudyRawDataExample rawEx=new StudyRawDataExample();
			rawEx.createCriteria().andStudyidEqualTo(studyId);
			rawMapper.deleteByExample(rawEx);
			
			StudyDerivedDataExample derivedEx=new StudyDerivedDataExample();
			derivedEx.createCriteria().andStudyidEqualTo(studyId);
			derivedMapper.deleteByExample(derivedEx);
			
			StudyFileExample fileEx=new StudyFileExample();
			fileEx.createCriteria().andStudyidEqualTo(studyId);
			fileMapper.deleteByExample(fileEx);

			StudyGermplasmExample germplasmEx=new StudyGermplasmExample();
			germplasmEx.createCriteria().andStudyidEqualTo(studyId);
			germplasmMapper.deleteByExample(germplasmEx);
			
			mapper.deleteByPrimaryKey(studyId);
			
			session.commit();
		}
		finally{
			session.close();
		}
	}
	

	public void updateStudyById(Study record) {
		// TODO Auto-generated method stub
		SqlSession session = new ConnectionFactory().sqlSessionFactory.openSession();
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		
		try{
			System.out.println(record.getShared());
			mapper.updateByPrimaryKey(record);
			session.commit();
//			mapper.updateByExample(record, example);
		}
		finally{
			session.close();
		}
	}

	public List<Study> getStudyByProgramId(Integer programId) {
		// TODO Auto-generated method stub
		SqlSession session = new ConnectionFactory().sqlSessionFactory.openSession();
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		try{
			StudyExample example = new StudyExample();
			example.createCriteria().andProgramidEqualTo(programId);
			return mapper.selectByExample(example);
		}
		finally{
			session.close();
		}
	}
	
	public List<Study> getStudyByProjectId(Integer projectId) {
		// TODO Auto-generated method stub
		SqlSession session = new ConnectionFactory().sqlSessionFactory.openSession();
		StudyMapper mapper = session.getMapper(StudyMapper.class);
		try{
			StudyExample example = new StudyExample();
			example.createCriteria().andProjectidEqualTo(projectId);
			return mapper.selectByExample(example);
		}
		finally{
			session.close();
		}
	}
}
