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
import org.strasa.middleware.mapper.other.ExtensionDataSummaryMapper;
import org.strasa.middleware.mapper.other.StudySummaryMapper;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.ExtensionData;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.StudySite;
import org.strasa.web.browsestudy.view.model.StudySearchFilterModel;
import org.strasa.web.browsestudy.view.model.StudySearchResultModel;
import org.strasa.web.browsestudy.view.model.StudySummaryModel;
import org.strasa.web.extensiondata.view.model.ExtensionDataListModel;
import org.strasa.web.extensiondata.view.model.ExtensionDataSummaryModel;
import org.strasa.web.extensiondata.view.model.SummaryModel;
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
	
/*	public List<ExtensionDataSummaryModel> getCountOfGermplasmByCountrRealease() {
		
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataSummaryMapper mapper = session.getMapper(ExtensionDataSummaryMapper.class);
		List<ExtensionDataSummaryModel> s= new ArrayList<ExtensionDataSummaryModel>();
		try{

			List<ExtensionDataSummaryModel> toreturn= mapper.selectExtentionDataSummaryByCountryRelease();

			return toreturn;

		}finally{
			session.close();
		}


	}*/
	
/*	public List<ExtensionDataSummaryModel> getCountOfGermplasmByYear() {
		
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataSummaryMapper mapper = session.getMapper(ExtensionDataSummaryMapper.class);
		List<ExtensionDataSummaryModel> s= new ArrayList<ExtensionDataSummaryModel>();
		try{

			List<ExtensionDataSummaryModel> toreturn= mapper.selectExtentionDataSummaryByYear();

			return toreturn;

		}finally{
			session.close();
		}


	}*/
	
/*	public List<ExtensionDataListModel> getExtensionDataList() {
		
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataSummaryMapper mapper = session.getMapper(ExtensionDataSummaryMapper.class);
		List<ExtensionDataSummaryModel> s= new ArrayList<ExtensionDataSummaryModel>();
		try{

			List<ExtensionDataListModel> toreturn= mapper.selectExtentionDataList();

			return toreturn;

		}finally{
			session.close();
		}


	}*/
	public List<SummaryModel> getAreaSummaryGermplasmByYearandCountryExtension(){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataSummaryMapper mapper = session.getMapper(ExtensionDataSummaryMapper.class);
		List<SummaryModel> s= new ArrayList<SummaryModel>();
		try{
			List<SummaryModel> toreturn= mapper.selectAreaSummaryGermplasmByYearandCountryExtension();

			return toreturn;

		}finally{
			session.close();
		}
	}
	
	public List<SummaryModel> getAreaSummaryGermplasmByYear(){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataSummaryMapper mapper = session.getMapper(ExtensionDataSummaryMapper.class);
		List<SummaryModel> s= new ArrayList<SummaryModel>();
		try{
			List<SummaryModel> toreturn= mapper.selectAreaSummaryGermplasmByYear();

			return toreturn;

		}finally{
			session.close();
		}
	}
	
	public List<SummaryModel> getAreaSummaryGermplasmByCountryExtension(){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataSummaryMapper mapper = session.getMapper(ExtensionDataSummaryMapper.class);
		List<SummaryModel> s= new ArrayList<SummaryModel>();
		try{
			List<SummaryModel> toreturn= mapper.selectAreaSummaryGermplasmByCountryExtension();

			return toreturn;

		}finally{
			session.close();
		}
	}
	
	public List<SummaryModel> getNoOfVarietyReleaseByCountryAndYear(){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataSummaryMapper mapper = session.getMapper(ExtensionDataSummaryMapper.class);
		List<SummaryModel> s= new ArrayList<SummaryModel>();
		try{
			List<SummaryModel> toreturn= mapper.selectNoOfVarietyReleaseByCountryAndYear();
			return toreturn;

		}finally{
			session.close();
		}
	}
	
	public List<SummaryModel> getNoOfVarietyReleaseByCountryRelease(){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataSummaryMapper mapper = session.getMapper(ExtensionDataSummaryMapper.class);
		List<SummaryModel> s= new ArrayList<SummaryModel>();
		try{
			List<SummaryModel> toreturn= mapper.selectNoOfVarietyReleaseByCountryRelease();
			return toreturn;

		}finally{
			session.close();
		}
	}
	
	public List<SummaryModel> getNoOfVarietyReleaseByYear(){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		ExtensionDataSummaryMapper mapper = session.getMapper(ExtensionDataSummaryMapper.class);
		List<SummaryModel> s= new ArrayList<SummaryModel>();
		try{
			List<SummaryModel> toreturn= mapper.selectNoOfVarietyReleaseByYear();
			return toreturn;

		}finally{
			session.close();
		}
	}

}
