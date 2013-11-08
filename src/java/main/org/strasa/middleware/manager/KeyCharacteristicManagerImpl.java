package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmCharacteristicsMapper;
import org.strasa.middleware.mapper.GermplasmMapper;
import org.strasa.middleware.mapper.KeyAbioticMapper;
import org.strasa.middleware.mapper.KeyBioticMapper;
import org.strasa.middleware.mapper.KeyGrainQualityMapper;
import org.strasa.middleware.mapper.KeyMajorGenesMapper;
import org.strasa.middleware.mapper.ProgramMapper;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.GermplasmExample;
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyMajorGenes;
import org.strasa.middleware.model.ProgramExample;

public class KeyCharacteristicManagerImpl {

	
	public void getGermplasmCharacteristicById(GermplasmCharacteristics record){
		
		SqlSession session = new ConnectionFactory().getSqlSessionFactory().openSession();
		GermplasmCharacteristicsMapper GermplasmCharacteristicsMapper = session.getMapper(GermplasmCharacteristicsMapper.class);
		
		try{
			GermplasmCharacteristicsMapper.insert(record);
			session.commit();
			
		}finally{
			session.close();
		}
		
	}
		
	public List<KeyBiotic> getAllBiotic(){
		
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		KeyBioticMapper mapper = session.getMapper(KeyBioticMapper.class);
		try{
			return mapper.selectByExample(null);
		}
		finally{
			session.close();
		}
	}
	
public List<KeyAbiotic> getAllAbiotic(){
		
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		KeyAbioticMapper mapper = session.getMapper(KeyAbioticMapper.class);
		try{
			return mapper.selectByExample(null);
		}
		finally{
			session.close();
		}
	}
public List<KeyGrainQuality> getAllGrainQuality(){
	
	SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
	KeyGrainQualityMapper mapper = session.getMapper(KeyGrainQualityMapper.class);
	try{
		return mapper.selectByExample(null);
	}
	finally{
		session.close();
	}
}
public List<KeyMajorGenes> getAllMajorGenes(){
	
	SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
	KeyMajorGenesMapper mapper = session.getMapper(KeyMajorGenesMapper.class);
	try{
		return mapper.selectByExample(null);
	}
	finally{
		session.close();
	}
}
	
}
