package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strasa.middleware.model.Germplasm;
import org.strasa.web.browsestudy.view.model.StudySearchResultModel;
import org.strasa.web.crossstudyquery.view.model.CrossStudyQueryFilterModel;
import org.strasa.web.crossstudyquery.view.model.CrossStudyQueryOperator;
import org.strasa.web.germplasmquery.view.model.KeyCharacteristicQueryModel;

public class TestBrowseGermplasmManagerImpl {


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
	public void testGetGermplasmKeyCharacteristics() throws Exception {
		final BrowseGermplasmManagerImpl browseStudyManagerImpl= new BrowseGermplasmManagerImpl(); 

		KeyCharacteristicQueryModel keyCriteria= new KeyCharacteristicQueryModel();
		List<String> keyValues=new ArrayList<String>();
		keyValues.add("Salt");
//		keyValues.add("Tungro");
		
		keyCriteria.setCountKeyCriteria(keyValues.size());
		keyCriteria.setKeyValues(keyValues);

		List<Germplasm> toreturn= browseStudyManagerImpl.getGermplasmKeyCharacteristics(keyCriteria);
		System.out.println("Size:"+toreturn.size());

		for(Germplasm rec:toreturn){
			System.out.println(rec.getGermplasmname() +" "+rec.getBreeder());
		}

	}


}
