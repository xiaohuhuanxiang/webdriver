package com.zhou.autotest.channel;

import java.io.IOException;
import java.util.HashMap;
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
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zhou.autotest.DriverFactory;
import com.zhou.autotest.M1_fun_tv_home_common;
import com.zhou.xmlutil.Config;


//测试首次打开m站的cookie , localstorage ----> 清理cookie,localstorage--->验证二者的长度


public class M1_fun_tv_home_cookiesAndLocalStorage {

	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_home_cookiesAndLocalStorage.class");
	
	private M1_fun_tv_home_common m1_fun_tv_home_common;
	


	@BeforeTest
	public void setUp() {
 
		 DriverFactory.getDriver();
			m1_fun_tv_home_common=new M1_fun_tv_home_common();

	}
	
	@AfterSuite
	public void tearDown() {
		DriverFactory.close();
	
	}
	
	@Test
	public void testClickSkip(){
	
		DriverFactory.open(m1_fun_tv_home_common.baseurl);
	
		DriverFactory.sleep();
		
		m1_fun_tv_home_common.ClickSkip();
		
	}
	
	@Test(dependsOnMethods = { "testClickSkip" })  
    public void testFUNCookies() { 
		
		
		HashMap<String,String>cookieToAssert = new HashMap<String,String>();
		cookieToAssert.put("uc", "30");
		cookieToAssert.put("intercept", "1");
		boolean flag = m1_fun_tv_home_common.FUNCookies(cookieToAssert);  // 验证cookie
		if(false == flag){
			Reporter.log(m1_fun_tv_home_common.getCurrentUrl(),true);//报告中打印当前urls
		}
		
		 Assert.assertTrue(flag, "uc=30,intercept=1");
		 Reporter.log("homepage  uc=30,intercept=1 ");
  }
	
	@Test(dependsOnMethods = { "testFUNCookies" })  
    public void testFUNLocalstorage() {    

		
		int localstorageSize =DriverFactory.getLocalStorageSize();
		if(3 != localstorageSize){
			Reporter.log(m1_fun_tv_home_common.getCurrentUrl(),true);//报告中打印当前urls
		}
		    Assert.assertEquals(localstorageSize, 3, "localStorage.length");

		    Reporter.log("homepage assert localstorageSize is 3");
   }
	
	
	

	@Test(dependsOnMethods = { "testFUNCookies" })  
    public void testClearCookie() {  

		DriverFactory.deleteAllCookies();
		
		//验证cookie长度为0
		
		int cookieSize =DriverFactory.getCookiesSize();
		logger.debug("cookies:"+cookieSize);//
		
		 Assert.assertEquals(cookieSize, 0, "assert cookie Size is 0 ");
	
		 Reporter.log("homepage clear cookies ,then assert cookie size is 0");
   }
	
	
	@Test(dependsOnMethods = { "testFUNLocalstorage" })  
    public void testClearLocalstorage() {  

		DriverFactory.clearLocalStorage();
		
		//验证cookie长度为0
		
		int localStorageSize =DriverFactory.getLocalStorageSize();
		logger.debug("localStorageSize:"+localStorageSize);//
		
		 Assert.assertEquals(localStorageSize, 0, "assert localStorage Size is 0 ");
	
		 Reporter.log("homepage clear LocalStorage,then assert localStorage Size is 0 ");
   }
	
	public static void main(String[] args) {
	
        

	}

}
