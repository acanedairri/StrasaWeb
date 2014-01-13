package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyTypeMapper;
import org.strasa.middleware.model.StudyType;
import org.strasa.middleware.model.StudyTypeExample;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class StudyTypeManagerImpl {

	@WireVariable
	ConnectionFactory connectionFactory;
	public List<StudyType> getAllStudyType(){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		StudyTypeMapper mapper = session.getMapper(StudyTypeMapper.class);
		
		try{
			return mapper.selectByExample(null);
		}
		finally{
			
		}
		

	}
	
	public StudyType getStudyTypeByName(String value){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		StudyTypeMapper mapper = session.getMapper(StudyTypeMapper.class);
		
		try{
			
			StudyTypeExample example = new StudyTypeExample();
			example.createCriteria().andStudytypeEqualTo(value);
			return mapper.selectByExample(example).get(0);
		}
		finally{
				session.close();
		}
	}

	public StudyType getStudyTypeById(Integer studytypeid) {
		// TODO Auto-generated method stub
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		StudyTypeMapper mapper = session.getMapper(StudyTypeMapper.class);
		
		try{
			
			StudyTypeExample example = new StudyTypeExample();
			example.createCriteria().andIdEqualTo(studytypeid);
			return mapper.selectByExample(example).get(0);
		}
		finally{
				session.close();
		}
	}
		

		
	
}
