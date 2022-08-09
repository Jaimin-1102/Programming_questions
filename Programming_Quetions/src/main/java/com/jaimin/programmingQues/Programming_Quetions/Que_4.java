package com.jaimin.programmingQues.Programming_Quetions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Que_4 {

	public static void main(String[] args) {
		File dir = new File("/home/jaiminrana/Downloads/Problem_Input/4/");
		File[] file = dir.listFiles();
		
		BufferedReader reader = null;
		String line = "";
		
		try {
			for(int i=0;i<file.length;i++) {
				
				reader = new BufferedReader(new FileReader(file[i]));
				int index = 0;
				int iteration = 0;
				double sum = 0;
				while((line = reader.readLine()) != null) {
					
					String[] row;
					
					if(file[i].getName().endsWith(".csv")) {
						row = line.split(",");						
					}
					else {
						row = line.split("\t");	
					}
					
					for(int k=0;k<row.length;k++) {
						if("Amount".equals(row[k])) {
							index = k;
						}
					}
					
					if(iteration == 0) {
						iteration++;
						continue;
					}
					
					for(int j=0;j<row.length;j++) {
						if(j == index) {
							sum += Double.parseDouble(row[index]);
						}
					}
				}
				
				System.out.println(sum);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
