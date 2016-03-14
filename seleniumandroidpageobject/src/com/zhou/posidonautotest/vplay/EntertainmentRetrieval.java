package com.zhou.posidonautotest.vplay;

import com.zhou.posidonautotest.VplayUrl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;



public class EntertainmentRetrieval {
	private static Logger logger = LoggerFactory.getLogger(EntertainmentRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testEntertainmentFilters(){
		
		String url=VplayUrl.EntertainmentFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testEntertainmentFilters");

	}

	//以下是具体的筛选
	@Test
	public void testEntertainmentAll(){
		Reporter.log("Entertainment Retrieval All :total > 0");
		 logger.info("Entertainment Retrieval All :total > 0");
		
		String url=VplayUrl.EntertainmentAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testEntertainmentHeadlines(){
		Reporter.log("Entertainment Headlines :total > 0");
		 logger.info("Entertainment Headlines :total > 0");
		
		String url=VplayUrl.EntertainmentHeadlines;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
