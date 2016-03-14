package com.zhou.run;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.reporters.XMLReporter;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.zhou.mail.SendMail;
import com.zhou.testngutil.CustomListener;
import com.zhou.testngutil.CustomReporter;
import com.zhou.testngutil.EmailableReporter;
import com.zhou.testngutil.TakeScreenShotListener;

public class PosidonRun2 {

	public static void main(String[] args) {
		XmlSuite suite = new XmlSuite();
		suite.setName("mplay_vplay");

		XmlTest test = new XmlTest(suite);
		test.setName("mplay_vplay");//   
		
		
		List<XmlPackage> packages = new ArrayList<XmlPackage>();
		packages.add(new XmlPackage("com.zhou.posidonautotest.vplay"));
		packages.add(new XmlPackage("com.zhou.posidonautotest.mplay"));

		
	
		test.setXmlPackages(packages) ;
		
		
		//
		XmlSuite suite2 = new XmlSuite();
		suite2.setName("navigation");

		XmlTest test2 = new XmlTest(suite2);
		test2.setName("navigation");//   
		
		
		List<XmlPackage> packages2 = new ArrayList<XmlPackage>();
		packages2.add(new XmlPackage("com.zhou.posidonautotest.navigation"));

		test2.setXmlPackages(packages2) ;
		
		//然后你可以将XmlSuite传递给TestNG：
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		suites.add(suite2);
		
		TestNG tng = new TestNG();
		
		//tng.addListener(new TakeScreenShotListener() );//失败时截图
		tng.addListener(new CustomListener() );// 控制台显示 成功失败信息
		tng.addListener(new CustomReporter() );//控制台显示成功失败个数
		tng.addListener(new EmailableReporter() );//修改可发送邮件报告
		
		tng.setXmlSuites(suites);

		tng.run();

		
		 XMLReporter xMLReporter= new XMLReporter();

		 
		 //将emailable-report2.html 邮件发出
		 SendMail sendMail =new SendMail();
		 sendMail.sendMail();


	}

}
