package com.zhou.posidonautotest.mplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.MplayUrl;



public class TVSeriesRetrieval {
	private static Logger logger = LoggerFactory.getLogger(TVSeriesRetrieval.class);
	
	@Test
	public void testTVSeriesFilters(){
		
		String url=MplayUrl.TVSeriesFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testTVSeriesFilters");

	}
	@Test
	public void testTVSeriesAll(){
		Reporter.log("TVSeries Retrieval All :total > 0");
		 logger.info("TVSeries Retrieval All :total > 0");
		
		String url=MplayUrl.TVSeriesAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testTVSeriesDetail(){
		Reporter.log("TVSeries Detail :total > 0");
		 logger.info("TVSeries Detail :total > 0");
		
		String url=MplayUrl.TVSeriesDetail;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
