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
import org.openqa.selenium.support.ui.ExpectedConditions;
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
 
m站---》 影视库----》 综艺点击【更多】----》 内地，2015筛选----》 结果中有《喜乐街》
 
 
 */

public class M1_fun_tv_home_user6 {
	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_home_user6.class");
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
	public void testLocationAndScroll(){

		DriverFactory.sleep();
		//1. 定位影视库
		WebElement element =DriverFactory.driver.findElement(By.xpath("//*[@id=\"navWrap\"]/ul/li[24]/a"));
		DriverFactory.sleep();
	  
		//2.  影视库 页面可见
		//((JavascriptExecutor) DriverFactory.driver).executeScript("arguments[0].scrollIntoView();" ,element);
		Actions actions=new Actions(DriverFactory.driver);
		actions.moveToElement(element).perform();

		// 3. 点击
		element.click();
		DriverFactory.sleep();
		// 4. 下移后
		m1_fun_tv_home_skip.scrollDown();
		
		DriverFactory.sleep();
		//5. 点击  热门综艺--更多  //*[@id="pgContent"]/section[4]/h2/a[2]
		//直接定位显示不可点击， 用js实现
		// driver.findElement(By.xpath("//a[contains(text(),'影视库')]")).click();
	    //driver.findElement(By.xpath("(//a[contains(text(),'更多>')])[3]")).click();
		
	    String js="document.getElementsByClassName(\"more\")[2].click()";
	    ((JavascriptExecutor)DriverFactory.driver).executeScript(js);
//		
//		WebDriverWait wait = new WebDriverWait(DriverFactory.driver, 10);//10秒内每隔500毫秒扫描1次页面变化，当出现指定的元素后结束
//		WebElement more = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pgContent\"]/section[2]/h2/a[2]")));
//		more.click();
	    
	    // 6. 内地  2015  有《喜乐街》
		DriverFactory.driver.findElement(By.linkText("内地")).click();
		DriverFactory.sleep();
	    DriverFactory.driver.findElement(By.linkText("2015")).click();
		DriverFactory.sleep();
		 Assert.assertTrue(m1_fun_tv_home_skip.isContentAppeared(DriverFactory.driver, "喜乐街"),"内地，2015中有《喜乐街》");
		
	}
	
	


	
	

	
	public static void main(String[] args) {
	 DriverFactory.getAndroidDriver();
		
		DriverFactory.open("http://m1.fun.tv/");
		
		   // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        

        System.out.println("2 Page title is: " + DriverFactory.getAndroidDriver().getTitle());
        
        

	}

}
