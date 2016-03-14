package com.zhou.posidonautotest.vplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;

import com.zhou.posidonautotest.VplayUrl;

public class NewsRetrieval {
	private static Logger logger = LoggerFactory.getLogger(NewsRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testNewsFilters(){
		
		String url=VplayUrl.NewsFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testNewsFilters");

	}

	//以下是具体的筛选
	@Test
	public void testNewsAll(){
		Reporter.log("News Retrieval All :total > 0");
		 logger.info("News Retrieval All :total > 0");
		
		String url=VplayUrl.NewsAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testNewsDomestic(){
		Reporter.log("News Domestic :total > 0");
		 logger.info("News Domestic :total > 0");
		
		String url=VplayUrl.NewsDomestic;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
