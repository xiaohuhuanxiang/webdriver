package com.zhou.autotest.parter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zhou.autotest.DriverFactory;
import com.zhou.autotest.M1_fun_tv_home_common;

// 一点资讯  app 内嵌的播放页   不能全屏播放，可以 快进 + 暂停
public class M1_fun_tv_vplay_parterOnePoint {

	
	private static final Logger logger = LoggerFactory.getLogger("M1_fun_tv_vplay_parterOnePoint.class");
	private M1_fun_tv_home_common m1_fun_tv_home_common;
	
	
	@BeforeTest
	public void setUp() {
	

//	 DriverFactory.getDriver();
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
//http://m.fun.tv/partner/player.html?vid=8113862&malliance=2186&autoplay=0&poster=http%3A%2F%2Fimg.funshion.com%2Fsdw%3Foid%3D6dca1ae7c9a4653faab94d182559c9de%26w%3D0%26h%3D0

//http://m.fun.tv/partner/player.html?vid=8114602&malliance=2186&autoplay=0&poster=http%3A%2F%2Fimg.funshion.com%2Fsdw%3Foid%3Dd3ea2444a4ab30e8b6c4b2c490df5bf2%26w%3D0%26h%3D0



		DriverFactory.open(m1_fun_tv_home_common.baseurl+"/partner/player.html?vid=8110662&malliance=2186&autoplay=0&poster=http%3A%2F%2Fimg.funshion.com%2Fsdw%3Foid%3D48fa77de108274eaa279e95007d5deee%26w%3D0%26h%3D0");
		
		
	}
	
	// 小知   播放页 可以全屏 + 快进   + 点播相关推荐
	@Test(dependsOnMethods = { "testOpen" })  
    public void testPauseAndPlay() {  
		Reporter.log(m1_fun_tv_home_common.getCurrentUrl(),true);//报告中打印当前urls
		m1_fun_tv_home_common.PlayAndPause();
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
