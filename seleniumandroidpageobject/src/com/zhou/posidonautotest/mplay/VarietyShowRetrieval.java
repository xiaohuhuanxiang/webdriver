package com.zhou.posidonautotest.mplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.MplayUrl;



public class VarietyShowRetrieval {
	private static Logger logger = LoggerFactory.getLogger(VarietyShowRetrieval.class);
	
	@Test
	public void testVarietyShowFilters(){
		
		String url=MplayUrl.VarietyShowFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testVarietyShowFilters");

	}
	@Test
	public void testVarietyShowAll(){
		Reporter.log("VarietyShow Retrieval All :total > 0");
		 logger.info("VarietyShow Retrieval All :total > 0");
		
		String url=MplayUrl.VarietyShowAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testVarietyShowDetail(){
		Reporter.log("VarietyShow Detail :total > 0");
		 logger.info("VarietyShow Detail :total > 0");
		
		String url=MplayUrl.VarietyShowDetail;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
