package com.zhou.posidonautotest.vplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.MplayUrl;
import com.zhou.posidonautotest.VplayUrl;



public class CarRetrieval {
	private static Logger logger = LoggerFactory.getLogger(CarRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testCarFilters(){
		
		String url=VplayUrl.carFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testCarFilters");

	}

	//以下是具体的筛选
	@Test
	public void testCarAll(){
		Reporter.log("Car Retrieval All :total > 0");
		 logger.info("Car Retrieval All :total > 0");
		
		String url=VplayUrl.carAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testcarFunNews(){
		Reporter.log("car FunNews :total > 0");
		 logger.info("car FunNews :total > 0");
		
		String url=VplayUrl.carFunNews;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
