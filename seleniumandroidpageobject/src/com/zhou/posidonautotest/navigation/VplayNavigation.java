package com.zhou.posidonautotest.navigation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.GuessYouLikeAndVideoNumberUrl;
import com.zhou.posidonautotest.MplayUrl;
import com.zhou.posidonautotest.VplayUrl;
//小视频导航的channelhome接口
public class VplayNavigation {

	
	@Test
	public void testGuessYouLikeNavigation(){

		
		String url=GuessYouLikeAndVideoNumberUrl.GuessYouLikeNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testGuessYouLikeNavigation");

	}
	@Test
	public void testVideoNumberNavigation(){

		
		String url=GuessYouLikeAndVideoNumberUrl.VideoNumberNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testVideoNumberNavigation");

	}
	
	@Test
	public void testHotspotNavigation(){

		
		String url=VplayUrl.HotspotNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testHotspotNavigation");

	}
	@Test
	public void testEntertainmentNavigation(){

		
		String url=VplayUrl.EntertainmentNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testEntertainmentNavigation");

	}
	@Test
	public void testNewsNavigation(){

		
		String url=VplayUrl.NewsNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testNewsNavigation");

	}
	@Test
	public void testFunnyNavigation(){

		
		String url=VplayUrl.FunnyNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testFunnyNavigation");

	}
	@Test
	public void testmilitaryNavigation(){

		
		String url=VplayUrl.militaryNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testmilitaryNavigation");

	}
	@Test
	public void testSquaredanceNavigation(){

		
		String url=VplayUrl.SquaredanceNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testSquaredanceNavigation");

	}

	@Test
	public void testsportsNavigation(){

		
		String url=VplayUrl.sportsNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testsportsNavigation");

	}
	@Test
	public void testgameNavigation(){

		
		String url=VplayUrl.gameNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testgameNavigation");

	}
	@Test
	public void testCarNavigation(){

		
		String url=VplayUrl.carNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testCarNavigation");

	}
	@Test
	public void testScienceNavigation(){

		
		String url=VplayUrl.scienceNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testScienceNavigation");

	}
	@Test
	public void testTourismNavigation(){

		
		String url=VplayUrl.tourismNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testTourismNavigation");

	}
	@Test
	public void testFashionNavigation(){

		
		String url=VplayUrl.fashionNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testFashionNavigation");

	}
	@Test
	public void testLifeNavigation(){

		
		String url=VplayUrl.lifeNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testLifeNavigation");

	}
	@Test
	public void testEPLNavigation(){

		
		String url=VplayUrl.EPLNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testEPLNavigation");

	}
	@Test
	public void testfightingNavigation(){

		
		String url=VplayUrl.fightingNavigation;
	    // 验证 各个节点都有返回
		boolean total= HttpAssert.AssertChannelHome(url);
		 Assert.assertTrue(total, "testfightingNavigation");

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
