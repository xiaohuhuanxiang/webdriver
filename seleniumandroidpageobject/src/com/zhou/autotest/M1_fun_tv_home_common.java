package com.zhou.autotest;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
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



public class M1_fun_tv_home_common {

	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_home_skip.class");
	
//	@AfterTest
//	public void tearDown() {
//		DriverFactory.close();
//	}
	
public String baseurl="http://m1.fun.tv";	
	
//点击【跳过】
	public void ClickSkip(){ 
		
		 (new WebDriverWait(DriverFactory.driver, 50)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	               // return d.getTitle().toLowerCase().endsWith("selenium");
//	                return d.getTitle().toLowerCase().contains("风行");
	            	 return d.getTitle().length()>0;

	            }
	        });
		 
		 logger.info("title:"+DriverFactory.driver.getTitle());
		
		    WebElement element= DriverFactory.driver.findElement(By.xpath("html/body/div[1]/div[2]/div/a"));
		    DriverFactory.sleep();
		    
		    
		    JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.driver;
		    executor.executeScript("arguments[0].click();", element);
		    
		    logger.info("Click Skip  end ");
	}

	//全屏 + 退出全屏
	 public void BigAndSmall() {  
			JavascriptExecutor jse=	(JavascriptExecutor)DriverFactory.driver;
			DriverFactory.sleep(5000);
			//大屏
			jse.executeScript("var full = document.getElementById(\"m-h5v-full-1\"); full.click();");
			
			DriverFactory.sleep(5000);
			//小屏
			jse.executeScript("var full = document.getElementById(\"m-h5v-full-1\"); full.click();");
	 }
	
	 //暂停+播放
	  public void PauseAndPlay() {  
	
			JavascriptExecutor jse=	(JavascriptExecutor)DriverFactory.driver;
			
			
			 DriverFactory.sleep(15000);
			
			
			jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.pause();");
			
			//jse.executeScript("var video = document.getElementByXpath(\"//*[@id="m-h5v-video-1"]\"); video.pause();");
			 DriverFactory.sleep(5000);
			
			jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.play();");
			DriverFactory.sleep(5000);

	   }
	  
	  // 暂停 + 全屏播放
	  public void PauseAndFullPlay(){
			//WebElement video = DriverFactory.findById("m-h5v-video-1");
			JavascriptExecutor jse=	(JavascriptExecutor)DriverFactory.driver;
		
			
			
			 DriverFactory.sleep(15000);
			

			jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.pause();");
			
			logger.info(" pause 5s");
			 DriverFactory.sleep(5000);

			
			jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.play();");
		
			logger.info(" play after pause 5s");
//			jse.executeScript("return arguments[0].play()", video);
//			System.out.println("-----------play()--------------");
			//jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\");video.pause();");
			
			DriverFactory.sleep();
			DriverFactory.driver.findElement(By.id("m-h5v-full-1")).click();//
			
			DriverFactory.sleep();
			
//			DriverFactory.driver.findElement(By.id("m-h5v-full-1")).click();
			
			jse.executeScript("var full = document.getElementById(\"m-h5v-full-1\"); full.click();");
			logger.info("full to play");
	  }
	  // 点击 下一个
	  public void PlayNext() {  

			JavascriptExecutor jse=	(JavascriptExecutor)DriverFactory.driver;
			
			
			
			 DriverFactory.sleep(4000);
			
			
			
			jse.executeScript("var next = document.getElementById(\"m-h5v-next-1\"); next.click();");
			
	  }
	  
	  // 验证cookie
	  
	  public boolean FUNCookies(HashMap<String,String>cookieToAssert) { 

			int i=0;
			(new WebDriverWait(DriverFactory.driver, 10)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	            	 return d.getTitle().length()>0;

	            }
	        });

			(new WebDriverWait(DriverFactory.driver, 10)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	            	 return d.manage().getCookies().size()>0;

	            }
	        });
			
			 for (Cookie ck : DriverFactory.driver.manage().getCookies()) {
	           
				 if(cookieToAssert.containsKey(ck.getName())&& cookieToAssert.get(ck.getName()).equals(ck.getValue())){
					 ++i;
				 }
//	             if( ck.getName().equals("malliance") && ck.getValue().equals("2242") )
//	            	 malliance=true;
//	             else if( ck.getName().equals("intercept") && ck.getValue().equals("1") )
////	            	 intercept=true;

					 
	         
	         }
			
			 return  (i==cookieToAssert.size());
			// Assert.assertTrue(intercept, "cookie intercept is right");

	  }
	  
	  
	 public void  LocalStorage(){
			
			
			
			JSONObject localStorageJson=DriverFactory.getLocalStorage();
			//{"data":[{"videoid":"659110","galleryid":"200120","time":8,"vtitle":"新娘大作战","pic":"http://img.funshion.com/sdw?oid=ca5f28c4b038ed5c6ae7d6af23fdea6e&w=0&h=0","url":"http://m1.fun.tv/mplay/?mid=200120","vtype":"media"}],"exp":31536000,"time":1457418516980}
			
			
			//{"data":[{"vtype":"media","galleryid":"200120","videoid":"659110","time":12,"pic":"http://img.funshion.com/sdw?oid=ca5f28c4b038ed5c6ae7d6af23fdea6e&w=0&h=0","vtitle":"新娘大作战","url":"http://m1.fun.tv/mplay/?mid=200120"}],"time":1457423021619,"exp":31536000}
		 	JSONArray ja= 	(JSONArray) localStorageJson.get("data");
			
			//[{"vtype":"media","galleryid":"200120","videoid":"659110","time":12,"pic":"http://img.funshion.com/sdw?oid=ca5f28c4b038ed5c6ae7d6af23fdea6e&w=0&h=0","vtitle":"新娘大作战","url":"http://m1.fun.tv/mplay/?mid=200120"}]
		   	String titlesor=(String) ja.getJSONObject(0).get("vtitle");//新娘大作战
		   	String urlsor=(String) ja.getJSONObject(0).get("url");
		   	
		   	
		   	
		   	String titleexpected=DriverFactory.driver.getTitle();
		   //	System.out.println("***********"+title);//新娘大作战-电影-在线观看-高清下载-风行网
		   	
		   	String urlexpected = DriverFactory.driver.getCurrentUrl();
		   	
		   	boolean flag=false;
		   	if(titleexpected.contains(titlesor.trim()) && urlexpected.equals(urlsor.trim()))
		   		flag=true;
		   	Assert.assertTrue(flag, "local storage : assert url ,vtitle");
		    
		}
	 //localStorage.getItem("_search_recent")
	// "{"data":[{"title":"女医明妃传"}],"exp":31536000,"time":1457430231684}"
	 public void  RecentSearchLocalStorage(String keywords){
			
			
			
			JSONObject localStorageJson=DriverFactory.getRecentSearch();
			

		 	JSONArray ja= 	(JSONArray) localStorageJson.get("data");
			
			//[{"vtype":"media","galleryid":"200120","videoid":"659110","time":12,"pic":"http://img.funshion.com/sdw?oid=ca5f28c4b038ed5c6ae7d6af23fdea6e&w=0&h=0","vtitle":"新娘大作战","url":"http://m1.fun.tv/mplay/?mid=200120"}]
		   	String titlesor=(String) ja.getJSONObject(0).get("title");
		   	

		   	
		   	boolean flag=false;
		   	if(keywords.matches(titlesor) || titlesor.matches(keywords))
		   		flag=true;
		   	Assert.assertTrue(flag, "local storage : assert search title");
		    
		}
	 
	public void scrollDown(){
		((JavascriptExecutor)DriverFactory.driver).executeScript("scrollTo(0,2000)");
	}
	
	public boolean isContentAppeared(WebDriver driver,String content) {  
	    boolean status = false;  
	    try {  
	        driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));  
	        System.out.println(content + " is appeard!");  
	        status = true;  
	    } catch (NoSuchElementException e) {  
	        status = false;  
	        System.out.println("'" + content + "' doesn't exist!");  
	    }  
	    return status;  
	}  
	  
	public static void main(String[] args) {
	 DriverFactory.getAndroidDriver();
		
		DriverFactory.open("http://m1.fun.tv/");
		
		   // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        

        System.out.println("2 Page title is: " + DriverFactory.getAndroidDriver().getTitle());
        
        

	}

}
