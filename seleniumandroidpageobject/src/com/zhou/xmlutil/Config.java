package com.zhou.xmlutil;

import java.io.File;
import java.util.HashMap;


import com.zhou.xmlutil.ParserXml2;

public class Config {

	private static HashMap<String, String> configMap = null;
	private static String xmlPath="config/config.xml";
	



    
	private static synchronized void getConfigMap() {
		if (configMap == null) {
			ParserXml2 p = new ParserXml2();
			configMap = p.parser2Xml(new File(xmlPath)
					.getAbsolutePath());
		}
	}

	public static String getConfig(String key) {
		String value = null;
		if (configMap == null)
			Config.getConfigMap();
		if (configMap.containsKey(key)) {
			value = configMap.get(key);
		} else
			System.out.println( key+" is not exist in config.xml");//��������
		return value;
	}
	
	public static int Str2Int(String str){
		return Integer.parseInt(str);
	}
	public static void main(String[] args) {
		
		String value = Config.getConfig("waitTime");
		System.out.println(value);//10

	}

}
