package com.zhou.posidonautotest.vplay;


import com.zhou.posidonautotest.VplayUrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;



public class HotSpotRetrieval {
	private static Logger logger = LoggerFactory.getLogger(HotSpotRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testHotspotFilters(){
		
		String url=VplayUrl.HotspotFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testHotspotFilters");

	}

	//以下是具体的筛选
	@Test
	public void testHotspotAll(){
		Reporter.log("Hotspot Retrieval All :total > 0");
		 logger.info("Hotspot Retrieval All :total > 0");
		
		String url=VplayUrl.HotspotAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testHotspotThisMonth(){
		Reporter.log("Hotspot ThisMonth :total > 0");
		 logger.info("Hotspot ThisMonth :total > 0");
		
		String url=VplayUrl.HotspotThisMonth;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
