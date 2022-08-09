package com.jaimin.programmingQues.Programming_Quetions;

import java.io.*;
import java.nio.file.*;

public class Que_1 {
	public static void main(String args[]) {
		
		try(BufferedReader br = new BufferedReader(new FileReader("/home/jaiminrana/Downloads/Problem_Input/1/DeleteFiles.txt"))) {
			String str;
			int count = 0;
			while((str = br.readLine()) != null) {
				 if(Files.deleteIfExists(Paths.get("/home/jaiminrana/Downloads/Problem_Input/1/InputFolder/"+str))) {
					 System.out.println("File deleted Successfully");
				 }
				 
				 else if(Files.deleteIfExists(Paths.get("/home/jaiminrana/Downloads/Problem_Input/1/InputFolder/2/"+str))) {
					 System.out.println("File deleted Successfully");
				 }
				 
				 else if(Files.deleteIfExists(Paths.get("/home/jaiminrana/Downloads/Problem_Input/1/InputFolder/1/"+str))) {
					 System.out.println("File deleted Successfully");
				 }
				 
				 else {
					 System.out.println("Failed to delete the file at this path.");
				 }
				 
				 count++;
			}
			
			System.out.println("\n\nTotal " + count + " deleted..");
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
}
