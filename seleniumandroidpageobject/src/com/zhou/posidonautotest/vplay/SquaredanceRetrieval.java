package com.zhou.posidonautotest.vplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;

import com.zhou.posidonautotest.VplayUrl;

public class SquaredanceRetrieval {
	private static Logger logger = LoggerFactory.getLogger(SquaredanceRetrieval.class);
	// 返回的筛选条件检查
	
	@Test
	public void testSquaredanceFilters(){
		
		String url=VplayUrl.SquaredanceFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testSquaredanceFilters");

	}

	//以下是具体的筛选
	@Test
	public void testSquaredanceAll(){
		Reporter.log("Squaredance Retrieval All :total > 0");
		 logger.info("Squaredance Retrieval All :total > 0");
		
		String url=VplayUrl.SquaredanceAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testSquaredanceTeaching(){
		Reporter.log("Squaredance Teaching :total > 0");
		 logger.info("Squaredance Teaching :total > 0");
		
		String url=VplayUrl.SquaredanceTeaching;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
