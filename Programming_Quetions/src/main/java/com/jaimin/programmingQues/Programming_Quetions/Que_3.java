package com.jaimin.programmingQues.Programming_Quetions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Que_3 {
	public static void main(String args[]) throws Exception {
		JSONParser jsonparser = new JSONParser();
		
		File dir = new File("/home/jaiminrana/Downloads/Problem_Input/3/AmazonMed_Json");
		File[] file = dir.listFiles();
		
		for(int i=0;i<file.length;i++) {
			try (FileReader reader = new FileReader(file[i])) {
				Object obj = jsonparser.parse(reader);
				
				if(file[i] == null) {
					System.out.println("File is empty!!");
				}
				
				JSONObject jsonobj = (JSONObject)obj;
				
				JSONArray array = (JSONArray)jsonobj.get("Entities");
				
				for(int j=0;j<array.size();j++) {
					JSONObject forscore = (JSONObject)array.get(j);
					
					if((double)forscore.get("Score") < 0.9) {
						System.out.println(forscore.get("Text"));
					}
				}							
			}
			
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}
}
