package com.zhou.autotest.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.zhou.xmlutil.Config;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.zhou.autotest.DriverFactory;
import com.zhou.autotest.M1_fun_tv_home_common;
//m站--》 点击标题中【动漫】---》 下拉---》 点击【全部动漫】----》 检索页（少儿，日本）---》第一个播放----》，检查cookie,localstorage-
//-->后退到频道页---》点击【热点】---》选择第一个播放
import com.zhou.testngutil.CustomListener;
import com.zhou.testngutil.CustomReporter;
import com.zhou.testngutil.EmailableReporter;

// 娱乐--》 娱乐检索页播放---》 新闻---》 搞笑---》搞笑播放
public class M1_fun_tv_home_user9_EntertainmentNewsFunny {
	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_home_user9_EntertainmentNewsFunny.class");
	private M1_fun_tv_home_common m1_fun_tv_home_skip;
	@BeforeTest
	public void setUp() {

		// DriverFactory.getDriver();

		m1_fun_tv_home_skip= new M1_fun_tv_home_common();
	}
	
//	@AfterTest
//	public void tearDown() {
//		DriverFactory.close();
//	}
	
	
	
	@Test
	public void testClickSkip(){
		DriverFactory.open(m1_fun_tv_home_skip.baseurl);
		DriverFactory.sleep();
		m1_fun_tv_home_skip.ClickSkip();
	}
// 想看电影，进入 电影检索页，
	@Test(dependsOnMethods = { "testClickSkip" })   
	public void testEntertainment(){
		DriverFactory.driver.findElement(By.xpath("//a[contains(text(),'娱乐')]")).click();
		DriverFactory.sleep();
		// 查看全部
		
		//Using Action Class 相当于页面滚动下移
		((JavascriptExecutor)DriverFactory.driver).executeScript("scrollTo(0,3000)");
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.id("seeAllBtn")).click();
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.linkText("头条")).click();
		DriverFactory.sleep(1000);

		// 选择左边第一个
		DriverFactory.driver.findElement(By.xpath("//*[@id=\"_retrieve\"]/div/div[1]/a/div[2]/h3")).click();
		
		//刷新页面，防止出现接口异常，视频并没有在播放的情况
		DriverFactory.refresh();
		
		DriverFactory.sleep(12000);
	}
	
	
	@Test(dependsOnMethods = { "testEntertainment" })  
	public void PauseAndPlay(){
		m1_fun_tv_home_skip.PauseAndFullPlay();
	}
	
	//点击下一个后播放
	@Test(dependsOnMethods = { "PauseAndPlay" })  
	public void nextAndPlay(){
		m1_fun_tv_home_skip.PlayNext();
		m1_fun_tv_home_skip.PauseAndFullPlay();
		
	}
	
	//点击热点
	@Test(dependsOnMethods = { "nextAndPlay" })  
	public void news(){
		DriverFactory.sleep(1000);
		m1_fun_tv_home_skip.dropDownUpNavigation("新闻");
		
		//左起第一个图片
		String js="document.getElementsByClassName(\"pic\")[1].click();";
		m1_fun_tv_home_skip.excutejs(js);
		DriverFactory.sleep();
	}
	//选择搞笑
	@Test(dependsOnMethods = { "news" }) 
	public void funny(){
		
m1_fun_tv_home_skip.dropDownUpNavigation("搞笑");
		
		//左起第一个图片
		String js="document.getElementsByClassName(\"pic\")[1].click();";
		m1_fun_tv_home_skip.excutejs(js);
		DriverFactory.sleep(12000);
		
		m1_fun_tv_home_skip.PauseAndFullPlay();
	}
	public static void main(String[] args) {
	 //skipfailedinvocationcounts
		
		XmlSuite suite = new XmlSuite();
		suite.setName("aotutest");
		suite.setSkipFailedInvocationCounts(true);//是否跳过失败的调用
//		suite.setConfigFailurePolicy("continue");
		
		
		System.out.println(suite);//  [Suite: "TmpSuite" ]
		XmlTest test = new XmlTest(suite);
		test.setName("aotutest");//   
		System.out.println(test);//[Test: "TmpTest" verbose:1[parameters:][metagroups:] [included: ][excluded: ]  classes: packages:] 
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.zhou.autotest.user.M1_fun_tv_home_user8_AnimalComics"));
	
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
        

	}

}
