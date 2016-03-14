package com.zhou.posidonautotest.vplay;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.zhou.httpclientutil.HttpAssert;
import com.zhou.posidonautotest.GuessYouLikeAndVideoNumberUrl;
import com.zhou.posidonautotest.MplayUrl;
import com.zhou.posidonautotest.VplayUrl;

//猜你喜欢：http://po.funshion.com/v5/config/personal?fudid=145708511993611&cl=mweb&uc=30
//{
//  "retcode": "200",
//  "retmsg": "ok",
//  "blocks": [
//      {
//          "id": "",
//          "code": "",
//          "name": "亲子动漫",
//          "channel": {

public class GuessYouLike {
	private static Logger logger = LoggerFactory.getLogger(GuessYouLike.class);
	

	@Test
	public void testGuessYouLike(){
		Reporter.log("testGuessYouLike : blocks > 0");
		 logger.info("testGuessYouLike : blocks > 0");
		
		String url=GuessYouLikeAndVideoNumberUrl.GuessYouLikePOurl;
	    String reponseFieldsName="blocks";
	    // 验证 blocks 数组的大小 >0
		boolean total= HttpAssert.responseAssertArray(url, reponseFieldsName);
		 Assert.assertTrue(total, "blocks size > 0");

	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
