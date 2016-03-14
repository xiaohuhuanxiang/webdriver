package com.zhou.posidonautotest.mplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.MplayUrl;



public class FilmRetrieval {
	private static Logger logger = LoggerFactory.getLogger(FilmRetrieval.class);
	
	@Test
	public void testFilmFilters(){
		
		String url=MplayUrl.FilmFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testFilmFilters");

	}
	@Test
	public void testFilmAll(){
		Reporter.log("Film Retrieval All :total > 0");
		 logger.info("Film Retrieval All :total > 0");
		
		String url=MplayUrl.FilmAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testFilmDetail(){
		Reporter.log("Film Detail :total > 0");
		 logger.info("Film Detail :total > 0");
		
		String url=MplayUrl.FilmDetail;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
