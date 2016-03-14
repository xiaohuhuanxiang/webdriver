package com.zhou.posidonautotest.vplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;

import com.zhou.posidonautotest.VplayUrl;

public class SportsRetrieval {
	private static Logger logger = LoggerFactory.getLogger(SportsRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testSportsFilters(){
		
		String url=VplayUrl.sportsFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testSportsFilters");

	}

	//以下是具体的筛选
	@Test
	public void testsportsAll(){
		Reporter.log("Sports Retrieval All :total > 0");
		 logger.info("Sports Retrieval All :total > 0");
		
		String url=VplayUrl.sportsAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testsportsBasketball(){
		Reporter.log("sports Basketball :total > 0");
		 logger.info("sports Basketball :total > 0");
		
		String url=VplayUrl.sportsBasketball;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
