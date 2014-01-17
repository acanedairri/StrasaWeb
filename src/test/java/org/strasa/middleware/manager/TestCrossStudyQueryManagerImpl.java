package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strasa.web.crossstudyquery.view.model.CrossStudyQueryFilterModel;
import org.strasa.web.crossstudyquery.view.model.CrossStudyQueryOperator;

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

		// Field
		CrossStudyQueryFilterModel f1= new CrossStudyQueryFilterModel();
		f1.setVariable("studyid");
		f1.setColumnAs("field");

		CrossStudyQueryFilterModel f2= new CrossStudyQueryFilterModel();
		f2.setVariable("datarow");
		f2.setColumnAs("field");

		CrossStudyQueryFilterModel f3= new CrossStudyQueryFilterModel();
		f3.setVariable("studyname");
		f3.setColumnAs("field");

		CrossStudyQueryFilterModel f4= new CrossStudyQueryFilterModel();
		f4.setVariable("GName");
		f4.setColumnAs("field");

		CrossStudyQueryFilterModel f4a= new CrossStudyQueryFilterModel();
		f4a.setVariable("PH");
		f4a.setColumnAs("field");
		f4a.setOrderCriteria("last");
//		
//		CrossStudyQueryFilterModel f4b= new CrossStudyQueryFilterModel();
//		f4b.setVariable("Site");
//		f4b.setColumnAs("field");
//
//
//		CrossStudyQueryFilterModel f5a= new CrossStudyQueryFilterModel();
//		f5a.setVariable("Yld");
//		f5a.setColumnAs("field");
//		f5a.setOrderCriteria("last");


		// Filters
		CrossStudyQueryFilterModel f5= new CrossStudyQueryFilterModel();
		f5.setVariable("PH");
		f5.setValueDouble(70);
		f5.setDataType("Number");
		f5.setColumnAs("filter");
		f5.setOperator(CrossStudyQueryOperator.GREATER_THAN_EQUAL);

		CrossStudyQueryFilterModel f6= new CrossStudyQueryFilterModel();
		f6.setVariable("YLD");
		f6.setValueDouble(5);
		f6.setDataType("Number");
		f6.setColumnAs("filter");
		f6.setOrderCriteria("last");
		f6.setOperator(CrossStudyQueryOperator.GREATER_THAN);


		filters.add(f1);
		filters.add(f2);
		filters.add(f3);
		filters.add(f4);
		filters.add(f4a);
//		filters.add(f4b);
//		filters.add(f5a);
		filters.add(f5);
		filters.add(f6);
		


		List<HashMap<String,String>> toreturn = crossStudyQueryManagerImpl.getCrossStudyQueryResult(filters,"dd");
		System.out.println("Size:"+toreturn.size());

		//Column Header
		for (CrossStudyQueryFilterModel d: filters) {
			if(d.getColumnAs().equals("field")){
				System.out.print(d.getVariable()+ "\t");
			}
		}
		System.out.println("\n ");
		for( HashMap<String,String> rec:toreturn){
			for (CrossStudyQueryFilterModel d: filters) {
				if(d.getColumnAs().equals("field")){
					String value= String.valueOf(rec.get(d.getVariable()));
					System.out.print(value + "\t");
				}
			}
			System.out.println("\n ");
		}

	}




}
