package org.strasa.middleware.manager;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyRawDataBatch;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyGermplasm;
import org.strasa.middleware.model.StudyRawDataByDataColumn;
import org.strasa.middleware.model.StudySite;

import au.com.bytecode.opencsv.CSVReader;

public class TestStudyRawDataManagerImpl {


	private long startTime;
	

	@BeforeClass
	public static void setUp() throws Exception {

	}

	@Before
	public void beforeEachTest() {
		startTime = System.nanoTime();
	}
	
	@After
	public void afterEachTest() {
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("#####" + ": Elapsed Time = " + elapsedTime + " ns = " + ((double) elapsedTime/1000000000) + " s");
	}
	
	@Test
	public void testGetStudyRawDataColumn() throws Exception {
		StudyRawDataManagerImpl studyRawDataManagerImpl= new StudyRawDataManagerImpl(true);
		ArrayList<StudyRawDataByDataColumn> list= (ArrayList<StudyRawDataByDataColumn>) studyRawDataManagerImpl.getStudyRawDataColumn(1,"GName");
		for(StudyRawDataByDataColumn s:list){
			System.out.println(s.getStudyid()+ " "+s.getDatacolumn()+ " "+ s.getDatavalue());
		}
	}
	
	@Test
	public void testBuildColumnRaw() throws Exception {
		StudyRawDataManagerImpl studyRawDataManagerImpl= new StudyRawDataManagerImpl(true);
		ArrayList<ArrayList<String>> list= studyRawDataManagerImpl.constructDataRaw(122, new String[]{"Location","Country","Province","Region","Altitude","Latitude","WeatherStation"}, "Location",true);
		
		 System.out.println(list.size());
	}
	@Test
	public void testNewBuildColumnRaw() throws Exception {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataBatch mapper = session.getMapper(StudyRawDataBatch.class);
		 List<StudySite> lstData = mapper.getRawSite(129, "studyrawdata");
		 System.out.println(lstData.size());
		 for(StudySite loc : lstData){
			 System.out.println(loc.toString());
		 }
	}
	
	@Test
	public void testGermplasmRaw() throws Exception{
		System.out.println("Start");
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataBatch mapper = session.getMapper(StudyRawDataBatch.class);
		 List<StudyGermplasm> lstData = mapper.getRawGermplasm(60, "studyrawdata");
		 System.out.println(lstData.size());
		 for(StudyGermplasm loc : lstData){
			 System.out.println(loc.toString());
		 }
	}
	@Test
	public void testSiteRaw() throws Exception{
		System.out.println("Start");
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyRawDataBatch mapper = session.getMapper(StudyRawDataBatch.class);
		 List<StudySite> lstData = mapper.getRawSite(60, "studyrawdata");
		 System.out.println(lstData.size());
		 for(StudySite loc : lstData){
			 System.out.println(loc.toString());
		 }
	}
	@Test
	public void testLargeDataInsert() throws Exception{
		StudyRawDataManagerImpl studyRawDataManagerImpl= new StudyRawDataManagerImpl(true);
		CSVReader csvMaster = new CSVReader(new FileReader(new File("/home/m00g33k/dumps/SaltSample3.csv")));
		Study study = new Study();
		study.setDescription("Sample");
		study.setName("SampleAgain");
		study.setUserid(1);
		studyRawDataManagerImpl.addStudyRawDataByRawCsvList(study, csvMaster.readAll());
	}
	

}
