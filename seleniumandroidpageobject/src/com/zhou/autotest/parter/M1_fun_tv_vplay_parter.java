package com.zhou.autotest.parter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zhou.autotest.DriverFactory;
import com.zhou.autotest.M1_fun_tv_home_common;

//小知   播放页
public class M1_fun_tv_vplay_parter {

	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_vplay_parter.class");
	private M1_fun_tv_home_common m1_fun_tv_home_common;
	
	
	@BeforeTest
	public void setUp() {
	

//		 DriverFactory.getDriver();
		m1_fun_tv_home_common= new M1_fun_tv_home_common();
			
	}
//	
//	@AfterTest
//	public void tearDown() {
//		DriverFactory.close();
//	}
	
	//小知   播放页
	
	@Test
	public void testOpen(){
		//http://m.fun.tv/partner/xz.html?vid=8105566&malliance=2210
		DriverFactory.open(m1_fun_tv_home_common.baseurl+"/partner/xz.html?vid=8122929&malliance=2210");
		
		
	}
	
	// 小知   播放页 可以全屏 + 快进   + 点播相关推荐
	@Test(dependsOnMethods = { "testOpen" })  
    public void testPauseAndPlay() {  
		Reporter.log(m1_fun_tv_home_common.getCurrentUrl(),true);//报告中打印当前urls
		m1_fun_tv_home_common.PauseAndFullPlay();
		
   }
	
	@Test(dependsOnMethods = { "testPauseAndPlay" })  
    public void testPlayRelate() {  
		
		m1_fun_tv_home_common.excutejs("document.getElementsByClassName(\"tit\")[1].click()");// 点击相关推荐中的左边第一个视频
		DriverFactory.sleep();//等待3s
		Reporter.log(m1_fun_tv_home_common.getCurrentUrl(),true);//报告中打印当前urls
		
		//点击下一个播放
			
		
   }
	@Test(dependsOnMethods = { "testPlayRelate" })  
    public void testClickNext() {  

		m1_fun_tv_home_common.PlayNext();
		Reporter.log(m1_fun_tv_home_common.getCurrentUrl(),true);//报告中打印当前urls
   }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
