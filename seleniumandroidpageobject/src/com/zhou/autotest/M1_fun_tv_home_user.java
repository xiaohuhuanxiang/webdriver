package com.zhou.autotest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zhou.xmlutil.Config;

/*
 *
 user :
 
m站--》标题栏 依次点击  电影， 电视剧，动漫，综艺---》 点击一个综艺---》 暂停，进而播放

--->点击右上角，查看最近观看，---》检查第一个播放视频的url和title---->清空最近观看----》检查最近观看隐藏，显示暂无观看历史
 
 
 */

public class M1_fun_tv_home_user {
	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_home_user.class");
	private M1_fun_tv_home_common m1_fun_tv_home_skip;

	@BeforeTest
	public void setUp() {

//		 DriverFactory.getDriver();
//
		 m1_fun_tv_home_skip=new M1_fun_tv_home_common();
		
		
	}
	
//	@AfterTest
//	public void tearDown() {
//		DriverFactory.close();//关闭当前窗口
//	}
	
	
	
	@Test
	public void testClickSkip(){
		
		DriverFactory.open(m1_fun_tv_home_skip.baseurl);
		DriverFactory.sleep();
		m1_fun_tv_home_skip.ClickSkip();
		
		
	}

	@Test(dependsOnMethods = { "testClickSkip" })   
	public void testHeaderTab(){
		DriverFactory.sleep();
		DriverFactory.driver.findElement(By.xpath("//a[contains(text(),'电影')]")).click();
		DriverFactory.sleep();
		DriverFactory.driver.findElement(By.xpath("//a[contains(text(),'电视剧')]")).click();
		DriverFactory.sleep();
		DriverFactory.driver.findElement(By.xpath("//a[contains(text(),'动漫')]")).click();
		DriverFactory.sleep();
		DriverFactory.driver.findElement(By.xpath("//a[contains(text(),'综艺')]")).click();
		DriverFactory.sleep();
		//第一个综艺节目
		String js="document.getElementsByClassName(\"tit h\")[0].click()";
		((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		//DriverFactory.driver.findElement(By.xpath("//*[@id=\"pgContent\"]/section[3]/div/div[6]/a/div[1]/img")).click();
	}
	
	
	@Test(dependsOnMethods = { "testHeaderTab" }) 
	public void testPlayAndPause(){
		
		m1_fun_tv_home_skip.PauseAndPlay();
	}
	
	// 我最近看过的---》检查 第一个：链接（ 为当前页面的url）,文案（即为 document.title一部分）
	
	@Test(dependsOnMethods = { "testPlayAndPause" }) 
	public void testRecentlyWatched(){
		
		// 1. 点击右上角 类似时钟的按钮
		//document.getElementById("i_history").click()
		String js="document.getElementById(\"i_history\").click()";
		((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		//2. 第一个即为当前播放视频的信息 ，检查url 和 文案信息
		//var s = document.getElementsByClassName("list")[0];
		//s.getElementsByTagName("a")[0].href       window.location.href 
		//s.getElementsByTagName("a")[0].innerHTML document.title
		
		js="var s = document.getElementsByClassName(\"list\")[0];return s.getElementsByTagName(\"a\")[0].href;";
		
		String url=(String) ((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		
		js="var s = document.getElementsByClassName(\"list\")[0];return s.getElementsByTagName(\"a\")[0].innerHTML;";
		String text=(String) ((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		
		js="";
		String textExpected = DriverFactory.driver.getTitle().trim();//window.location.href 
		String urlExpected=DriverFactory.driver.getCurrentUrl().trim();//document.title
		
		logger.debug("url:{}",url);//http://m1.fun.tv/mplay/?mid=97673
		logger.debug("text:{}",text);//"陈思思讲献声《芈月》缘由"
		logger.debug("urlExpected:{}",urlExpected);//http://m1.fun.tv/mplay/?mid=97673
		logger.debug("textExpected:{}",textExpected);//"陈思思讲献声《芈月》缘由-综艺-在线观看-高清下载-风行网"
		boolean flag=false;
		if(urlExpected.equals(url)&&textExpected.contains(text))
          flag=true;
		
		Assert.assertTrue(flag, "RecentlyWatched");
	}
	

	@Test(dependsOnMethods = { "testRecentlyWatched" })                  
	  public void  testClearRecentlyWatched(){
		  
		//1. 点击清空  document.getElementById("i_clear_btn").click()
		String js="document.getElementById(\"i_clear_btn\").click();";
		((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		
		//2. 检查document.getElementById("_yesHistory").style.display=none
		js="return document.getElementById(\"_yesHistory\").style.display;";
		String yesHistory_styledisplay=(String) ((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		//3. 显示暂无观看历史 document.getElementById("_noHistory").style.display=block
		js="return document.getElementById(\"_noHistory\").style.display;";
		String noHistory_styledisplay=(String) ((JavascriptExecutor)DriverFactory.driver).executeScript(js);
		
		boolean flag=false;
		// 前者隐藏，后者显示
		if(yesHistory_styledisplay.trim().equals("none") 
			&& noHistory_styledisplay.trim().equals("block"))
			flag=true;
		
		Assert.assertTrue(flag, "ClearRecentlyWatched");
		
	  }
	
	public static void main(String[] args) {
	 DriverFactory.getAndroidDriver();
		
		DriverFactory.open("http://m1.fun.tv/");
		
		   // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        

        System.out.println("2 Page title is: " + DriverFactory.getAndroidDriver().getTitle());
        
        

	}

}
