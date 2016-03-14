package com.zhou.httpclientutil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HttpAssert {
	private static Logger logger = LoggerFactory.getLogger(HttpAssert.class);
	/*
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
public static boolean AssertChannelHome(String url){
	JSONObject jsonResult =	Httpclient.httpGet(url);
	JSONArray jSONArray =(JSONArray) jsonResult.get("blocks");
	int len=jSONArray.size();
	JSONObject  tmp= new JSONObject ();
	int i=0;
	for(;i<len;i++){
		tmp=(JSONObject )jSONArray.get(i);
		if(((JSONArray)(tmp.get("contents"))).size()>0)
			continue;
		else
			break;
	}
	
	if(len == i) return true;
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
	
	JSONArray ordersOptons=(JSONArray)orders.get("options");// ordersOptons.size()>0
	
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
	
	JSONArray ordersOptons=(JSONArray)orders.get("options");// ordersOptons.size()>0
	
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

	public static void main(String[] args) {
//		String url="http://po.funshion.com/v5/config/personal?fudid=145708511993611&cl=mweb&uc=30";
// String reponseFieldsName ="blocks";
//System.out.println(responseAssertArray(url,reponseFieldsName));
		String url="http://pm.funshion.com/v5/media/filters?channel=2&cl=mweb&uc=30";
		System.out.println(AssertFilters(url));
	}

}
