package com.jaimin.programmingQues.Programming_Quetions;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ques_6 {

	public static void main(String[] args) throws ParserConfigurationException {

		try {

			File[] file = new File("/home/jaiminrana/Downloads/Problem_Input/6/").listFiles();

			for (File f : file) {

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(f);

				doc.getDocumentElement().normalize();

				HashMap<String, Integer> node = new HashMap<>();

				NodeList nodeList = doc.getElementsByTagName("RelationSet");

				for (int i = 0; i < nodeList.getLength(); i++) {

					Node childNode = nodeList.item(i);

					if (childNode.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) childNode;

						NodeList itemList = element.getChildNodes();

						for (int j = 0; j < itemList.getLength(); j++) {
							Node internalTag = itemList.item(j);

							if (node.containsKey(internalTag.getNodeName())) {
								node.put(internalTag.getNodeName(), node.get(internalTag.getNodeName()) + 1);
							} else {
								node.put(internalTag.getNodeName(), 1);
							}
						}
					}
				}
				System.out.println(node);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
