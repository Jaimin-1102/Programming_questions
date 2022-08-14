package com.jaimin.programmingQues.Programming_Quetions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ques_10 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		
		try {
			File file1 = new File("/home/jaiminrana/Downloads/Problem_Input/10/Equations");
			File file2 = new File("/home/jaiminrana/Downloads/Problem_Input/10/LatestIcd10Codes");
			
			 br1 = new BufferedReader(new FileReader(file1));
			 br2 = new BufferedReader(new FileReader(file2));
			
			String str = "";
			String colstr = "";
			int count = 0;
			Pattern p = Pattern.compile("[a-zA-Z0-9]+\\.\\*");
			List<String> ptrn = new ArrayList<> ();
			
			while((str = br1.readLine()) != null) {
				String tempstr = str;
				Matcher m = p.matcher(str);	
				while(m.find()) {
					while((colstr = br2.readLine()) != null) {
						if(colstr.startsWith(str.substring(m.start(),m.end()-2))) {
							count++;
							tempstr = str.replaceAll("[a-zA-Z0-9]+\\.\\*", colstr);
							System.out.println(tempstr);
						}
					}
					
					ptrn.add(str.substring(m.start(), m.end()));
				}
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			br1.close();
			br2.close();
		}
	}

}
