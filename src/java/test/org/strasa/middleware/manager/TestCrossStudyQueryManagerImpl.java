package org.strasa.middleware.manager;

import java.util.ArrayList;
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
import org.strasa.web.crossstudyquery.view.model.CrossStudyQueryFilterModel;

public class TestCrossStudyQueryManagerImpl {


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
	public void testGetCrossStudyQueryResult() throws Exception {
		final CrossStudyQueryManagerImpl crossStudyQueryManagerImpl= new CrossStudyQueryManagerImpl(); 

		ArrayList<CrossStudyQueryFilterModel> filters = new ArrayList<CrossStudyQueryFilterModel>();

		// default column
		CrossStudyQueryFilterModel f1= new CrossStudyQueryFilterModel();
		f1.setVariable("studyid");
		f1.setColumnRemark("default");
		
		CrossStudyQueryFilterModel f2= new CrossStudyQueryFilterModel();
		f2.setVariable("datarow");
		f2.setColumnRemark("default");
		
		CrossStudyQueryFilterModel f3= new CrossStudyQueryFilterModel();
		f3.setVariable("studyname");
		f3.setColumnRemark("default");
		
		CrossStudyQueryFilterModel f4= new CrossStudyQueryFilterModel();
		f4.setVariable("GName");
		f4.setColumnRemark("default");
		
		
		
		// query variable
		CrossStudyQueryFilterModel f5= new CrossStudyQueryFilterModel();
		f5.setVariable("Yld");
		f5.setValueDouble(7.2);
		f5.setOperator(null);
		f5.setDataType("Number");
		f5.setColumnRemark("filter");
		f5.setOperator("greaterthan");
		
		CrossStudyQueryFilterModel f6= new CrossStudyQueryFilterModel();
		f6.setVariable("Yld");
		f5.setValueDouble(7.5);
		f6.setOperator(null);
		f6.setDataType("Number");
		f6.setOrderCriteria("last");
		f6.setColumnRemark("filter");
		f5.setOperator("lessthan");
		
		

		
		
		filters.add(f1);
		filters.add(f2);
		filters.add(f3);
		filters.add(f4);
		filters.add(f5);
		filters.add(f6);


		List<HashMap<String,String>> toreturn = crossStudyQueryManagerImpl.getCrossStudyQueryResult(filters);
		System.out.println("Size:"+toreturn.size());
	
		//Column Header
		for (CrossStudyQueryFilterModel d: filters) {
			System.out.print(d.getVariable()+ "\t");
		}
		System.out.println("\n ");
		for( HashMap<String,String> rec:toreturn){
			for (CrossStudyQueryFilterModel d: filters) {
				String value= String.valueOf(rec.get(d.getVariable()));
				System.out.print(value + "\t");
			}
			System.out.println("\n ");
		}

	}

	


}
