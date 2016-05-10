package com.zhou.posidonautotest.vip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.TestngLog;
import com.zhou.posidonautotest.VipUrl;



public class Vip {

	private static Logger logger = LoggerFactory.getLogger(Vip.class);
	
	@Test
	public void testVipNavigation(){

		
		String url=VipUrl.Vipurl;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		if(false == total){
			TestngLog.log(url, "AssertChannelHome");
		}
		 Assert.assertTrue(total, "testVipNavigation");

	}
	@Test
	public void testVipFilter(){

		
		String url=VipUrl.filtersurl;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertFilters(url);
		if(false == total){
			TestngLog.log(url, "AssertFilters");
		}
		 Assert.assertTrue(total, "testVipFilters");

	}
	
	@Test
	public void testVipRetrieval(){

		
		String url=VipUrl.retrievalurl;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.responseAssert(url);
		if(false == total){
			TestngLog.log(url, "AssertRetrieval");
		}
		 Assert.assertTrue(total, "testVipRetrieval");

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
