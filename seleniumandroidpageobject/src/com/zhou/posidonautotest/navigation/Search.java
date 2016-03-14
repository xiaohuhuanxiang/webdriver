package com.zhou.posidonautotest.navigation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.MplayUrl;

public class Search {

	String keywords="社交网络";
	
	
/*
 * 
 长视频：搜索社交网络---仅仅聚合有结果
返回ok即可：http://psi.funshion.com/v5/site/search?q=%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%BB%9C&sz=50&cl=mweb&uc=30
搜索全网媒体接口（媒体+聚合媒体）
http://ps.funshion.com/v6/search/media?vip=1&q=%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%BB%9C&sz=30&cl=mweb&uc=30

根据用户输入关键字搜索视频-即页面上的相关视频
http://ps.funshion.com/v5/search/video?q=%E4%B8%89%E4%B8%AA%E5%A5%B6%E7%88%B8&sz=10&cl=mweb&uc=30
 */
@Test
public void testMediaSearch(){
	//搜索《社交网络》
	String url="http://ps.funshion.com/v6/search/media?vip=1&q=%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%BB%9C&sz=30&cl=mweb&uc=30";

	boolean total= HttpAssert.AssertSearch(url, "medias", keywords);
	 Assert.assertTrue(total, "搜索全网媒体接口（媒体+聚合媒体）");
		
	}
@Test(dependsOnMethods = { "testMediaSearch" })   
public void testVideoSearch(){
	//搜索《社交网络》
	String url="http://ps.funshion.com/v5/search/video?q=%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%BB%9C&sz=10&cl=mweb&uc=30";
	boolean total= HttpAssert.AssertSearch(url, "videos", keywords);
	 Assert.assertTrue(total, "Related videos");
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
