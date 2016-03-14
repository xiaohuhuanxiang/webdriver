package com.zhou.posidonautotest.mplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.MplayUrl;



public class MicrofilmRetrieval {
	private static Logger logger = LoggerFactory.getLogger(MicrofilmRetrieval.class);
	
	@Test
	public void testMicrofilmFilters(){
		
		String url=MplayUrl.MicrofilmFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testMicrofilmFilters");

	}
	@Test
	public void testMicrofilmAll(){
		Reporter.log("Microfilm Retrieval All :total > 0");
		 logger.info("Microfilm Retrieval All :total > 0");
		
		String url=MplayUrl.MicrofilmAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testMicrofilmDetail(){
		Reporter.log("Microfilm Detail :total > 0");
		 logger.info("Microfilm Detail :total > 0");
		
		String url=MplayUrl.MicrofilmDetail;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
