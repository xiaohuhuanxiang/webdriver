package com.zhou.httpclientutil;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HttpAssert {
	private static Logger logger = LoggerFactory.getLogger(HttpAssert.class);
	/*http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=8&order=pl&cate=0&area=0&year=0&pg=1&sz=42
	 {
    "retcode": "200",
    "retmsg": "ok",
    "total": "1015",
    "medias": [
        {
            "id": "115117",
	 
	 
	 */
	public static boolean responseAssert(String url){
		
		JSONObject jsonResult =	Httpclient.httpGet(url);
		logger.debug("assert total > 0");
		String str =jsonResult.get("total").toString();
		
		return Integer.valueOf(str).intValue()>0?true:false;
	}
	/*
	//{
//    "retcode": "200",
//    "retmsg": "ok",
//    "blocks": [
//        {
//            "id": "",
//            "code": "",
//            "name": "亲子动漫",
//            "channel": {
	 
	 */
	
public static boolean responseAssertArray(String url,String reponseFieldsName){
		
		JSONObject jsonResult =	Httpclient.httpGet(url);
		logger.debug("assert ArrayField size > 0");
		JSONArray jSONArray =(JSONArray) jsonResult.get(reponseFieldsName);
		//System.out.println(jSONArray.size());//16
		return jSONArray.size()>0?true:false;
	}



//http://po.funshion.com/v6/config/channelhome?nav_id=1&cl=mweb&uc=30
//检查各个节点均不为空

/*
 * 
 问题：contents内容 可以最后面的部分为空，
 nav_id   取几个节点数
 
 3          4              电影
 
 4          4              电视剧
 
 5          7              动漫
 
 6                         综艺
 
 所以 规定前4个节点的contents内容的size()>0
 
 
 
 */
public static boolean AssertChannelHome(String url){
	JSONObject jsonResult =	Httpclient.httpGet(url);
	JSONArray jSONArray =(JSONArray) jsonResult.get("blocks");
	int len=jSONArray.size()-1;
	JSONObject  tmp= new JSONObject ();
	int i=0;
	int contentssize = 4;
	int minlen=len>contentssize?contentssize:len;
	
	for(;i<=minlen;i++){
		tmp=(JSONObject )jSONArray.get(i);
		if(((JSONArray)(tmp.get("contents"))).size()>0)
			continue;
		else
			break;
	}
	
	if(minlen < i) return true;
	return false;
}
//http://pm.funshion.com/v5/media/filters?channel=2&cl=mweb&uc=30
/*  orders --> options size()>0
 * 
 
 {
    "retcode": "200",
    "retmsg": "ok",
    "channel": "2",
    "orders": {
        "code": "order",
        "name": "排序",
        "selected": "pl",
        "options": [
            {
                "id": "pl",
                "name": "最热"
            },
            {
                "id": "mo",
                "name": "最新"
            },
            {
                "id": "sc",
                "name": "评分"
            }
        ]
    },
    "filters": [
        {
            "code": "cate",
            "name": "题材",
            "selected": "0",
            "options": [
                {
                    "id": "0",
                    "name": "全部"
                },
 */
public static boolean AssertFilters(String url){
	JSONObject jsonResult =	Httpclient.httpGet(url);
	JSONObject orders =(JSONObject)jsonResult.get("orders");
	
	JSONArray ordersOptons=(JSONArray)orders.get("options");// ordersOptons.size()>=2
	
	JSONArray filters=(JSONArray)jsonResult.get("filters");
	int len=filters.size();
	JSONObject  tmp= new JSONObject ();
	int i=0;
	for(;i<len;i++){
		tmp=(JSONObject )filters.get(i);
		if(((JSONArray)(tmp.get("options"))).size()>=2)
			continue;
		else
			break;
	}
	
	if((len == i) && ordersOptons.size()>=2 ) return true;
	return false;
}
//http://pam.funshion.com/v5/aggregate/filters?channel=2002&cl=mweb&uc=30
/*
 * 
 
 {
    "retcode": "200",
    "retmsg": "ok",
    "channel": {
        "code": "channel",
        "name": "频道",
        "selected": "2002",
        "options": [
            {
                "id": "2001",
                "name": "电影"
            },
            {
            
            
             "filters": [
        {
            "code": "cate",
            "name": "题材",
            "selected": "0",
            "options": [
                {
                    "id": "0",
                    "name": "全部"
                },
 */

public static boolean AssertVideoLibraryFilters(String url){
	JSONObject jsonResult =	Httpclient.httpGet(url);
	JSONObject orders =(JSONObject)jsonResult.get("channel");
	
	JSONArray ordersOptons=(JSONArray)orders.get("options");// ordersOptons.size()>=2
	
	JSONArray filters=(JSONArray)jsonResult.get("filters");
	int len=filters.size();
	JSONObject  tmp= new JSONObject ();
	int i=0;
	for(;i<len;i++){
		tmp=(JSONObject )filters.get(i);
		if(((JSONArray)(tmp.get("options"))).size()>=2)
			continue;
		else
			break;
	}
	
	if((len == i) && ordersOptons.size()>=2 ) return true;
	return false;
}

// 搜索全网媒体接口（媒体+聚合媒体）
//http://ps.funshion.com/v6/search/media?vip=1&q=%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%BB%9C&sz=30&cl=mweb&uc=30
// 全网搜索-站内有结果时

/*
 * 
 {
    "retcode": "200",
    "retmsg": "ok",
    "total": "6",
    "medias": [
        {
            "id": "200120",
            "template": "mplay",
            "name": "新娘大作战",
            
 */

//全网搜索-站内无结果时
/*
 
 {
    "retcode": "200",
    "retmsg": "ok",
    "total": "2",
    "medias": [
        {
            "id": "14170",
            "template": "aggregate",
            "name": "社交网络",
 */

//根据用户输入关键字搜索视频-即页面上的相关视频
//http://ps.funshion.com/v5/search/video?q=%E4%B8%89%E4%B8%AA%E5%A5%B6%E7%88%B8&sz=10&cl=mweb&uc=30
//{
//    "retcode": "200",
//    "retmsg": "ok",
//    "total": "27",
//    "videos": [
//        {
//            "id": "4111337",
//            "name": "【新娘大作战】特辑 首周颜值作战已高捷",
//            "poster": "",
//            "still": "http://img.funshion.com/sdw?oid=3846148fac5fba0a635855b38bb48076&w=0&h=0",
//            "release": "2015年

public static boolean AssertSearch(String url,String reponseFieldsName,String keywords){
	JSONObject jsonResult =	Httpclient.httpGet(url);
	JSONArray array =(JSONArray)jsonResult.get(reponseFieldsName);
	JSONObject firstItem= (JSONObject)array.get(0);
	String name=(String) firstItem.get("name");
	
	if(url.contains("/v6/search/media"))
		 return name.trim().equals(keywords);
	else
		return  name.trim().contains(keywords);
	
	
}

//为了出错时打印出对于的url及对于的判断规则，增加此函数
/*
 
 responseAssert   total>0

responseAssertArray blocks.size()>0

AssertChannelHome blocks.contents.size()>0


AssertFilters   orders.options.size()>=2  &&  filters.options.size()>=2


AssertVideoLibraryFilters orders.options.size()>=2  &&  filters.options.size()>=2

AssertSearch  videos[0].name.contains(keywords)+搜索结果不包含搜索词
 */

public static String getAssertRule(String method){
	Map<String,String> ruleMap= new LinkedHashMap<String,String>();
	ruleMap.put("responseAssert", "assert rule : total > 0");
	ruleMap.put("responseAssertArray", "assert rule : blocks.size() > 0");
	ruleMap.put("AssertChannelHome", "assert rule :blocks.contents.size() > 0");
	ruleMap.put("AssertFilters", "assert rule :orders.options.size()>=2  &&  filters.options.size()>=2");
	ruleMap.put("AssertVideoLibraryFilters", "assert rule : orders.options.size()>=2  &&  filters.options.size()>=2");
	ruleMap.put("AssertSearch", "videos[0].name.contains(keywords)");
	
	
	return ruleMap.get(method);
	
	
}
//从url中判断分类（电影，电视剧。。。）
public static String getCategories(String url){
	Map<Integer,String> channelhomeMap= new LinkedHashMap<Integer,String>(){  
        { 
        	//mplay
        put(1, "推荐");  
        put(3, "电影");  
        put(4, "电视剧");  
        put(5, "动漫");  
        put(6, "综艺");  
        put(12, "微电影");  
        
        // vplay
        put(15, "军事");  
        put(22, "科技");  
        put(25, "生活");  
        put(26, "英超");  
        put(28, "格斗");  
        put(24, "时尚");  
        put(23, "旅游");  
        put(21, "汽车");  
        put(18, "游戏");  
        put(17, "体育");  
        put(16, "广场舞");  
        put(10, "搞笑");  
        put(9, "新闻");  
        put(8, "娱乐"); 
        put(7, "热点"); 
        
        
        put(45, "视频号");  
        put(14, "猜你喜欢"); 
        put(40, "影视库"); 
        
        // vip
        
        put(50, "vip"); 
        }              
};  

Map<Integer,String> channelretrievalMap= new LinkedHashMap<Integer,String>(){  
	 {  
		 // mplay
	        put(1, "电影");  
	        put(2, "电视剧");  
	        put(3, "动漫");  
	        put(4, "综艺");  
	        put(5, "微电影");  
	        
	        //vplay
	        put(1026, "军事");  
	        put(1010, "科技");  
	        put(1029, "生活");  
	        put(1037, "英超");  
	        put(1038, "格斗");  
	        put(1008, "时尚");  
	        put(1007, "旅游");  
	        put(1005, "汽车");  
	        put(1011, "游戏");  
	        put(1002, "体育");  
	        put(1027, "广场舞");  
	        put(1004, "搞笑");  
	        put(1003, "新闻");  
	        put(1001, "娱乐"); 
	        put(1020, "热点"); 
	        
	        
	        // 视频库--全部都是来自 聚合的  长视频
	        put(2001, "电影-视频库");  
	        put(2002, "电视剧-视频库");  
	        put(2003, "动漫-视频库"); 
	        put(2004, "综艺-视频库"); 
	        
	        
	        // vip
	        put(8, "vip"); 
}
};
String categorie=null; //一个url中nav_id,channel不会同时有
	if(url.contains("nav_id")){//提取nav_id的值
		categorie=channelhomeMap.get(Integer.valueOf(getValueFromUrl(url,"nav_id")));
	
		
	}else if(url.contains("channel")){
		//提取channel的值
		categorie=channelretrievalMap.get(Integer.valueOf(getValueFromUrl(url,"channel")));
	}
	
	return categorie;
			
}
// 提取url中的字段值, 提取paramNameStr=后的值

public static String getValueFromUrl(String url,String paramNameStr){
	
	int questionmarksIndex= url.indexOf("?");
	
	String urlTmp=url.substring(questionmarksIndex+1);//排除?前的所有
	String[] params=urlTmp.split("&");
	
	for(String param:params){
		if(param.contains(paramNameStr)){
			//说明已找到
			return param.split("=")[1];
		}
	}
	return null;

}

	public static void main(String[] args) {
//		String url="http://po.funshion.com/v5/config/personal?fudid=145708511993611&cl=mweb&uc=30";
// String reponseFieldsName ="blocks";
//System.out.println(responseAssertArray(url,reponseFieldsName));
//		String url="http://pm.funshion.com/v5/media/filters?channel=2&cl=mweb&uc=30";
//		System.out.println(AssertFilters(url));
		
//		String url="http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&pg=1&sz=40&channel=1003&order=pi&cate=322&date=monthly";
//		System.out.println(url.contains("po.funshion.com/v6/config/channelhome"));
//		System.out.println(url.contains("po.funshion.com/v7/config/channel") || url.contains("pm.funshion.com/v5/media/retrieval")|| url.contains("pv.funshion.com/v5/video/filters"));
//		
//		System.out.println(getValueFromUrl(url,"channel"));
//		System.out.println(getCategories(url));
		
		String keywords="%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%BB%9C";//"社交网络";
		String keywords2="社交网络";

		String url="http://ps.funshion.com/v6/search/media?vip=1&q="+keywords+"&sz=30&cl=mweb&uc=30";

		boolean total= HttpAssert.AssertSearch(url, "medias", keywords2);
		System.out.println(total);
	}

}
