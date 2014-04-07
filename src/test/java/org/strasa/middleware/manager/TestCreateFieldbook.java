package org.strasa.middleware.manager;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyVariable;
import org.strasa.web.createfieldbook.view.pojos.SiteInformationModel;

public class TestCreateFieldbook {

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
		System.out.println("#####" + ": Elapsed Time = " + elapsedTime + " ns = " + ((double) elapsedTime / 1000000000) + " s");
	}

	@Test
	public void testCreateFieldBook() throws Exception {

		Study study = new Study();
		study.setName("testStudy");
		study.setProgramid(1);
		study.setProjectid(1);
		File genotype = new File(this.getClass().getResource("/org/strasa/middleware/manager/resources/genotype.xls").getFile());
		File layout = new File(this.getClass().getResource("/org/strasa/middleware/manager/resources/layout.xls").getFile());

		ArrayList<SiteInformationModel> lstSiteInfo = new ArrayList<SiteInformationModel>();
		SiteInformationModel siteInfo = new SiteInformationModel();
		for (int i = 0; i < 2; i++) {
			siteInfo.setSitename("Site " + i);
			siteInfo.setSitelocation("Loc " + i);

			siteInfo.setFileGenotype(genotype);
			siteInfo.setFileLayout(layout);

			for (int k = 0; k < 5; k++) {
				StudyVariable var = new StudyVariable();
				var.setVariablecode("Var " + k);
				siteInfo.lstStudyVariable.add(var);
			}

			lstSiteInfo.add(siteInfo);
		}
		CreateFieldBookManagerImpl genMan = new CreateFieldBookManagerImpl(lstSiteInfo, study, new File("C:\\"));

		genMan.generateFieldBook();
	}

}
