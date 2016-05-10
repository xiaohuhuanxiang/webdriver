package com.zhou.androidautotest;

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

import com.zhou.autotest.DriverFactory;
import com.zhou.autotest.M1_fun_tv_home_common;
import com.zhou.xmlutil.Config;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//m站--》 点击标题中【电视剧】---》 下拉---》 点击【全部电视剧】----》 检索页（古装，内地，2015）---》点击一个播放，第1集播放，检查cookie,localstorage
//
//
//----->点击第2集播放---》 检查localstorage播放历史

public class M1_fun_tv_android_user {
	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_android_user.class");
	private M1_fun_tv_home_common m1_fun_tv_home_skip;
	@BeforeTest
	public void setUp() {
		try {
			//��webdriver
			Runtime.getRuntime().exec("adb shell am start -a android.intent.action.MAIN "
					+ "-n org.openqa.selenium.android.app/.MainActivity");
			/*���ӷ����webdriver�������õĶ˿�Ϊ8080����������п����˻�ʹ���˸ö˿ڣ���Ҫ�رգ�http://localhost:8080/exit������Ȼ���Ӳ��Ϸ����webdriver   */
			Runtime.getRuntime().exec("adb -s YHDAAAUK99999999 forward tcp:8080 tcp:8080");
		} catch (Exception e) {
			// TODO: handle exception
		}
		DriverFactory.sleep();
		
		
		 DriverFactory.getAndroidDriver();

		m1_fun_tv_home_skip= new M1_fun_tv_home_common();
	}
	
//	@AfterTest
//	public void tearDown() {
//		DriverFactory.close();
//	}
	
	
	
	@Test
	public void testClickSkip(){
		DriverFactory.open("http://m1.fun.tv/");
		DriverFactory.sleep();
		m1_fun_tv_home_skip.ClickSkip();
	}
// 想看电影，进入 电影检索页，
	@Test(dependsOnMethods = { "testClickSkip" })   
	public void testTVSeries(){
		DriverFactory.sleep();
		
		//DriverFactory.driver.findElement(By.xpath("//a[contains(text(),'电视剧')]")).click();
		String js="document.getElementsByClassName(\"tab\")[2].click()";
		((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		
		
		DriverFactory.sleep();
		// 查看全部
		
		//Using Action Class
		((JavascriptExecutor)DriverFactory.driver).executeScript("scrollTo(0,3000)");
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.id("seeAllBtn")).click();
		DriverFactory.sleep(1000);
		
		//DriverFactory.driver.findElement(By.linkText("古装")).click();
		js="document.getElementsByClassName(\"tab\")[4].click()";
		((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		DriverFactory.sleep(1000);
		//DriverFactory.driver.findElement(By.linkText("内地")).click();
		js="document.getElementsByClassName(\"tab\")[24].click()";
		((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		
		DriverFactory.sleep(1000);
		//DriverFactory.driver.findElement(By.linkText("2015")).click();
		js="document.getElementsByClassName(\"tab\")[28].click()";
		((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		
		DriverFactory.sleep(1000);
	// 第一个电视剧播放
		//DriverFactory.driver.findElement(By.xpath("//*[@id=\"_retrieve\"]/div/div[1]/a/div[1]/img")).click();
		js="document.getElementsByClassName(\"pic\")[0].click()";
		((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		DriverFactory.sleep(12000);
	}
	@Test(dependsOnMethods = { "testTVSeries" })   
	public void testPlay(){
//		android 默认视频为暂停状态
//		m-h5v-bigplay-1  点击播放
//		m-h5v-play-1     点击暂停
		//播放 点击
		String js="document.getElementById(\"m-h5v-bigplay-1\").click()";
		((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		//播放前缓冲
		DriverFactory.sleep(10000);
		
		// 播放一段时间
		DriverFactory.sleep();
		
//		// 播放暂停
//		js="document.getElementById(\"m-h5v-play-1\").click()";
//		((JavascriptExecutor)DriverFactory.driver).executeScript(js);
//		
//		// 暂停一段时间
//				DriverFactory.sleep();
				
		
	}
	
//// 待   屏幕旋转   +  触摸和滚动 P 148 针对手机，如android
@Test(dependsOnMethods = { "testPlay" }) 
public void testTouchAndScroll(){
	
	DriverFactory.sleep(5000);
	
	((Rotatable)DriverFactory.driver).rotate(ScreenOrientation.PORTRAIT);// 屏幕旋转
//	TouchActions touch = new TouchActions(DriverFactory.driver);//触摸和滚动 
//	touch.scroll(200, 800).build().perform();
}
//	@Test(dependsOnMethods = { "testPlayAndPause" })   
//	public void testCookie(){
//		HashMap<String,String>cookieToAssert = new HashMap<String,String>();
//		cookieToAssert.put("intercept", "1");
//		 Assert.assertTrue(m1_fun_tv_home_skip.FUNCookies(cookieToAssert), "intercept=1");
//		 Reporter.log("homepage  intercept=1 ");
//	}
//	
//	
//	@Test(dependsOnMethods = { "testCookie" })  
//	public void testLocalStorage(){
//		DriverFactory.sleep(4);//可能因为网络原因，此时正在缓冲，所以又加上了sleep
//		m1_fun_tv_home_skip.LocalStorage();
//	}
//	@Test(dependsOnMethods = { "testLocalStorage" })  
//	public void testEpisodes(){
//		
//		DriverFactory.driver.findElement(By.linkText("2")).click();
//		DriverFactory.sleep(10000);
//		
//		m1_fun_tv_home_skip.LocalStorage();
//	    
//	}
	
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
