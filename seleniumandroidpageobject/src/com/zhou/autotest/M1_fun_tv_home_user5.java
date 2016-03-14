package com.zhou.autotest;

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

/*
 *
 user :
 
m站---》点击搜索---》输入【女医明妃传】，点击立即搜索---》搜索结果中有女医明妃传---》 localstorage中recent search有keyword
 
 
 */

public class M1_fun_tv_home_user5 {
	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_home_user5.class");
	private M1_fun_tv_home_common m1_fun_tv_home_skip;
	String keyswords="女医明妃传";
	@BeforeTest
	public void setUp() {

//		 DriverFactory.getDriver();

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
	public void testSearch(){

		DriverFactory.sleep();
		DriverFactory.driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/a[3]")).click();
		DriverFactory.sleep();
	
		DriverFactory.driver.findElement(By.cssSelector("input.j-input.txt")).sendKeys(keyswords);
		DriverFactory.sleep();
		//点击【搜索】
		DriverFactory.driver.findElement(By.xpath("/html/body/div[2]/header/div[3]/div/div/div[1]/div[1]")).click();
		DriverFactory.sleep();
	}
	
	
//	1. localStorage.getItem("_search_recent")
//	"{"data":[{"title":"女医明妃传"}],"exp":31536000,"time":1457430231684}"
	@Test(dependsOnMethods = { "testSearch" })   
	public void testRecentSearchLocalStorage(){
		 m1_fun_tv_home_skip.RecentSearchLocalStorage(keyswords);
		
	}

	
	
//	2. 点击【立即观看】  /html/body/div[2]/div[2]/div/div/a/div[3]/div
	@Test(dependsOnMethods = { "testRecentSearchLocalStorage" })   
	public void testPlayShow(){
		DriverFactory.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/a/div[3]/div")).click();
		DriverFactory.sleep();
	}
	/*
	 *
	 
	 WebDriver(Selenium2) 判断页面是否出现某个字段的方法（Java实现)
	 
	 类似于seleniumRC中的isTextPresent 方法 
用xpath匹配所有元素（//*[contains(.,'keyword')]），判断是否存在包含期望关键字的元素。 
使用时可以根据需要调整参数和返回值。 
	 */
	@Test(dependsOnMethods = { "testRecentSearchLocalStorage" })   
	public void testTextShow(){
		
		 Assert.assertTrue(m1_fun_tv_home_skip.isContentAppeared(DriverFactory.driver,keyswords), "keyswords is present in pagetext");
		//System.out.println("&&&&&&&&&&"+isContentAppeared(DriverFactory.driver,keyswords));
	}
	

	
	public static void main(String[] args) {
	 DriverFactory.getAndroidDriver();
		
		DriverFactory.open("http://m1.fun.tv/");
		
		   // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        

        System.out.println("2 Page title is: " + DriverFactory.getAndroidDriver().getTitle());
        
        

	}

}
