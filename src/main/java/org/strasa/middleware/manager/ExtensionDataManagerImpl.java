package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.EcotypeMapper;
import org.strasa.middleware.mapper.ExtensionDataMapper;
import org.strasa.middleware.mapper.LocationMapper;
import org.strasa.middleware.mapper.ProgramMapper;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.ExtensionData;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.StudySite;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class ExtensionDataManagerImpl {


	@WireVariable
	ConnectionFactory connectionFactory;

	public ExtensionDataManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	public void addExtensionData(ExtensionData record) {
		// TODO Auto-generated method stub
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataMapper mapper = session.getMapper(ExtensionDataMapper.class);

		try{
			mapper.insert(record);
			session.commit();

		}finally{
			session.close();
		}

	}

	public List<ExtensionData> getAllExtensionData(){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataMapper mapper = session.getMapper(ExtensionDataMapper.class);


		try{
			List<ExtensionData> extensionData = mapper.selectByExample(null);

			return extensionData;

		}finally{
			session.close();
		}

	}
	public ExtensionData getExtensionDataById(int id){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataMapper mapper = session.getMapper(ExtensionDataMapper.class);

		try{
			ExtensionData extensionData = mapper.selectByPrimaryKey(id);

			return extensionData;

		}finally{
			session.close();
		}
	}
	
	@SuppressWarnings("null")
	public List<String> getAllExtensionDataAsString() {
		List<String> extData = new ArrayList<String>();;
		List<ExtensionData> extensionDataList = getAllExtensionData();
		for(ExtensionData e : extensionDataList){
			System.out.println(e.getDatasource());
			extData.add(e.getDatasource());
		}
		// TODO Auto-generated method stub
		return extData;
	}

	public void updateExtensionData(ExtensionData value) {
		// TODO Auto-generated method stub

		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataMapper mapper = session.getMapper(ExtensionDataMapper.class);

		try{	
			mapper.updateByPrimaryKey(value);
			session.commit();

		}finally{
			session.close();
		}

	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataMapper mapper = session.getMapper(ExtensionDataMapper.class);
		try{
			mapper.deleteByPrimaryKey(id);
			session.commit();
		}
		finally{
			session.close();
		}
	}

}
