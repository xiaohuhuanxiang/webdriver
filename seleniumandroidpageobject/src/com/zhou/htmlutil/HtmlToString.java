package com.zhou.htmlutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class HtmlToString {

	private static String ENCODE = "GBK";  
	
	public  static String openFile( String szFileName ) {  
        try {  
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream( new File(szFileName)), ENCODE) );  
            String szContent="";  
            String szTemp;  
              
            while ( (szTemp = bis.readLine()) != null) {  
                szContent+=szTemp+"\n";  
            }  
            bis.close();  
            return szContent;  
        }  
        catch( Exception e ) {  
            return "";  
        }  
    }  
 
	public static void main(String[] args) {
	String str="test-output/emailable-report2.html";
	System.out.println(new File(str).getAbsolutePath());
	}

}
