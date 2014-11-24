package org.strasa.middleware.factory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MariaDBConnectionSettings {
	private static String databaseURL = "";

	private static String user = "";
	private static String password = "";

	private static void getXMLValues() {
		try {
			URL path = MariaDBConnectionSettings.class.getClassLoader().getResource("SqlMapConfig.xml");
			System.out.println(path.toString());

			File fXmlFile = new File(path.getFile());
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;

			builder = factory.newDocumentBuilder();

			Document doc = builder.parse(path.getFile());
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile("/configuration/environments/environment/dataSource/property");
			NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getAttributes().item(0).getNodeValue().equals("url"))
					databaseURL = node.getAttributes().item(1).getNodeValue();
				if (node.getAttributes().item(0).getNodeValue().equals("username"))
					user = node.getAttributes().item(1).getNodeValue();
				if (node.getAttributes().item(0).getNodeValue().equals("password"))
					password = node.getAttributes().item(1).getNodeValue();

			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getDatabaseURL() {
		if (databaseURL.isEmpty()) {
			getXMLValues();
		}

		return databaseURL;
	}

	public static String getUsername() {
		if (user.isEmpty()) {
			getXMLValues();
		}

		return user;
	}

	public static String getPassword() {
		if (password.isEmpty()) {
			getXMLValues();
		}
		return password;
	}

}
