package com.jaimin.programmingQues.Programming_Quetions;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Ques_5 {

	public static void main(String[] args) {
		try {
			
			File file = new File("/home/jaiminrana/Downloads/Problem_Input/5/Bobby J Baca_394099_9.3.19_Las Cruces.txt.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			
			doc.getDocumentElement().normalize();
			
			NodeList nodeList = doc.getElementsByTagName("Icd10CmCode");
			
			for(int i=0;i<nodeList.getLength();i++) {
				int max = 0;
				String value = "";
				Node childNode = nodeList.item(i);
				if(childNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)childNode;
					
					NodeList codeList = element.getElementsByTagName("code");
					
					for(int j=0;j<codeList.getLength();j++) {
						Element element1 = (Element)codeList.item(j);
						if(element1.getNodeName() == "code") {
							int rank = Integer.parseInt(element1.getAttribute("rank"));
							if(max < rank) {
								max = rank;
								value = element1.getAttribute("value");
							}
							
						}
					}
					
//				    System.out.println();
//				    System.out.println(count);
				}
				System.out.println("value: " + value);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
