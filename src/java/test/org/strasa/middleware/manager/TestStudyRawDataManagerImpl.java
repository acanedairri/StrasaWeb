package org.strasa.middleware.manager;

import java.util.ArrayList;

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
		StudyRawDataManagerImpl studyRawDataManagerImpl= new StudyRawDataManagerImpl();
		ArrayList<StudyRawDataByDataColumn> list= (ArrayList<StudyRawDataByDataColumn>) studyRawDataManagerImpl.getStudyRawDataColumn(1,"GName");
		for(StudyRawDataByDataColumn s:list){
			System.out.println(s.getStudyid()+ " "+s.getDatacolumn()+ " "+ s.getDatavalue());
		}
	}
	


}
