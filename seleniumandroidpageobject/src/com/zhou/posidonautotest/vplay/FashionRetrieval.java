package com.zhou.posidonautotest.vplay;


import com.zhou.posidonautotest.VplayUrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;



public class FashionRetrieval {
	private static Logger logger = LoggerFactory.getLogger(FashionRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testFashionFilters(){
		
		String url=VplayUrl.fashionFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testFashionFilters");

	}

	//以下是具体的筛选
	@Test
	public void testFashionAll(){
		Reporter.log("Fashion Retrieval All :total > 0");
		 logger.info("Fashion Retrieval All :total > 0");
		
		String url=VplayUrl.fashionAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testFashionStarStyle(){
		Reporter.log("Fighting Retrieval StarStyle :total > 0");
		 logger.info("Fighting Retrieval StarStyle :total > 0");
		
		String url=VplayUrl.fashionStarStyle;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
