package com.zhou.posidonautotest.vplay;



import com.zhou.posidonautotest.VplayUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;



public class LifeRetrieval {
	private static Logger logger = LoggerFactory.getLogger(LifeRetrieval.class);
	
	// 返回的筛选条件检查
	
		@Test
		public void testLifeFilters(){
			
			String url=VplayUrl.lifeFilters;
		
			boolean total= HttpAssert.AssertFilters(url);
			 Assert.assertTrue(total, "testLifeFilters");

		}

		//以下是具体的筛选
	@Test
	public void testLifeAll(){
		Reporter.log("Life Retrieval All :total > 0");
		
		String url=VplayUrl.lifeAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");
		 logger.info("Life Retrieval All :total > 0");
	}
	@Test
	public void testLifeSituation(){
		Reporter.log("Life Retrieval Food :total > 0");
		
		String url=VplayUrl.lifeFood;
		
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");
		 logger.info("Military Retrieval Situation :total > 0");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
