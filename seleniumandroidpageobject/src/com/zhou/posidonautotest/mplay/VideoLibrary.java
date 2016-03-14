package com.zhou.posidonautotest.mplay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.GuessYouLikeAndVideoNumberUrl;
import com.zhou.posidonautotest.MplayUrl;
import com.zhou.posidonautotest.VideoLibraryUrl;

public class VideoLibrary {
	private static Logger logger = LoggerFactory.getLogger(VideoLibrary.class);
	
	@Test
	public void testVideoLibraryVarietyShowFilters(){
		
		String url=VideoLibraryUrl.varietyshowFilters;//影视库中的综艺的筛选条件
	
		boolean total= HttpAssert.AssertVideoLibraryFilters(url);
		 Assert.assertTrue(total, "testVideoLibraryVarietyShowFilters");

	}
	
	@Test
	public void testVideoLibraryFilmFilters(){
		
		String url=VideoLibraryUrl.filmFilters;//影视库中的电影的筛选条件
	
		boolean total= HttpAssert.AssertVideoLibraryFilters(url);
		 Assert.assertTrue(total, "testVideoLibraryFilmFilters");

	}
	@Test
	public void testVideoLibraryTVseriesFilters(){
		
		String url=VideoLibraryUrl.TVseriesFilters;//影视库中的电视剧的筛选条件
	
		boolean total= HttpAssert.AssertVideoLibraryFilters(url);
		 Assert.assertTrue(total, "testVideoLibraryTVseriesFilters");

	}
	@Test
	public void testVideoLibraryAnimalComicsFilters(){
		
		String url=VideoLibraryUrl.AnimalComicsFilters;//影视库中的动漫的筛选条件
	
		boolean total= HttpAssert.AssertVideoLibraryFilters(url);
		 Assert.assertTrue(total, "testVideoLibraryAnimalComicsFilters");

	}
	//以下是检索页的筛选
	
	@Test
	public void testVideoLibrary(){
		Reporter.log("VideoLibrary : blocks > 0");
		 logger.info("VideoLibrary : blocks > 0");
		
		String url=VideoLibraryUrl.VideoLibraryurl;
	    String reponseFieldsName="blocks";
	    // 验证 blocks 数组的大小 >0
		boolean total= HttpAssert.responseAssertArray(url, reponseFieldsName);
		 Assert.assertTrue(total, "blocks size > 0");

	}
	
//	//电影
//		public static final String filmurl=baseurl+"&channel=2001";	
//	//电视剧
//		public static final String TVseriesurl=baseurl+"&channel=2002";	
//	//综艺
//		public static final String varietyshowurl=baseurl+"&channel=2004";	
//	//动漫
//		public static final String AnimalComicsurl=baseurl+"&channel=2003";	
	
	@Test(dependsOnMethods = { "testVideoLibrary" })  
	public void testVideoLibraryFilm(){
		Reporter.log("VideoLibrary Film : total > 0");
		 logger.info("VideoLibrary Film : total > 0");
		
		String url=VideoLibraryUrl.filmurl;
	    // 验证 total >0
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}	
	@Test(dependsOnMethods = { "testVideoLibrary" })  
	public void testVideoLibraryTVseries(){
		Reporter.log("VideoLibrary TVseries : total > 0");
		 logger.info("VideoLibrary TVseries : total > 0");
		
		String url=VideoLibraryUrl.TVseriesurl;
	    // 验证 total >0
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}	
	@Test(dependsOnMethods = { "testVideoLibrary" })  
	public void testVideoLibraryVarietyshow(){
		Reporter.log("VideoLibrary Varietyshow : total > 0");
		 logger.info("VideoLibrary Varietyshow : total > 0");
		
		String url=VideoLibraryUrl.varietyshowurl;
	    // 验证 total >0
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}	
	@Test(dependsOnMethods = { "testVideoLibrary" })  
	public void testVideoLibraryAnimalComics(){
		Reporter.log("VideoLibrary AnimalComics : total > 0");
		 logger.info("VideoLibrary AnimalComics : total > 0");
		
		String url=VideoLibraryUrl.AnimalComicsurl;
	    // 验证 total >0
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
