package com.jaimin.programmingQues.Programming_Quetions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ques_11 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = null;
		String str = "";
		
		try {
			File file = new File("/home/jaiminrana/Downloads/Problem_Input/11/TextDocument");
			br = new BufferedReader(new FileReader(file));
			Pattern p = Pattern.compile("((((BMI\\s?\\(Body mass index\\)|BMI|BMI\\s?\\(body mass index\\)|BMI\\s?\\(Body Mass Index\\)|Body Mass Index\\s?\\(BMI\\)|Body mass index\\s?\\(BMI\\)|body mass index\\s?\\(BMI\\)|Body Mass Index|Body mass index|body mass index)(\\s|\\W|[a-z])+)|BMI)((\\w|\\.|\\/|\\-)+ to (\\w|\\.|\\/|\\-)+)|(((BMI\\s?\\(Body mass index\\)|BMI|BMI\\s?\\(body mass index\\)|BMI\\s?\\(Body Mass Index\\)|Body Mass Index\\s?\\(BMI\\)|Body mass index\\s?\\(BMI\\)|body mass index\\s?\\(BMI\\)|Body Mass Index|Body mass index|body mass index)(\\s|\\W|[a-z])+)|BMI)((\\w|\\.|\\/|\\-)+))");
			
			while((str = br.readLine()) != null) {
				Matcher m = p.matcher(str);
				while(m.find()) {
					System.out.println(str.substring(m.start(), m.end()));
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		finally {
			br.close();
		}
	}

}
