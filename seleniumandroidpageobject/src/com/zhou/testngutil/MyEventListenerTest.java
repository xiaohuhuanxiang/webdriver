package com.zhou.testngutil;

import org.openqa.selenium.By;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.zhou.autotest.DriverFactory;

public class MyEventListenerTest {

	@Test
	public void testtest(){
		
		DriverFactory.getDriver();
		EventFiringWebDriver eventFiringWebDriver =
				new EventFiringWebDriver(DriverFactory.driver);

			MyEventListener myEventListener = new MyEventListener ();

			eventFiringWebDriver.register(myEventListener);


			 eventFiringWebDriver.get("http://m1.fun.tv/?nav=5");// 被MyEventListener 监听
			 
			 DriverFactory.sleep();
			 
			 eventFiringWebDriver.get("http://m1.fun.tv/");// 被MyEventListener 监听
			
			 DriverFactory.sleep();
			 eventFiringWebDriver.navigate().back();// 被MyEventListener 监听

			 DriverFactory.sleep();
			eventFiringWebDriver.findElement(By.xpath("//*[@id=\"pgContent\"]/section[2]/div/div[1]/a/div[1]/img")).click();// 被MyEventListener 监听

			
			
			
	}
	
	// 待   屏幕旋转   +  触摸和滚动 P 148 针对手机，如android
	
//	driver.get("http://m.fun.tv/");
//	((Rotatable)driver).rotate(ScreenOrientation.PORTRAIT);// 屏幕旋转
//	TouchActions touch = new TouchActions(driver);//触摸和滚动 
//	touch.scroll(200, 800).build().perform();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
