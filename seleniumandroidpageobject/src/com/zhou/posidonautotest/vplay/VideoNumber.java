package com.zhou.posidonautotest.vplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.GuessYouLikeAndVideoNumberUrl;
import com.zhou.posidonautotest.MplayUrl;

//视频好
//
//http://psi.funshion.com/v5/site/classlist?cl=mweb&uc=30
//
//{
//  "retcode": "200",
//  "retmsg": "ok",
//  "selected": "1",
//  "classes": [
//      {
//          "id": "2",
//          "name": "电视剧"
//      }
//http://psi.funshion.com/v5/site/list?class_id=2&pg=1&sz=40&cl=mweb&uc=30
//
//{
//  "retcode": "200",
//  "retmsg": "ok",
//  "total": "25",
//  "ts": "1457085411",

public class VideoNumber {
	private static Logger logger = LoggerFactory.getLogger(VideoNumber.class);
	
	@Test
	public void testVideoNumberclasslist(){
		Reporter.log("VideoNumber : classlist > 0");
		 logger.info("VideoNumber : classlist > 0");
		
		String url=GuessYouLikeAndVideoNumberUrl.VideoNumberPSIurl1;
	    String reponseFieldsName="classes";
	    // 验证 blocks 数组的大小 >0
		boolean total= HttpAssert.responseAssertArray(url, reponseFieldsName);
		 Assert.assertTrue(total, "blocks size > 0");

	}
	@Test(dependsOnMethods = { "testVideoNumberclasslist" })  
	public void testVideoNumberlist(){
		Reporter.log("VideoNumber : list > 0");
		 logger.info("VideoNumber : list > 0");
		
		String url=GuessYouLikeAndVideoNumberUrl.VideoNumberPSIurl2;
	    // 验证 total >0
		boolean total= HttpAssert.responseAssert(url);
		 Assert.assertTrue(total, "total > 0");

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
