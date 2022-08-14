package com.jaimin.programmingQues.Programming_Quetions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ques_9 {

	public static Set<String> getValues(File file)
			throws ParserConfigurationException, SAXException, IOException {
		Set<String> list = new HashSet<>();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);

		doc.getDocumentElement().normalize();

		NodeList nodeList = doc.getElementsByTagName("code");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			list.add(element.getAttribute("value"));
		}

		return list;
	}
	
	public static void extractMatch(Set<String> s1, Set<String> s2) {
		Set<String> intersection = new HashSet<String>(s1);
		intersection.retainAll(s2);
		
		System.out.print("Match: ");
		System.out.println(intersection);
		System.out.println("Match-count: " + intersection.size());
	}
	
	public static void extractMissing(Set<String> s1, Set<String> s2) {
		Set<String> Missing = new HashSet<String> (s1);
		Missing.removeAll(s2);
		
		System.out.print("Missing: ");
		System.out.println(Missing);
		System.out.println("Missing-count: " + Missing.size());
	}
	
	public static void extractExtra(Set<String> s1, Set<String> s2) {
		Set<String> Extra = new HashSet<String> (s2);
		Extra.removeAll(s1);
		
		System.out.print("Extra: ");
		System.out.println(Extra);
		System.out.println("Extra-count: " + Extra.size());
	}
	
	public static void notFoundEqual(File[] f1, File[] f2) {
		Set<String> fileNotEqual = new HashSet<>();
		boolean isEqual = false;
		
		for(File file1: f1) {
			for(File file2: f2) {
				if(file1.getName().equals(file2.getName())) {
					isEqual = true;
				}
			}
			
			if(isEqual == false) {
				fileNotEqual.add(file1.getName());
			}
		}
		
		isEqual = false;
		
		for(File file2: f2) {
			for(File file1: f1) {
				if(file2.getName().equals(file1.getName())) {
					isEqual = true;
				}
			}
			
			if(isEqual == false) {
				fileNotEqual.add(file2.getName());
			}
		}
		
		System.out.println("These files' names are not equal. \n");
		for(String fileName: fileNotEqual) {
			System.out.println(fileName);
		}
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		File[] files1 = new File("/home/jaiminrana/Downloads/Problem_Input/9/CM1").listFiles();
		File[] files2 = new File("/home/jaiminrana/Downloads/Problem_Input/9/CM2").listFiles();
		Set<String> list1 = new HashSet<>();
		Set<String> list2 = new HashSet<>();

		for (File f1 : files1) {
			for (File f2 : files2) {
				
				if (f1.getName().equals(f2.getName())) {
					System.out.println("File-Name:  " + f1.getName()+"\n");
					
					list1 = getValues(f1);
					list2 = getValues(f2);
					
					extractMatch(list1,list2);
					extractMissing(list1,list2);
					extractExtra(list1,list2);
					System.out.println();
					System.out.println();
				}				
			}
		}
		
		notFoundEqual(files1,files2);
		
	}

}
