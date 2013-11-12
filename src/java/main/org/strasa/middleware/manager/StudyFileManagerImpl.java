package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyFileMapper;
import org.strasa.middleware.model.StudyFile;
import org.strasa.middleware.model.StudyFile;
import org.strasa.middleware.model.StudyFileExample;

public class StudyFileManagerImpl {

	public void addRecord(StudyFile record){

		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyFileMapper mapper = session.getMapper(StudyFileMapper.class);
		try{
				mapper.insert(record);
		}
		finally{
			session.commit();
			session.close();
		}
	}
	
	public void updateRecord(StudyFile record){

		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyFileMapper mapper = session.getMapper(StudyFileMapper.class);
		try{
				mapper.updateByPrimaryKey(record);
		}
		finally{
			session.commit();
			session.close();
		}
	}
	public void deleteRecord(StudyFile record){

		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyFileMapper mapper = session.getMapper(StudyFileMapper.class);
		try{
				mapper.deleteByPrimaryKey(record.getId());
		}
		finally{
			session.commit();
			session.close();
		}
	}
	
	public List<StudyFile> getFileByStudyId(int studyid){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyFileMapper mapper = session.getMapper(StudyFileMapper.class);
		try{
			StudyFileExample example = new StudyFileExample();
			example.createCriteria().andStudyidEqualTo(studyid);
			return mapper.selectByExample(example);
		}
		finally{
			session.close();
		}
	}
	
	public List<StudyFile> getFileByFileName(String filename){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyFileMapper mapper = session.getMapper(StudyFileMapper.class);
		try{
			StudyFileExample example = new StudyFileExample();
			example.createCriteria().andFilenameEqualTo(filename);
			return mapper.selectByExample(example);
		}
		finally{
			session.close();
		}
	}
	
	public List<StudyFile> getFile(String filename, int studyid, int userid){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyFileMapper mapper = session.getMapper(StudyFileMapper.class);
		try{
			StudyFileExample example = new StudyFileExample();
			example.createCriteria().andFilenameEqualTo(filename).andStudyidEqualTo(studyid).andUseridEqualTo(userid);
			return mapper.selectByExample(example);
		}
		finally{
			session.close();
		}
	}

	
}