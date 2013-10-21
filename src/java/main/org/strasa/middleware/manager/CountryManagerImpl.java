package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.CountryMapper;
import org.strasa.middleware.mapper.ProgramMapper;
import org.strasa.middleware.model.Country;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.ProgramExample;

public class CountryManagerImpl {


	public List<Country> getAllCountry(){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory().openSession();
		CountryMapper countryMapper = session.getMapper(CountryMapper.class);
		
		try{
			
			return countryMapper.selectByExample(null);
		}finally{
			session.close();
		}
	}
	
	
}
