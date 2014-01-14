package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmCharacteristicsMapper;
import org.strasa.middleware.mapper.KeyAbioticMapper;
import org.strasa.middleware.mapper.KeyBioticMapper;
import org.strasa.middleware.mapper.KeyGrainQualityMapper;
import org.strasa.middleware.mapper.KeyMajorGenesMapper;
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyMajorGenes;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class KeyCharacteristicManagerImpl {

	@WireVariable
	ConnectionFactory connectionFactory;
	public void getGermplasmCharacteristicById(GermplasmCharacteristics record){
		
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		GermplasmCharacteristicsMapper GermplasmCharacteristicsMapper = session.getMapper(GermplasmCharacteristicsMapper.class);
		
		try{
			GermplasmCharacteristicsMapper.insert(record);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
		
	public List<KeyBiotic> getAllBiotic(){
		
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		KeyBioticMapper mapper = session.getMapper(KeyBioticMapper.class);
		try{
			return mapper.selectByExample(null);
		}
		finally{
			session.close();
		}
	}
	
public List<KeyAbiotic> getAllAbiotic(){
		
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		KeyAbioticMapper mapper = session.getMapper(KeyAbioticMapper.class);
		try{
			return mapper.selectByExample(null);
		}
		finally{
			session.close();
		}
	}
public List<KeyGrainQuality> getAllGrainQuality(){
	
	SqlSession session =connectionFactory.sqlSessionFactory.openSession();
	KeyGrainQualityMapper mapper = session.getMapper(KeyGrainQualityMapper.class);
	try{
		return mapper.selectByExample(null);
	}
	finally{
		session.close();
	}
}
public List<KeyMajorGenes> getAllMajorGenes(){
	
	SqlSession session =connectionFactory.sqlSessionFactory.openSession();
	KeyMajorGenesMapper mapper = session.getMapper(KeyMajorGenesMapper.class);
	try{
		return mapper.selectByExample(null);
	}
	finally{
		session.close();
	}
}
	
}
