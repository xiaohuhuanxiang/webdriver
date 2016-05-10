package com.zhou.autotest.user;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.zhou.autotest.DriverFactory;
import com.zhou.autotest.M1_fun_tv_home_common;

public class SetupAndTearDown {

	// setUp + tearDown 可以单独抽取到一个类中
		@BeforeSuite
//		 @Parameters({ "http://m1.fun.tv/" })
		public void setUp() {
	 
			 DriverFactory.getDriver();

//				DriverFactory.deleteAllCookies();
//				DriverFactory.clearLocalStorage();
//				
//				DriverFactory.refresh();// 页面刷新


		}
		
		@AfterSuite
		public void tearDown() {
			DriverFactory.close();
		
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
