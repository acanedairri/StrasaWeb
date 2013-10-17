package org.strasa.middleware.manager;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strasa.middleware.model.StudySiteByStudy;

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
	public void testGetStudySiteByStudy() throws Exception {

		StudyRawDataManagerImpl studyRawDataManagerImpl= new StudyRawDataManagerImpl();
		
		ArrayList<StudySiteByStudy> list= (ArrayList<StudySiteByStudy>) studyRawDataManagerImpl.getStudyRawDataSite(1);
		
		for(StudySiteByStudy s:list){
			System.out.println(s.getStudyid()+ " "+s.getDatacolumn()+ " "+ s.getDatavalue());
		}
		
	}


}
