package com.zhou.posidonautotest.vplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.VplayUrl;


public class TourismRetrieval {
	private static Logger logger = LoggerFactory.getLogger(TourismRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testTourismFilters(){
		
		String url=VplayUrl.tourismFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testTourismFilters");

	}

	//以下是具体的筛选
	@Test
	public void testTourismAll(){
		Reporter.log("Tourism Retrieval All :total > 0");
		 logger.info("Tourism Retrieval All :total > 0");
		
		String url=VplayUrl.tourismAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testtourismGlobalGossip(){
		Reporter.log("tourism GlobalGossip :total > 0");
		 logger.info("tourism GlobalGossip :total > 0");
		
		String url=VplayUrl.tourismGlobalGossip;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
