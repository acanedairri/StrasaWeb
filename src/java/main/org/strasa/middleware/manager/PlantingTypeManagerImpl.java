package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.PlantingTypeMapper;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.model.PlantingType;
import org.strasa.middleware.model.StudySite;

public class PlantingTypeManagerImpl {

	public PlantingTypeManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<PlantingType> getAllPlantingTypes(){
		SqlSession session =new ConnectionFactory().getSqlSessionFactory().openSession();
		PlantingTypeMapper PlantingTypeMapper = session.getMapper(PlantingTypeMapper.class);
		
		try{
			List<PlantingType> PlantingTypes = PlantingTypeMapper.selectByExample(null);
			
			return PlantingTypes;
			
		}finally{
			session.close();
		}
		
	}
	public PlantingType getPlantingTypeById(int id){
		SqlSession session =new ConnectionFactory().getSqlSessionFactory().openSession();
		PlantingTypeMapper PlantingTypeMapper = session.getMapper(PlantingTypeMapper.class);
		
		try{
			return PlantingTypeMapper.selectByPrimaryKey(id);
			
		}finally{
			session.close();
		}
		
	}

	@SuppressWarnings("null")
	public List<String> getAllPlantingTypesAsString() {
		List<String> PlantingTypes = new ArrayList<String>();;
		List<PlantingType> PlantingTypeList = getAllPlantingTypes();
		for(PlantingType e : PlantingTypeList){
			System.out.println(e.getPlanting());
			PlantingTypes.add(e.getPlanting());
		}
		// TODO Auto-generated method stub
		return PlantingTypes;
	}

	public PlantingType getPlantingTypeById(Integer plantingtypeid) {
		SqlSession session =new ConnectionFactory().getSqlSessionFactory().openSession();
		PlantingTypeMapper PlantingTypeMapper = session.getMapper(PlantingTypeMapper.class);
		
		try{
			PlantingType PlantingType = PlantingTypeMapper.selectByPrimaryKey(plantingtypeid);
			
			return PlantingType;
			
		}finally{
			session.close();
		}
	}
}
