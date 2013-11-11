package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strasa.middleware.mapper.StudyRawDataByDataColumnMapper;
import org.strasa.middleware.model.StudyRawDataByDataColumn;

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
		ArrayList<StudyRawDataByDataColumn> list= (ArrayList<StudyRawDataByDataColumn>) studyRawDataManagerImpl.getStudyRawDataColumn(45,"Location");
		for(StudyRawDataByDataColumn s:list){
			System.out.println(s.getStudyid()+ " "+s.getDatacolumn()+ " "+ s.getDatavalue());
		}
	}
	
	@Test
	public void testBuildColumnRaw() throws Exception {
		StudyRawDataManagerImpl studyRawDataManagerImpl= new StudyRawDataManagerImpl(false);
		ArrayList<ArrayList<String>> list= studyRawDataManagerImpl.constructDataRaw(23, new String[]{"GName","Source"}, "Gname",true);
		
		for(ArrayList<String> sublist : list){
			System.out.println(Arrays.toString(sublist.toArray(new String[sublist.size()])));
		}
	}
	
	@Test
	public void testLargeDataInser() throws Exception{
		StudyRawDataManagerImpl studyRawDataManagerImpl= new StudyRawDataManagerImpl(false);
		
		
	}
	

}
