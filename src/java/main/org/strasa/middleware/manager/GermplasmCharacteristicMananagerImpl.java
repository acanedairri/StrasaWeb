package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmCharacteristicsMapper;
import org.strasa.middleware.mapper.StudyGermplasmMapper;
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.GermplasmCharacteristicsExample;
import org.strasa.middleware.model.GermplasmExample;

public class GermplasmCharacteristicMananagerImpl {


	public void addCharacteristict(List<GermplasmCharacteristics> lstCharRecord){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession(ExecutorType.BATCH);
		GermplasmCharacteristicsMapper mapper = session.getMapper(GermplasmCharacteristicsMapper.class);
		try{
			for(GermplasmCharacteristics record : lstCharRecord){
				mapper.insert(record);
			}

			session.commit();
		}
		finally{
			session.close();
		}
	}

	public List<GermplasmCharacteristics> getGermplasmCharacteristicByKeyandGname(String keyChar,String gname){
		
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession(ExecutorType.BATCH);
		GermplasmCharacteristicsMapper mapper = session.getMapper(GermplasmCharacteristicsMapper.class);
		try{
			GermplasmCharacteristicsExample example = new GermplasmCharacteristicsExample();
			example.createCriteria().andGermplasmnameEqualTo(gname).andAttributeEqualTo(keyChar);
			return mapper.selectByExample(example);
		}
		finally{
			session.close();
		}

	}
}
