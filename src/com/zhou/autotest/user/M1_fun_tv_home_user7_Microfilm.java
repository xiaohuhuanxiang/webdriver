package com.zhou.autotest.user;

import java.io.IOException;
import java.util.HashMap;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zhou.xmlutil.Config;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.zhou.autotest.DriverFactory;
import com.zhou.autotest.M1_fun_tv_home_common;
//m站--》 点击标题中【微电影】---》 下拉---》 点击【全部微电影】----》 检索页（爱情，内地，2015）---》第一个播放----》，检查cookie,localstorage---->点击简介/收起简介

public class M1_fun_tv_home_user7_Microfilm {
	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_home_user7_Microfilm.class");
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
	public void testMicroFilm(){
		DriverFactory.driver.findElement(By.xpath("//a[contains(text(),'微电影')]")).click();
		DriverFactory.sleep();
		// 查看全部
		
		//Using Action Class 相当于页面滚动下移
		((JavascriptExecutor)DriverFactory.driver).executeScript("scrollTo(0,3000)");
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.id("seeAllBtn")).click();
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.linkText("爱情")).click();
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.linkText("内地")).click();
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.linkText("2015")).click();
		DriverFactory.sleep(1000);
		// 选择左边第一个微电影
		DriverFactory.driver.findElement(By.xpath("//*[@id=\"_retrieve\"]/div/div[1]/a/div[2]/h3")).click();
		DriverFactory.sleep(12000);
	}
	
	@Test(dependsOnMethods = { "testMicroFilm" })   
	public void testCookie(){
		HashMap<String,String>cookieToAssert = new HashMap<String,String>();
		cookieToAssert.put("intercept", "1");
		 Assert.assertTrue(m1_fun_tv_home_skip.FUNCookies(cookieToAssert), "intercept=1");
		 Reporter.log("homepage  intercept=1 ");
	}
	
	
	@Test(dependsOnMethods = { "testCookie" })  
	public void testLocalStorage(){
		
		m1_fun_tv_home_skip.LocalStorage();
	}
	
	@Test(dependsOnMethods = { "testLocalStorage" })  
	public void PauseAndPlay(){
		m1_fun_tv_home_skip.PauseAndFullPlay();
	}
	/*
	// 点击 简介展开 （右边下三角）
	document.getElementsByClassName("i-down-s")[0].click()

	匹配文案-页面上显示导演
	
	*/
	
	@Test(dependsOnMethods = { "PauseAndPlay" }) 
	public void  briefIntroduction(){
		((JavascriptExecutor)DriverFactory.driver).executeScript("document.getElementsByClassName(\"i-down-s\")[0].click();");
		
		///html/body/div[2]/section[2]/div/ul/li[1]/span[2]
		String xpath="/html/body/div[2]/section[2]/div/ul/li[1]/span[2]";
		
		String str=getExistText(DriverFactory.driver,xpath);
		//System.out.println("&&&&&&&&"+str);
		
		boolean flag = false;
		if(!str.equals(""))
			flag=true;
		
		Assert.assertTrue(flag, "briefIntroduction has ");
		
		((JavascriptExecutor)DriverFactory.driver).executeScript("document.getElementsByClassName(\"i-down-s\")[0].click();");
		
		str=getExistText(DriverFactory.driver,xpath);
		//System.out.println("&&&&&&&&"+str);//为空
		if(str.equals(""))
			flag=true;
		else 
			flag=false;
		Assert.assertTrue(flag, "briefIntroduction has ");
		
//		String daoyan=(String)((JavascriptExecutor)DriverFactory.driver).executeScript("document.getElementsByClassName(\"i-down-s\")[0].click();");
//		boolean flag =m1_fun_tv_home_skip.isContentAppeared(DriverFactory.driver, "2015");
//		
//		 Assert.assertTrue(flag, "briefIntroduction has ");
//		((JavascriptExecutor)DriverFactory.driver).executeScript("document.getElementsByClassName(\"i-down-s\")[0].click();");
//		
//		DriverFactory.sleep();
//		flag =m1_fun_tv_home_skip.isContentAppeared(DriverFactory.driver, "2015");
//
//		 Assert.assertTrue(flag, "briefIntroduction no ");
	}
	
	/**
	 * 获取元素节点的文本值 
	 * @param wd WebDriver对象
	 * @param xpath 目标节点的xpath
	 * @return
	 */
	public static String getText(WebDriver wd,String xpath){
	return wd.findElement(By.xpath(xpath)).getText();
	}
	
	/**
	 * 判断是否存在元素
	 * @param wd WebDriver对象
	 * @param xpath 目标节点的xpath
	 * @return
	 */
	public static boolean isExist(WebDriver wd,String xpath){
	try{
	wd.findElement(By.xpath(xpath));
	return true;
	}catch (NoSuchElementException e) { 
	            return false; 
	        } 
	}
	/**
	 * 获取元素节点的文本值
	 * @param wd WebDriver对象
	 * @param xpath 目标节点的xpath
	 * @return 没有找到该元素时会有个提示，并且不会报错，建议使用
	 */
	public static String getExistText(WebDriver wd,String xpath){
	if(isExist(wd, xpath)){
	return getText(wd, xpath);
	}
	return "-1";
	}
	public static void main(String[] args) {
	 DriverFactory.getAndroidDriver();
		
		DriverFactory.open("http://m1.fun.tv/");
		
		   // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        

        System.out.println("2 Page title is: " + DriverFactory.getAndroidDriver().getTitle());
        
        

	}

}
