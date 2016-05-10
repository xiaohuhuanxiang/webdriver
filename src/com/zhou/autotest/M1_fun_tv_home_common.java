package com.zhou.autotest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
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
	
public static String baseurl="";
static//静态代码块，当类被载入时，静态代码块被执行，且只被执行一次，静态块常用来执行类属性的初始化
{
	 baseurl = Config.getConfig("baseurl").toLowerCase().trim();
}
	
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
			
			
			 DriverFactory.sleep(15000);// 前贴广告倒计时结束
			
			
			jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.pause();");
			
			//jse.executeScript("var video = document.getElementByXpath(\"//*[@id="m-h5v-video-1"]\"); video.pause();");
			 DriverFactory.sleep(5000);
			
			jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.play();");
			DriverFactory.sleep(5000);

	   }
	  
		 //播放 + 暂停 +播放（针对：到了播放页就能播放的视频）
	  public void PlayAndPause() {  
	
			JavascriptExecutor jse=	(JavascriptExecutor)DriverFactory.driver;

			jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.play();");// 点播
			

			 DriverFactory.sleep(5000);
			
			jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.pause();");//暂停视频
			DriverFactory.sleep(5000);
			jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.play();");// 点播

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
	  // 暂停 + 全屏播放 ////document.getElementsByClassName("i-close")[2].click()  malliance=2242 时 暂停时有美女拦截页
	  public void PauseAndFullPlayWithMalliance(){
			//WebElement video = DriverFactory.findById("m-h5v-video-1");
			JavascriptExecutor jse=	(JavascriptExecutor)DriverFactory.driver;
		
			
			
			 DriverFactory.sleep(15000);
			

			jse.executeScript("var video = document.getElementById(\"m-h5v-video-1\"); video.pause();");
			
			logger.info(" pause 5s");
			 DriverFactory.sleep(5000);
            
			 // 把美女拦截页叉掉
			 
			 jse.executeScript("var intercept=document.getElementsByClassName(\"i-close\")[2];intercept.click();");
			 DriverFactory.sleep();
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
			
			DriverFactory.sleep(2000);
			
			DriverFactory.refresh();
			
	  }
	  
	  public void excutejs(String js){
		  JavascriptExecutor jse=	(JavascriptExecutor)DriverFactory.driver;
		  jse.executeScript(js);
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
	
	//页面打开  导航页的导航下拉单
	
	//document.getElementsByClassName("i-channel")[0].click() 出现下拉单
	//document.getElementsByClassName("i-channel current")[0].click() 收起下拉单
	
	public void dropDownUpNavigation(String channelStr){
	 String js="document.getElementsByClassName(\"i-channel\")[0].click()";
	 String xpath;
	 //打开下拉单
	 excutejs(js);
	 
	 switch(channelStr){
	 case "新闻":  
		 DriverFactory.driver.findElement(By.xpath("//a[8]/div")).click();
         break;   
     case "搞笑":  
    	 DriverFactory.driver.findElement(By.xpath("//a[9]/div")).click();
         break;  
     case "时尚":  
         //driver.findElement(By.xpath("//a[19]/p")).click();
    	 //driver.findElement(By.cssSelector("img[alt=\"时尚\"]")).click();
    	 DriverFactory.driver.findElement(By.cssSelector("img[alt=\"时尚\"]")).click();
         break;  
     case "生活":  
    	 DriverFactory.driver.findElement(By.cssSelector("img[alt=\"生活\"]")).click();
         break;  
     case "旅游":  
    	 DriverFactory.driver.findElement(By.cssSelector("img[alt=\"旅游\"]")).click();
         break;  
     case "广场舞":  
    	 DriverFactory.driver.findElement(By.cssSelector("img[alt=\"广场舞\"]")).click();
         break; 
     case "军事":  
    	 DriverFactory.driver.findElement(By.cssSelector("img[alt=\"军事\"]")).click();
         break; 
     case "科技":  
    	 DriverFactory.driver.findElement(By.cssSelector("img[alt=\"科技\"]")).click();
         break; 
     case "体育":  
    	 DriverFactory.driver.findElement(By.cssSelector("img[alt=\"体育\"]")).click();
         break; 
     case "汽车":  
    	 DriverFactory.driver.findElement(By.cssSelector("img[alt=\"汽车\"]")).click();
         break; 
     case "游戏":  
    	 DriverFactory.driver.findElement(By.cssSelector("img[alt=\"游戏\"]")).click();
         break; 
     case "格斗":  
    	 DriverFactory.driver.findElement(By.cssSelector("img[alt=\"格斗\"]")).click();
         break; 

     default:  
         throw new IllegalArgumentException("Invalid  channelStr");  
	 }

		DriverFactory.sleep();

//		//收起下拉单
//		js="document.getElementsByClassName(\"i-channel current\")[0].click();";
//		excutejs(js);
	}
	
	//判断当前的url中是否含有关键词
	
	
	  /*
  
  由于点击的可能是 专题或视频，要判断url:
  
  专题：http://m1.fun.tv/topic/?id=3140&type=video
  
  视频播放页：http://m1.fun.tv/mplay/?mid=102849
  
  如果点击的是专题页，跳转后需要第二次点击播放
  
  */
//1. 通过判断当前的url是是否含有topic来判断，是否是专题
	public boolean cururlHasKeywords(String key){
		//window.location.href
		String url=DriverFactory.driver.getCurrentUrl();
		if(url.contains(key))
			return true;
		return false;
		
	}
	// 获得当前页面的url
	public String getCurrentUrl(){
		return DriverFactory.driver.getCurrentUrl();
	}
	
	// 为了防止以后mid无效，现在，配置文件中配置， 从中随机选择一个即可
	// 长视频
	public  int getMplayMid(){
		Random random = new Random();
		ArrayList<Integer> mplayMid = new ArrayList<Integer>(); 
		mplayMid.add(14586);//监控从获取浏览次数最高的前6位
		mplayMid.add(117004);
		mplayMid.add(211542);
		mplayMid.add(117629);
		mplayMid.add(202096);

		
		
		
		
		return (int) mplayMid.get(random.nextInt(2));//[1,2]
	}
	//小视频
	public  int getVplayMid(){
		
		Random random = new Random();

		ArrayList<Integer> vplayMid = new ArrayList<Integer>(); 
		vplayMid.add(8064250);
		vplayMid.add(8046326);// 监控从获取浏览次数最高的前5位
		vplayMid.add(8063352);//
		vplayMid.add(8046304);//
		vplayMid.add(8064249);//8064249
		return (int) vplayMid.get(random.nextInt(2));//[1,2]
	}
	public static int getMalliance(){//渠道号
		
		Random random = new Random();

		ArrayList<Integer> malliance = new ArrayList<Integer>(); 
		malliance.add(2242);//百度视频
		malliance.add(1010);
		
		return (int) malliance.get(random.nextInt(2));//[1,2]
	}
	
	public static void main(String[] args) {
//	 DriverFactory.getDriver();
//		
//		DriverFactory.open("http://m1.fun.tv/mplay/?mid=94061");
//		M1_fun_tv_home_common	m1_fun_tv_home_skip=	new M1_fun_tv_home_common();
//		m1_fun_tv_home_skip.ClickSkip();
//		m1_fun_tv_home_skip.dropDownUpNavigation("时尚");
        
      

	}

}
