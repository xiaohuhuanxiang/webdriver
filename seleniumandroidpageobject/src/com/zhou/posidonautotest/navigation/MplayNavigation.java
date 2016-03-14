package com.zhou.posidonautotest.navigation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.MplayUrl;
import com.zhou.posidonautotest.VideoLibraryUrl;
import com.zhou.posidonautotest.vplay.CarRetrieval;
// 长视频导航的channelhome接口
public class MplayNavigation {

	private static Logger logger = LoggerFactory.getLogger(MplayNavigation.class);
	
	@Test
	public void testRecommentNavigation(){

		
		String url=MplayUrl.RecommentNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testRecommentNavigation");

	}
	
	@Test
	public void testFilmNavigation(){

		
		String url=MplayUrl.FilmNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testFilmNavigation");

	}
	@Test
	public void testTVSeriesNavigation(){

		
		String url=MplayUrl.TVSeriesNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testTVSeriesNavigation");

	}
	@Test
	public void testAnimalComicsNavigation(){

		
		String url=MplayUrl.AnimalComicsNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testAnimalComicsNavigation");

	}
	
	@Test
	public void testVarietyShowNavigation(){

		
		String url=MplayUrl.VarietyShowNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testVarietyShowNavigation");

	}
	
	@Test
	public void testMicrofilmNavigation(){

		
		String url=MplayUrl.MicrofilmNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testMicrofilmNavigation");

	}
	
	@Test
	public void testVideoLibraryNavigation(){

		
		String url=VideoLibraryUrl.VideoLibraryNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testVideoLibraryNavigation");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
