package com.zhou.autotest;

public class Test {

	public static void main(String[] args) {
      
		DriverFactory.getFirefoxDriver();
		
		DriverFactory.open("http://m1.fun.tv/");
		
	}

}
