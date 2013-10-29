package org.strasa.middleware.manager;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.other.StudySummaryModel;

public class TestStudyQueryManagerImpl {


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
	public void testGetStudySummary() throws Exception {
		final StudyQueryManagerImpl studyQueryManagerImpl= new StudyQueryManagerImpl(); 

		List<StudySummaryModel> s= studyQueryManagerImpl.getStudySummary();
		System.out.println("Size:"+s.size());

		for(StudySummaryModel d:s){
			System.out.println(d.toString());
		}

	}
	
	



}
