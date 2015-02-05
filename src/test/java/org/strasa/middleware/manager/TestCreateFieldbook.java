package org.strasa.middleware.manager;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

import org.apache.ibatis.io.Resources;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyVariable;
import org.strasa.web.createfieldbook.view.pojos.CreateFieldbookTemplateParser;
import org.strasa.web.createfieldbook.view.pojos.SiteInformationModel;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
	public void testFile() throws Exception {
		URL path = TestCreateFieldbook.class.getClassLoader().getResource("SqlMapConfig.xml");
		System.out.println(path.toString());

		File fXmlFile = new File(path.getFile());
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(path.getFile());
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile("/configuration/environments/environment/dataSource/property");
		NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println(node.getAttributes().item(1).getNodeValue());
			// do your stuff
		}
	}

	@Test
	public void readFromExcel() throws Exception {
		InputStream inputXML = Resources.getResourceAsStream("CreateFieldBookConfig.xml");
		XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
		InputStream inputXLS = Resources.getResourceAsStream("SampleTemplateStudy.xls");

		CreateFieldbookTemplateParser templateParser = new CreateFieldbookTemplateParser();

		Map beans = new HashMap();
		beans.put("fbparser", templateParser);
		XLSReadStatus readStatus = mainReader.read(inputXLS, beans);

		System.out.println(templateParser.getSites().get(2).getSitename());
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
		// // CreateFieldBookManagerImpl genMan = new
		// CreateFieldBookManagerImpl(lstSiteInfo, study, new File("C:\\"));
		//
		// genMan.generateFieldBook();
	}

}
