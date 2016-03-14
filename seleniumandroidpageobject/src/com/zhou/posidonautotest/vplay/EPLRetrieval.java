package com.zhou.posidonautotest.vplay;

import com.zhou.posidonautotest.VplayUrl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;



public class EPLRetrieval {
	private static Logger logger = LoggerFactory.getLogger(EPLRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testEPLFilters(){
		
		String url=VplayUrl.EPLFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testEPLFilters");

	}

	//以下是具体的筛选
	@Test
	public void testEPLAll(){
		Reporter.log("EPL Retrieval All :total > 0");
		
		String url=VplayUrl.EPLAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");
		 logger.info("EPL Retrieval All :total > 0");
	}
	@Test
	public void testEPLManchester(){
		Reporter.log("EPL Retrieval Manchester :total > 0");
		
		String url=VplayUrl.EPLManchester;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");
		 logger.info("EPL Retrieval Manchester :total > 0");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
