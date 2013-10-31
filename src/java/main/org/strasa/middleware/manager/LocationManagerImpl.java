package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.LocationMapper;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.LocationExample;

public class LocationManagerImpl {


	public Location getLocationByLocationName(String locationName){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		LocationMapper mapper = session.getMapper(LocationMapper.class);
		try{
			LocationExample example = new LocationExample();
			example.createCriteria().andLocationnameEqualTo(locationName);
			return mapper.selectByExample(example).get(0);
		}
		finally{
			session.close();
		}
		
		
		
	}

}

