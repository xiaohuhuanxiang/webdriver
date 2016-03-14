package com.zhou.posidonautotest.vplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;

import com.zhou.posidonautotest.VplayUrl;

public class ScienceRetrieval {
	private static Logger logger = LoggerFactory.getLogger(ScienceRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testScienceFilters(){
		
		String url=VplayUrl.scienceFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testScienceFilters");

	}

	//以下是具体的筛选
	@Test
	public void testScienceAll(){
		Reporter.log("Science Retrieval All :total > 0");
		
		String url=VplayUrl.scienceAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");
		 logger.info("Science Retrieval All :total > 0");
	}
	@Test
	public void testScienceSituation(){
		Reporter.log("Military Retrieval Situation :total > 0");
		
		String url=VplayUrl.scienceLatest;
		
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");
		 logger.info("Military Retrieval Situation :total > 0");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
