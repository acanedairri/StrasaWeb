package org.strasa.middleware.manager;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.web.browsestudy.view.model.StudySearchFilterModel;
import org.strasa.web.browsestudy.view.model.StudySearchResultModel;
import org.strasa.web.browsestudy.view.model.StudySummaryModel;

public class TestBrowseStudyManagerImpl {


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
		final BrowseStudyManagerImpl studyQueryManagerImpl= new BrowseStudyManagerImpl(); 

		List<StudySummaryModel> s= studyQueryManagerImpl.getStudySummary();
		System.out.println("Size:"+s.size());

		for(StudySummaryModel d:s){
			System.out.println(d.toString());
		}

	}


	@Test
	public void testGetStudySearchResult() throws Exception {
		final BrowseStudyManagerImpl browseStudyManagerImpl= new BrowseStudyManagerImpl(); 

		StudySearchFilterModel filter = new StudySearchFilterModel();
		//		filter.setStudyname("Study1");
		//		filter.setStudytypeid(4);
		//		filter.setProjectid(5);
		//		filter.setProgramid(2);
		//		filter.setStartyear("2010");
		//		filter.setEndyear("2012");
		//		filter.setLocationid(1);
		//		filter.setCountry("PHIL");
		filter.setProgramid(1);
		filter.setStudytypeid(3);

		List<StudySearchResultModel> toreturn= browseStudyManagerImpl.getStudySearchResult(filter);
		System.out.println("Size:"+toreturn.size());

		for(StudySearchResultModel rec:toreturn){
			System.out.println(rec.toString() +"\n");
		}

	}

	@Test
	public void testGetStudyRawData() throws Exception {

		final BrowseStudyManagerImpl browseStudyManagerImpl= new BrowseStudyManagerImpl(); 

		browseStudyManagerImpl.getStudyRawData(1);

		List<HashMap<String,String>> toreturn = browseStudyManagerImpl.getStudyRawData(1);
		System.out.println("Size:"+toreturn.size());
		List<StudyDataColumn> columns= new StudyDataColumnManagerImpl().getStudyDataColumnByStudyId(1,"rd"); // rd as raw data, dd as derived data
		//Column Header
		for (StudyDataColumn d: columns) {
			System.out.print(d.getColumnheader()+ "\t");
		}
		System.out.println("\n ");
		for( HashMap<String,String> rec:toreturn){
			for (StudyDataColumn d: columns) {
				String value= rec.get(d.getColumnheader());
				System.out.print(value + "\t");
			}
			System.out.println("\n ");
		}

	}

	@Test
	public void testGetStudyDerivedData() throws Exception {

		final BrowseStudyManagerImpl browseStudyManagerImpl= new BrowseStudyManagerImpl(); 

		browseStudyManagerImpl.getStudyRawData(1);

		List<HashMap<String,String>> toreturn = browseStudyManagerImpl.getStudyRawData(1);
		System.out.println("Size:"+toreturn.size());
		List<StudyDataColumn> columns= new StudyDataColumnManagerImpl().getStudyDataColumnByStudyId(1,"dd"); // rd as raw data, dd as derived data
		//Column Header
		for (StudyDataColumn d: columns) {
			System.out.print(d.getColumnheader()+ "\t");
		}
		System.out.println("\n ");
		for( HashMap<String,String> rec:toreturn){
			for (StudyDataColumn d: columns) {
				String value= rec.get(d.getColumnheader());
				System.out.print(value + "\t");
			}
			System.out.println("\n ");
		}

	}


}
