package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.EcotypeMapper;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.StudySite;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class EcotypeManagerImpl {

	
	@WireVariable
	ConnectionFactory connectionFactory;

	public EcotypeManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<Ecotype> getAllEcotypes(){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		EcotypeMapper ecotypeMapper = session.getMapper(EcotypeMapper.class);
		
		try{
			List<Ecotype> ecotypes = ecotypeMapper.selectByExample(null);
			
			return ecotypes;
			
		}finally{
			session.close();
		}
		
	}
	public Ecotype getEcotypeById(int id){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		EcotypeMapper ecotypeMapper = session.getMapper(EcotypeMapper.class);
		try{
			Ecotype ecotypes = ecotypeMapper.selectByPrimaryKey(id);
			
			return ecotypes;
			
		}finally{
			session.close();
		}
	}

	@SuppressWarnings("null")
	public List<String> getAllEcotypesAsString() {
		List<String> ecotypes = new ArrayList<String>();;
		List<Ecotype> ecotypeList = getAllEcotypes();
		for(Ecotype e : ecotypeList){
			System.out.println(e.getEcotype());
			ecotypes.add(e.getEcotype());
		}
		// TODO Auto-generated method stub
		return ecotypes;
	}
}
