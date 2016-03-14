package com.zhou.posidonautotest.vplay;

import com.zhou.posidonautotest.VplayUrl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;



public class FunnyRetrieval {
	private static Logger logger = LoggerFactory.getLogger(FunnyRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testFunnyFilters(){
		
		String url=VplayUrl.FunnyFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testFunnyFilters");

	}

	//以下是具体的筛选
	@Test
	public void testFunnyAll(){
		Reporter.log("Funny Retrieval All :total > 0");
		 logger.info("Funny Retrieval All :total > 0");
		
		String url=VplayUrl.FunnyAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testFunnyPetDaily(){
		Reporter.log("Funny PetDaily :total > 0");
		 logger.info("Funny PetDaily :total > 0");
		
		String url=VplayUrl.FunnyPetDaily;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
