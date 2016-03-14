package com.zhou.autotest;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
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

//m站--》 点击标题中【电视剧】---》 下拉---》 点击【全部电视剧】----》 检索页（古装，内地，2015）---》点击一个播放，第1集播放，检查cookie,localstorage
//
//
//----->点击第2集播放---》 检查localstorage播放历史

public class M1_fun_tv_home_user3 {
	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_home_user3.class");
	private M1_fun_tv_home_common m1_fun_tv_home_skip;
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
	public void testTVSeries(){
		DriverFactory.sleep();
		DriverFactory.driver.findElement(By.xpath("//a[contains(text(),'电视剧')]")).click();
		
		
		DriverFactory.sleep();
		// 查看全部
		
		//Using Action Class
		((JavascriptExecutor)DriverFactory.driver).executeScript("scrollTo(0,3000)");
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.id("seeAllBtn")).click();
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.linkText("古装")).click();
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.linkText("内地")).click();
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.linkText("2015")).click();
		DriverFactory.sleep(1000);
	
		DriverFactory.driver.findElement(By.xpath("//*[@id=\"_retrieve\"]/div/div[1]/a/div[1]/img")).click();
		DriverFactory.sleep(12000);
	}
	
	@Test(dependsOnMethods = { "testTVSeries" })   
	public void testCookie(){
		HashMap<String,String>cookieToAssert = new HashMap<String,String>();
		cookieToAssert.put("intercept", "1");
		 Assert.assertTrue(m1_fun_tv_home_skip.FUNCookies(cookieToAssert), "intercept=1");
		 Reporter.log("homepage  intercept=1 ");
	}
	
	
	@Test(dependsOnMethods = { "testCookie" })  
	public void testLocalStorage(){
		DriverFactory.sleep(4);//可能因为网络原因，此时正在缓冲，所以又加上了sleep
		m1_fun_tv_home_skip.LocalStorage();
	}
	@Test(dependsOnMethods = { "testLocalStorage" })  
	public void testEpisodes(){
		
		DriverFactory.driver.findElement(By.linkText("2")).click();
		DriverFactory.sleep(10000);
		
		m1_fun_tv_home_skip.LocalStorage();
	    
	}
	
////	// 待   屏幕旋转   +  触摸和滚动 P 148 针对手机，如android
//	@Test(dependsOnMethods = { "testHeaderTab" }) 
//	public void testTouchAndScroll(){
//		
//		DriverFactory.sleep(5000);
//		
//		((Rotatable)DriverFactory.driver).rotate(ScreenOrientation.PORTRAIT);// 屏幕旋转
//		TouchActions touch = new TouchActions(DriverFactory.driver);//触摸和滚动 
//		touch.scroll(200, 800).build().perform();
//	}
//	
//	@Test(dependsOnMethods = { "testMore" }) 
//	public void testRetrieve(){
//		
//		DriverFactory.sleep(5000);
//		
//		DriverFactory.driver.findElement(By.linkText("爱情")).click();
//		DriverFactory.sleep();
//		DriverFactory.driver.findElement(By.linkText("2015")).click();
//		DriverFactory.sleep();
//		DriverFactory.driver.findElement(By.linkText("内地")).click();
//		DriverFactory.sleep();
//		DriverFactory.driver.findElement(By.xpath("//img[contains(@src,'http://img.funshion.com/sdw?oid=82a4429be2054bfc29ec535f3d4c1c4f&w=200&h=280')]")).click();
//		
////		JavascriptExecutor jse=	(JavascriptExecutor)DriverFactory.driver;
////
////		jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.pause();");
////		
////		DriverFactory.sleep(5000);
////		
////		jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.play();");
//	}
	public static void main(String[] args) {
	 DriverFactory.getAndroidDriver();
		
		DriverFactory.open("http://m1.fun.tv/");
		
		   // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        

        System.out.println("2 Page title is: " + DriverFactory.getAndroidDriver().getTitle());
        
        

	}

}
