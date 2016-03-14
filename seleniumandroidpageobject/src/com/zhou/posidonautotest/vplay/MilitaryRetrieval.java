package com.zhou.posidonautotest.vplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;

import com.zhou.posidonautotest.VplayUrl;

public class MilitaryRetrieval {
	private static Logger logger = LoggerFactory.getLogger(MilitaryRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testMilitaryFilters(){
		
		String url=VplayUrl.militaryFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testMilitaryFilters");

	}

	//以下是具体的筛选
	@Test
	public void testMilitaryAll(){
		Reporter.log("Military Retrieval All :total > 0");
		
		String url=VplayUrl.militaryAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");
		 logger.info("Military Retrieval All :total > 0");
	}
	@Test
	public void testMilitarySituation(){
		Reporter.log("Military Retrieval Situation :total > 0");
		
		String url=VplayUrl.militarySituation;
		
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");
		 logger.info("Military Retrieval Situation :total > 0");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
