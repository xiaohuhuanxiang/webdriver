package com.zhou.htmlutil;

import java.io.BufferedReader;  
import java.io.InputStreamReader;  
import java.io.FileInputStream;  
import java.io.File;  
import java.net.HttpURLConnection;  
import java.net.URL;  
  
import org.htmlparser.visitors.TextExtractingVisitor;  
  
import org.htmlparser.Parser;
 
public class Test {

	private static String ENCODE = "GBK";  
    private static void message( String szMsg ) {  
        try{System.out.println(new String(szMsg.getBytes(ENCODE), System.getProperty("file.encoding"))); } catch(Exception e ){}  
    }  
    public static String openFile( String szFileName ) {  
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
		
		String szFileName ="C:/Users/zhoupp/workspace/seleniumandroid/test-output/emailable-report2.html";
		String szContent = openFile(szFileName);  
		System.out.println(szContent);
        try{  
            Parser parser = Parser.createParser(szContent, ENCODE);  
            //Parser parser = new Parser( szContent );  
          // Parser parser = new Parser( (HttpURLConnection) (new URL("http://127.0.0.1:8080/HTMLParserTester.html")).openConnection() );  
          
            TextExtractingVisitor visitor = new TextExtractingVisitor();  
            parser.visitAllNodesWith(visitor);  
            String textInPage = visitor.getExtractedText();  
            //System.out.println(textInPage);
           // message(textInPage);  
        }  
        catch( Exception e ) {              
        }  

	}

}
