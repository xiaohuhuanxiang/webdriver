package com.zhou.posidonautotest.vplay;


import com.zhou.posidonautotest.VplayUrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;



public class FightingRetrieval {
	private static Logger logger = LoggerFactory.getLogger(FightingRetrieval.class);
	
	// 返回的筛选条件检查
	
		@Test
		public void testFightingFilters(){
			
			String url=VplayUrl.fightingFilters;
		
			boolean total= HttpAssert.AssertFilters(url);
			 Assert.assertTrue(total, "testFightingFilters");

		}

		//以下是具体的筛选
	@Test
	public void testFightingAll(){
		Reporter.log("Fighting Retrieval All :total > 0");
		
		String url=VplayUrl.fightingAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");
		 logger.info("Fighting Retrieval All :total > 0");
	}
	@Test
	public void testfightingBoxing(){
		Reporter.log("Fighting Retrieval Boxing :total > 0");
		
		String url=VplayUrl.fightingBoxing;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");
		 logger.info("Fighting Retrieval Boxing :total > 0");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
