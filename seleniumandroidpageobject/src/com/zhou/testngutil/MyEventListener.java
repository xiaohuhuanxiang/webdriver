package com.zhou.testngutil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.zhou.autotest.DriverFactory;

//自定义事件监听

/*
 
 方便记录测试代码的执行和各种页面操作的预期步骤是否一致；

方便在某件事件发生后，添加辅助代码来协助后续测试用例执行


 */
public class MyEventListener extends AbstractWebDriverEventListener{

	@Override
	public void afterNavigateTo(String url,WebDriver driver){

	System.out.println("after Navigate To" +url);

	}

	@Override
	public void afterNavigateBack(WebDriver driver){

	System.out.println("after Navigate Back To" +driver.getCurrentUrl());

	}

	@Override
	public void afterClickOn(WebElement webElement,WebDriver driver){

	System.out.println("after Click On" +webElement.getText());

	}
	
	public static void main(String[] args) {
		
		
	}

}
