package com.zhou.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.zhou.autotest.DriverFactory;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class Selenium {


	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = DriverFactory.getChromeDriver();
	    baseUrl = "http://m1.fun.tv/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void test5() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.xpath("//a[contains(text(),'电视剧')]")).click();
	    driver.findElement(By.id("seeAllBtn")).click();
	    driver.findElement(By.xpath("//img[contains(@src,'http://img.funshion.com/sdw?oid=3db727f32a8e759bf6b0534c21819226&w=200&h=280')]")).click();
	    driver.findElement(By.id("m-h5v-full-1")).click();
	    driver.findElement(By.id("m-h5v-video-1")).click();
	    driver.findElement(By.id("m-h5v-full-1")).click();
	    driver.findElement(By.id("m-h5v-video-1")).click();
	    driver.findElement(By.id("m-h5v-play-1")).click();
	    driver.findElement(By.xpath("//div[@id='m-h5v-player-1']/div[8]")).click();
	    driver.findElement(By.id("m-h5v-bigplay-1")).click();
	    driver.findElement(By.linkText("10")).click();
	    driver.findElement(By.id("m-h5v-video-1")).click();
	    driver.findElement(By.id("m-h5v-play-1")).click();
	    driver.findElement(By.xpath("//div[@id='m-h5v-player-1']/div[8]")).click();
	  }
//
//	  @AfterClass(alwaysRun = true)
//	  public void tearDown() throws Exception {
//	    driver.quit();
//	    String verificationErrorString = verificationErrors.toString();
//	    if (!"".equals(verificationErrorString)) {
//	      fail(verificationErrorString);
//	    }
//	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }


}
