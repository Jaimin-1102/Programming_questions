package com.jaimin.programmingQues.Programming_Quetions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Que_2 {

	public static void main(String[] args) {
		File dir = new File("/home/jaiminrana/Downloads/Problem_Input/2");
		File[] file = dir.listFiles();
		String str = "^[tT]he(\\s|[0-9]|[^a-zA-z]|\\b|\\W)";
		Pattern pat = Pattern.compile(str);
		int count = 0;
		
		for(int i=0;i<file.length;i++) {
			try(BufferedReader br = new BufferedReader(new FileReader(file[i]))) {
				
				String str1;
				while((str1 = br.readLine()) != null) 
				{
					Matcher mat = pat.matcher(str1);
					if(mat.find())
					{
						count++;
					}
					
				}	
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
		System.out.println("Total count starting with \'The\' --> "+count);
	}

}
