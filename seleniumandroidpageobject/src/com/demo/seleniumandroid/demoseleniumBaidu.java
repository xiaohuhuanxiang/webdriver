package com.demo.seleniumandroid;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;


public class demoseleniumBaidu  {

	
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
		driver.get("http://m.baidu.com/");
		System.out.println("title:"+driver.getTitle());//title:�ٶ�һ��
			WebElement element = driver.findElement(By.name("word"));
			element.sendKeys("hello");
			
			element.submit();
			
			System.out.println("title:"+driver.getTitle());//title:hello - �ٶ�
		driver.quit();
	}

}
