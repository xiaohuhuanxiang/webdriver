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

// 广场舞 + 时尚 + 生活
public class M1_fun_tv_home_user11_man {
	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_home_user11_man.class");
	private M1_fun_tv_home_common m1_fun_tv_home_skip;
	@BeforeTest
	public void setUp() {

		 DriverFactory.getDriver();

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
// 进入 广场舞检索页，
	@Test(dependsOnMethods = { "testClickSkip" })   
	public void testmilitary(){
		//military
		DriverFactory.driver.findElement(By.xpath("//a[contains(text(),'军事')]")).click();
		DriverFactory.sleep();
		// 查看全部
		
		//Using Action Class 相当于页面滚动下移
		((JavascriptExecutor)DriverFactory.driver).executeScript("scrollTo(0,3000)");
		DriverFactory.sleep(1000);
		DriverFactory.driver.findElement(By.id("seeAllBtn")).click();
		DriverFactory.sleep(1000);
		

		// 选择左边第一个
		String js="document.getElementsByClassName(\"pic\")[0].click()";
		m1_fun_tv_home_skip.excutejs(js);
		
		//刷新页面，防止出现接口异常，视频并没有在播放的情况
		DriverFactory.refresh();
		
		DriverFactory.sleep(12000);
	}
	
	
	@Test(dependsOnMethods = { "testmilitary" })  
	public void PauseAndPlay(){
		m1_fun_tv_home_skip.PauseAndFullPlay();
	}
	
	
	//点击热点
	@Test(dependsOnMethods = { "PauseAndPlay" })  
	public void science(){
		DriverFactory.sleep(1000);
		m1_fun_tv_home_skip.dropDownUpNavigation("科技");
		
		//左起第一个图片
		String js="document.getElementsByClassName(\"pic\")[1].click();";
		m1_fun_tv_home_skip.excutejs(js);
		DriverFactory.sleep();
		
		m1_fun_tv_home_skip.PauseAndFullPlay();
	}
	//选择汽车
	@Test(dependsOnMethods = { "science" }) 
	public void car(){
		
m1_fun_tv_home_skip.dropDownUpNavigation("汽车");
		
		//左起第一个图片
		String js="document.getElementsByClassName(\"pic\")[1].click();";
		m1_fun_tv_home_skip.excutejs(js);
		DriverFactory.sleep(12000);
		
		m1_fun_tv_home_skip.PauseAndFullPlay();
	}
	//选择体育
		@Test(dependsOnMethods = { "science" }) 
		public void sports (){
			
	m1_fun_tv_home_skip.dropDownUpNavigation("体育");
			
			//左起第一个图片
			String js="document.getElementsByClassName(\"pic\")[1].click();";
			m1_fun_tv_home_skip.excutejs(js);
			DriverFactory.sleep(12000);
			
			m1_fun_tv_home_skip.PauseAndFullPlay();
		}
		//选择游戏
		@Test(dependsOnMethods = { "science" }) 
		public void game (){
			
	m1_fun_tv_home_skip.dropDownUpNavigation("游戏");
			
			//左起第一个图片
			String js="document.getElementsByClassName(\"pic\")[1].click();";
			m1_fun_tv_home_skip.excutejs(js);
			DriverFactory.sleep(12000);
			
			m1_fun_tv_home_skip.PauseAndFullPlay();
		}
		//选择格斗
				@Test(dependsOnMethods = { "science" }) 
				public void fighting (){
					
			m1_fun_tv_home_skip.dropDownUpNavigation("格斗");
					
					//左起第一个图片
					String js="document.getElementsByClassName(\"pic\")[1].click();";
					m1_fun_tv_home_skip.excutejs(js);
					DriverFactory.sleep(12000);
					
					m1_fun_tv_home_skip.PauseAndFullPlay();
				}
	public static void main(String[] args) {
	
		//http://m1.fun.tv/retrieve/?channel=1027&cate=137157
		 DriverFactory.getDriver();
			
			DriverFactory.open("http://m1.fun.tv/retrieve/?channel=1027&cate=137157");
			DriverFactory.sleep(1000);
			M1_fun_tv_home_common	m1_fun_tv_home_skip=	new M1_fun_tv_home_common();
			m1_fun_tv_home_skip.ClickSkip();
			String js="document.getElementsByClassName(\"pic\")[0].click()";
			m1_fun_tv_home_skip.excutejs(js);
			//刷新页面，防止出现接口异常，视频并没有在播放的情况
			DriverFactory.refresh();
			
			DriverFactory.sleep(12000);
			

	}

}
