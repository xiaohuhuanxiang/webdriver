package com.zhou.autotest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.zhou.po.Driver;
import com.zhou.xmlutil.Config;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DriverFactory {
	public static  WebDriver driver;
	static Alert alert;
	public static WebDriver getChromeDriver() {
        
        // TODO Auto-generated method stub
       // String chromdriver="E:\\java\\chromedriver.exe";
		String chromdriver=Config.getConfig("chromdriverLocation");
        System.setProperty("webdriver.chrome.driver", chromdriver);
//        ChromeDriverService.Builder builder=new  ChromeDriverService.Builder();
//        File file=new File(chromdriver);
////        int port=12643;
////        ChromeDriverService service=builder.usingDriverExecutable(file).usingPort(port).build();
////        try {
////            service.start();
////        } catch (IOException e) {
////            // TODO Auto-generated catch block
////            e.printStackTrace();
////        }
//        ChromeOptions options = new ChromeOptions();
//        options.addExtensions(new File(""));
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability("chrome.switches",
//                Arrays.asList("--start-maximized"));
//        options.addArguments("--test-type", "--start-maximized");
//       // WebDriver driver=new ChromeDriver(options);
//         driver=new ChromeDriver(options);
        driver=new ChromeDriver();
        return driver;
    }
	    public static WebDriver getFirefoxDriver()
	    {
//	        try
//	        {
//	            WindowsUtils.tryToKillByName("firefox.exe");
//	        }
//	        catch(Exception e)
//	        {
//	            System.out.println("can not find firefox process");
//	        }
//	        File file=new File("d:\\firebug-2.0.4-fx.xpi");
//	        FirefoxProfile profile = new FirefoxProfile();
//	        profile.setPreference("network.proxy.type", 2);
//	        profile.setPreference("network.proxy.autoconfig_url", "http://proxy.successfactors.com:8083");
//	        profile.setPreference("network.proxy.no_proxies_on", "localhost");
//	        
	     
//	        profile.setPreference("network.proxy.http", "proxy.domain.example.com");
//	        profile.setPreference("network.proxy.http_port", 8080);
//	        profile.setPreference("network.proxy.ssl", "proxy.domain.example.com");
//	        profile.setPreference("network.proxy.ssl_port", 8080);
//	        profile.setPreference("network.proxy.ftp", "proxy.domain.example.com");
//	        profile.setPreference("network.proxy.ftp_port", 8080);
//	        profile.setPreference("network.proxy.socks", "proxy.domain.example.com");
//	        profile.setPreference("network.proxy.socks_port", 8080);
	        
	 
//	        try {
//	            profile.addExtension(file);
//	            profile.setPreference("extensions.firebug.currentVersion", "2.0.4");
//	            profile.setPreference("extensions.firebug.allPagesActivation", "on");
//	        } catch (IOException e3) {
//	            // TODO Auto-generated catch block
//	            e3.printStackTrace();
//	        }
	    	
	    	driver = new FirefoxDriver();
    
	       // WebDriver driver = new FirefoxDriver();

	        return driver;
	        
	    }
	    public static WebDriver getIEDriver()
	    {
	       // String IEDriverServer="E:\\IEDriverServer.exe";
	    	String IEDriverServer=Config.getConfig("IEDriverServer");
	    	
	        System.setProperty("webdriver.ie.driver",IEDriverServer);
//	        WebDriver driver=new InternetExplorerDriver();
	        driver=new InternetExplorerDriver();
	        
	        return driver;
	    }

	    
	    public static WebDriver getAndroidDriver()
	    {
	    	//WebDriver driver = new AndroidDriver();
	    	driver = new AndroidDriver();

	        return driver;
	    }
	    // config/config.xml中具体配置使用哪个 driver
	    public static WebDriver getDriver(){
	    	String driverName=Config.getConfig("driver").toLowerCase().trim();
	    	
	    	switch(Driver.toDriver(driverName)){

	    	case chrome:

	    	driver=getChromeDriver();

	    	break;

	    	case firefox:

	    		driver=getFirefoxDriver();

	    	break;

	    	case ie:

	    		driver=getIEDriver();

	    	break;
	    	case android:

	    		driver=getAndroidDriver();

	    	break;

	    	case novalue:

	    		driver=getChromeDriver();

	    	break;
	    	default:
	    		driver=getChromeDriver();

		    	break;

	    	}
	    	
	    	return driver;
	    	
	    }
	    
	    public static void  close(){
	    	driver.close();
	    	driver.quit();
	    }
	    
	    
	    

	    public static void open(String URL){
	    	driver.get(URL);
	    }
	    
	    
	    
	    public static void maximize(){
	    	driver.manage().window().maximize();
	    }
//	    浏览器的前进和后退:这两个方法取决于浏览器的实现，可以会出现某些调用失败
//	    driver.navigate().forward();
//	    driver.navigate().back();
	    public static void back(){
	    	driver.navigate().back();
	    }
	    
	    public static void refresh(){
	    	driver.navigate().refresh(); // 页面刷新
	    }
	  //显示让driver等待4s让页面加载完成
	    public static void driverWait(int time){
	    	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	    	
	    }
	    
	    //boolean flag = DriverFactory.isElementExist(By.id("kw"));
	    //判断元素对象是否存在
	    public  static boolean isElementExist(By by){

	         try{

	              driver.findElement(by);

	              return true;

	            }catch(NoSuchElementException e){

	               return false;

	            }

	  }
	  //  获取元素

	    public static  WebElement findById(String id){

	      WebElement element=null;

	      if(isElementExist(By.id(id))){

	          element=driver.findElement(By.id(id));

	      }

	      return element;

	    }
	    
	    //元素组是否存在

	    public boolean elementsExists(By by){

	      return (driver.findElements(by).size()>0?true:false);

	    }
	    
	  //  从某组元素组中获取需要的某个元素

	    public WebElement findbyElements(By by,int index){

	      WebElement element=null;

	      if(elementsExists(by)){

	         element= driver.findElements(by).get(index);

	     }

	     return element;

	    }
	    
	    
	   // 弹出框判断

	    public boolean isAlertPresent(){

	       try{

	        alert = driver.switchTo().alert();

	          return true;

	         }catch(NoAlertPresentException e){

	              return false;

	         }

	    }

	   public void acceptAlert(){

	       if(isAlertPresent()){

	          alert.accept();

	       }

	    }

	   public void dismissAlert(){

	     if(isAlertPresent()){

	       alert.dismiss();

	    }

	   }

	   public String getAlertText(){

	     String text="";

	      if(isAlertPresent()){

	           text=alert.getText();

	      }else {

	     }

	     return text;

	   }
	   
	   public static void  deleteAllCookies(){
		   driver.manage().deleteAllCookies();
	   }
	   /*
	    *
	    *
	    
	    浏览器的安全测试，cookie是不能跨域的，所以你想操作A域名的cookie，首先你要让切换到A域名上
	    
	    driver.get("http://www.yeetrack.com");
 
//添加Cookie
Cookie cookie = new Cookie("uuid", "abcdedfjeiajfei");
driver.manage().addCookie(cookie);
 
//遍历当前域名的cookie
Set(Cookie) allCookies = driver.manage().getCookies();
for(Cookie loadedCookie : allCookies)
{
    System.out.println(String.format("%s ---> %s", loadedCookie.getName(), loadedCookie.getValue()));
}
	    */
	   public static void clearLocalStorage(){
		   String clearLocalStorage="window.localStorage.clear()";
			 String clearResult=(String) ((JavascriptExecutor)driver).executeScript(clearLocalStorage);
	   }
	   public static int getCookiesSize(){
		   return DriverFactory.driver.manage().getCookies().size();
	   }
	   public static int getLocalStorageSize(){
		   String js="var len= window.localStorage.length;return len;";
			 Long result=(Long)((JavascriptExecutor) DriverFactory.driver).executeScript(js);
	       return result.intValue();
	   }
	   public static JSONObject getLocalStorage(){//_h5v_history_watch_v2

		   //String jspre="var localstorage= window.localStorage.getItem(\\\"";
		  // String jsaf="\\\");return localstorage;";
		   String js="var localstorage= window.localStorage.getItem(\"_h5v_history_watch_v2\");return localstorage";
		   //String js="var len= window.localStorage.length;return len;";
		   //	String js=jspre+name+jsaf;//
		   //	System.out.println("&&&&&&&&&&&"+js);
		   	sleep();
		   	String jsonStr=(String)((JavascriptExecutor) DriverFactory.driver).executeScript(js);
		   
		   	JSONObject json = JSONObject.fromObject(jsonStr);
		   //	JSONArray json = JSONArray.fromObject(jsonStr);
		  
	   return json;
	   }
	   
	   public static JSONObject getRecentSearch(){//_search_recent
		   String js="var localstorage= window.localStorage.getItem(\"_search_recent\");return localstorage";
		   sleep();
		   	String jsonStr=(String)((JavascriptExecutor) DriverFactory.driver).executeScript(js);
		   
		   	JSONObject json = JSONObject.fromObject(jsonStr);
		   //	JSONArray json = JSONArray.fromObject(jsonStr);
		  
	   return json;
	   }
	   
	   public static void sleep(){
		   int millisecond =Integer.valueOf(Config.getConfig("sleep")) ;
		   sleep(millisecond);
		    
	   }
	   public static void sleep(int millisecond){
		   try {
				Thread.sleep(millisecond);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	   }
}  
