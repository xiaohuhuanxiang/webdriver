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

public class PosidonRun {

	/*
	 
	 <suite name="aotutest">
	<test verbose="2" name="aotutest">
	 <packages>  
            <package name="" />  <!-- name参数为必须 -->  
            <package name="">  
                <include name="" description="" invocation-numbers=""></include>  
                <exclude name=""></exclude>  
            </package>  
        </packages>  
	</test>
	<!--  Default test  -->
	</suite>
	<!--  Default suite  -->

	 */
	public static void main(String[] args) {
		XmlSuite suite = new XmlSuite();
		suite.setName("aotutest");
		System.out.println(suite);//  [Suite: "TmpSuite" ]
		XmlTest test = new XmlTest(suite);
		test.setName("aotutest");//   
		System.out.println(test);//[Test: "TmpTest" verbose:1[parameters:][metagroups:] [included: ][excluded: ]  classes: packages:] 
		
		List<XmlPackage> packages = new ArrayList<XmlPackage>();
		packages.add(new XmlPackage("com.zhou.posidonautotest.vplay"));
		packages.add(new XmlPackage("com.zhou.posidonautotest.mplay"));
		packages.add(new XmlPackage("com.zhou.posidonautotest.navigation"));

		
		System.out.println(packages);// [[XmlClass class=com.zhou.test.TestNGSimpleTest]]
		test.setXmlPackages(packages) ;
		
		
		//然后你可以将XmlSuite传递给TestNG：
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		System.out.println(suites);//[[Suite: "TmpSuite"   [Test: "TmpTest" verbose:1[parameters:][metagroups:] [included: ][excluded: ]  classes:[XmlClass class=com.zhou.test.TestNGSimpleTest]  packages:]  ]]
		TestNG tng = new TestNG();
		
		//tng.addListener(new TakeScreenShotListener() );//失败时截图
		tng.addListener(new CustomListener() );// 控制台显示 成功失败信息
		tng.addListener(new CustomReporter() );//控制台显示成功失败个数
		tng.addListener(new EmailableReporter() );//修改可发送邮件报告
		
		tng.setXmlSuites(suites);
		System.out.println(tng);//org.testng.TestNG@6e2c634b
		tng.run();
		
		//[org.testng.reporters.jq.Main@31221be2, org.testng.reporters.SuiteHTMLReporter@685f4c2e, org.testng.reporters.JUnitReportReporter@3eb07fd3, org.testng.reporters.XMLReporter@2ef1e4fa, [FailedReporter passed=0 failed=0 skipped=0], org.testng.reporters.EmailableReporter2@2b71fc7e]
		System.out.println(tng.getReporters());
		System.out.println(tng.getReporters().size());//6
		
		 XMLReporter xMLReporter= new XMLReporter();
		 System.out.println(xMLReporter.getOutputDirectory());//null
		 
		 //将emailable-report2.html 邮件发出
		 SendMail sendMail =new SendMail();
		 sendMail.sendMail();


	}

}
