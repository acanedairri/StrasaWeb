package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.LocationMapper;
import org.strasa.middleware.mapper.StudyLocationMapper;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.LocationExample;
import org.strasa.middleware.model.StudyLocation;

public class LocationManagerImpl {


	public Location getLocationByLocationName(String locationName){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		LocationMapper mapper = session.getMapper(LocationMapper.class);
		try{
			LocationExample example = new LocationExample();
			example.createCriteria().andLocationnameEqualTo(locationName);
			if(mapper.selectByExample(example).isEmpty()) return null;
			return mapper.selectByExample(example).get(0);
		}
		finally{
			session.close();
		}
	}
	public Location getLocationById(Integer id){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		LocationMapper mapper = session.getMapper(LocationMapper.class);
		try{
			LocationExample example = new LocationExample();
			example.createCriteria().andIdEqualTo(id);
			if(mapper.selectByExample(example).isEmpty()) return null;
			return mapper.selectByExample(example).get(0);
		}
		finally{
			session.close();
		}
	}
	public List<Location> getAllLocations(){
		// TODO Auto-generated method stub
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		LocationMapper locationMapper = session.getMapper(LocationMapper.class);
		try{
			List<Location> locations = locationMapper.selectByExample(null);
			return locations;
		}finally{
			session.close();
		}

	}

}

