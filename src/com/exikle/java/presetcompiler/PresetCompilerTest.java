package com.exikle.java.presetcompiler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PresetCompilerTest {

	private String[] sList;

	private boolean[] paid;

	private Map<String, Map<String, Double>> sports;

	private File fXmlFile;

	private DocumentBuilderFactory dbFactory;

	private DocumentBuilder dBuilder;

	private Document doc;

	public PresetCompilerTest(String presetFile) {
		fXmlFile = new File(presetFile);
		init();

		NodeList nList = doc.getElementsByTagName("sport");
		sList = new String[nList.getLength()];
		paid = new boolean[nList.getLength()];

		for (int t = 0; t < nList.getLength(); t++) {

			Node nNode = nList.item(t);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				String sportName = eElement.getAttribute("name");

				sList[t] = eElement.getAttribute("name");// sport name
				paid[t] = Boolean.parseBoolean(eElement
						.getAttribute("paid")); // whether it is a pay-for use sport

				sports.put(sportName, createPresets(eElement));

			}
		}
	}

	private void init() {
		sports = new HashMap<String, Map<String, Double>>();
		dbFactory = DocumentBuilderFactory.newInstance();
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}
	}

	private Map<String, Double> createPresets(Element elem) {

		NodeList flowList = elem.getElementsByTagName("preset");
		Map<String, Double> presets = new HashMap<String, Double>();
		for (int i = 0; i < flowList.getLength(); i++) {
			NodeList childList = flowList.item(i).getChildNodes();
			for (int j = 0; j < childList.getLength(); j++) {
				Element e = (Element) flowList.item(i);
				presets.put(e.getAttribute("name"),
						Double.parseDouble(childList.item(j)
								.getNodeValue()));
			}
		}
		return presets;
	}

	public static void main(String[] args) {
		new PresetCompilerTest("sports.xml");

	}
}
