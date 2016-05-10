package com.zhou.androidautotest;

import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zhou.autotest.DriverFactory;
import com.zhou.autotest.M1_fun_tv_home_common;

public class M1_fun_tv_android_Rotation {
	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_android_Rotation.class");
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
	@Test(dependsOnMethods = { "testClickSkip" })   
	public void rotation(){
		DriverFactory.sleep(2000);
		((Rotatable)DriverFactory.driver).rotate(ScreenOrientation.PORTRAIT);// 屏幕旋转
		DriverFactory.sleep();
		TouchActions touch = new TouchActions(DriverFactory.driver);//触摸和滚动 
		touch.scroll(200, 800).build().perform();
	}
}
