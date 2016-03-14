package com.zhou.run;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.reporters.XMLReporter;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.zhou.mail.SendMail;
import com.zhou.testngutil.CustomListener;
import com.zhou.testngutil.CustomReporter;
import com.zhou.testngutil.EmailableReporter;
import com.zhou.testngutil.TakeScreenShotListener;

public class Run {
/*
 
 <suite name="aotutest">
<test verbose="2" name="aotutest">
<classes>
<class name="com.zhou.utils.M1_fun_tv_home_cookiesAndLocalStorage"/>
<class name="com.zhou.utils.M1_fun_tv_mplay"/>
<class name="com.zhou.utils.M1_fun_tv_mplay_bigtosmall"/>
<class name="com.zhou.utils.M1_fun_tv_vplay"/>
<class name="com.zhou.utils.M1_fun_tv_vplay_malliance"/>

</classes>
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
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_home_cookiesAndLocalStorage"));
		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_mplay"));
//		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_mplay_bigtosmall"));
//		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_vplay"));
//		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_vplay_malliance"));
//		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_home_user"));
//		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_home_user2"));
//		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_home_user3"));
//		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_home_user4"));
//		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_home_user5"));
//		classes.add(new XmlClass("com.zhou.autotest.M1_fun_tv_home_user6"));
		System.out.println(classes);// [[XmlClass class=com.zhou.test.TestNGSimpleTest]]
		test.setXmlClasses(classes) ;
		
		
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
