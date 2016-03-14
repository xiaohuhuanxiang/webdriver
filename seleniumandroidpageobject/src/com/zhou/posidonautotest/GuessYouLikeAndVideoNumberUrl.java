package com.zhou.posidonautotest;

public class GuessYouLikeAndVideoNumberUrl {
// 视频号 
	public static final String VideoNumberPSIurl1="http://psi.funshion.com/v5/site/classlist?cl=mweb&uc=30";
	public static final String VideoNumberPSIurl2="http://psi.funshion.com/v5/site/list?class_id=2&pg=1&sz=40&cl=mweb&uc=30";
	
	
//猜你喜欢
	public static final String GuessYouLikePOurl= "http://po.funshion.com/v5/config/personal?fudid=145708511993611&cl=mweb&uc=30";
//导航
	private static String NavigationBaseUrl="http://po.funshion.com/v6/config/channelhome?cl=mweb&uc=30";
//视频号导航
	public static final String  VideoNumberNavigation=NavigationBaseUrl+"&nav_id=45";
	//猜你喜欢导航
	public static final String  GuessYouLikeNavigation=NavigationBaseUrl+"&nav_id=14";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//视频好
//
//http://psi.funshion.com/v5/site/classlist?cl=mweb&uc=30
//
//{
//    "retcode": "200",
//    "retmsg": "ok",
//    "selected": "1",
//    "classes": [
//        {
//            "id": "2",
//            "name": "电视剧"
//        }
//http://psi.funshion.com/v5/site/list?class_id=2&pg=1&sz=40&cl=mweb&uc=30
//
//{
//    "retcode": "200",
//    "retmsg": "ok",
//    "total": "25",
//    "ts": "1457085411",
//
//
//
//
//猜你喜欢：http://po.funshion.com/v5/config/personal?fudid=145708511993611&cl=mweb&uc=30
//{
//    "retcode": "200",
//    "retmsg": "ok",
//    "blocks": [
//        {
//            "id": "",
//            "code": "",
//            "name": "亲子动漫",
//            "channel": {