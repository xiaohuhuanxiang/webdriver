package com.zhou.autotest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zhou.xmlutil.Config;



public class M1_fun_tv_mplay {

	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_mplay.class");

	private M1_fun_tv_home_common m1_fun_tv_home_common;
	
	
	@BeforeTest
	public void setUp() {
	

//		 DriverFactory.getDriver();
		m1_fun_tv_home_common= new M1_fun_tv_home_common();
			
	}
//	
//	@AfterTest
//	public void tearDown() {
//		DriverFactory.close();
//	}
	
	
	
	@Test
	public void testClickSkip(){
		
		DriverFactory.open(m1_fun_tv_home_common.baseurl+"/mplay/?mid=105209");
		
		m1_fun_tv_home_common.ClickSkip();
		
		
	}
	
//	 //利用js代码键入搜索关键字
//    ((JavascriptExecutor)driver).executeScript("document.getElementById(\"kw\").value=\"yeetrack\"");
//    //利用js代码取出关键字
//    String keyword = (String) ((JavascriptExecutor)driver).executeScript("var input = document.getElementById(\"kw\").value;return input");
	@Test(dependsOnMethods = { "testClickSkip" })  
    public void testPauseAndPlay() {  
		
		m1_fun_tv_home_common.PauseAndPlay();
   }
	
	public static void main(String[] args) {
	 DriverFactory.getAndroidDriver();
		
		DriverFactory.open("http://m1.fun.tv/");
		
		   // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        

        System.out.println("2 Page title is: " + DriverFactory.getAndroidDriver().getTitle());
        
        

	}

}
