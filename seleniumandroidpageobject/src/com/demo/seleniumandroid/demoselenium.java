package com.demo.seleniumandroid;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
public class demoselenium  {
//extends TestCase
	
	public static void main(String[] args) {
	
		try {
			//��webdriver
			Runtime.getRuntime().exec("adb shell am start -a android.intent.action.MAIN "
					+ "-n org.openqa.selenium.android.app/.MainActivity");
			/*���ӷ����webdriver�������õĶ˿�Ϊ8080����������п����˻�ʹ���˸ö˿ڣ���Ҫ�رգ�http://localhost:8080/exit������Ȼ���Ӳ��Ϸ����webdriver   */
			Runtime.getRuntime().exec("adb -s YHDAAAUK99999999 forward tcp:8080 tcp:8080");
		} catch (Exception e) {
			// TODO: handle exception
		}
		WebDriver driver = new AndroidDriver();
		//((Rotatable)driver).rotate(ScreenOrientation.LANDSCAPE);
		//driver.get("http://m.fun.tv/");
//			WebElement element = driver.findElement(By.name("q"));
//			element.sendKeys("hello");
//			
//			element.submit();
//			
		
		driver.get("http://m.fun.tv/");
//		((Rotatable)driver).rotate(ScreenOrientation.PORTRAIT);
//		TouchActions touch = new TouchActions(driver);
//		touch.scroll(200, 800).build().perform();
			System.out.println("title:"+driver.getTitle());//console ��ӡtitle:������-�й����ȵ���һ����Ƶƽ̨
//		driver.quit();
	}

}
