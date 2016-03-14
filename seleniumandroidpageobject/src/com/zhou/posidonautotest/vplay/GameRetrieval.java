package com.zhou.posidonautotest.vplay;


import com.zhou.posidonautotest.VplayUrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;



public class GameRetrieval {
	private static Logger logger = LoggerFactory.getLogger(GameRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testGameFilters(){
		
		String url=VplayUrl.gameFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testGameFilters");

	}

	//以下是具体的筛选
	@Test
	public void testGameAll(){
		Reporter.log("Game Retrieval All :total > 0");
		 logger.info("Game Retrieval All :total > 0");
		
		String url=VplayUrl.gameAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testgameCompetition(){
		Reporter.log("game Competition :total > 0");
		 logger.info("game Competition :total > 0");
		
		String url=VplayUrl.gameCompetition;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
