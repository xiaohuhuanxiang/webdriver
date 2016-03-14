package com.zhou.posidonautotest.mplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.MplayUrl;



public class AnimalComicsRetrieval {
	private static Logger logger = LoggerFactory.getLogger(AnimalComicsRetrieval.class);
	
	// 返回的筛选条件检查
	
	@Test
	public void testAnimalComicsFilters(){
		
		String url=MplayUrl.AnimalComicsFilters;
	
		boolean total= HttpAssert.AssertFilters(url);
		 Assert.assertTrue(total, "testAnimalComicsFilters");

	}

	//以下是具体的筛选
	@Test
	public void testAnimalComicsAll(){
		
		String url=MplayUrl.AnimalComicsAll;
	
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	@Test
	public void testAnimalComicsDetail(){
		
		String url=MplayUrl.AnimalComicsDetail;
		
		boolean total= HttpAssert.responseAssert(url); 
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
