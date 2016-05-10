package com.zhou.posidonautotest;

public class VideoLibraryUrl {
// 影视库
	public static final String VideoLibraryurl="http://po.funshion.com/v6/config/channelhome?nav_id=40&cl=mweb&uc=30";
	
	
	
	//返回影视库的所有筛选条件
	private static String filtersurl="http://pam.funshion.com/v5/aggregate/filters?cl=mweb&uc=30";
	public static final String baseurl="http://pam.funshion.com/v5/aggregate/retrieval?cl=mweb&uc=30&cate=0&area=0&year=0&pg=1&sz=42";
	
//电影
	public static final String filmurl=baseurl+"&channel=2001";	
	public static final String filmFilters=filtersurl+"&channel=2001";	
	
//电视剧
	public static final String TVseriesurl=baseurl+"&channel=2002";	
	public static final String TVseriesFilters=filtersurl+"&channel=2002";	
//综艺
	public static final String varietyshowurl=baseurl+"&channel=2004";
	public static final String varietyshowFilters=filtersurl+"&channel=2004";	
//动漫
	public static final String AnimalComicsurl=baseurl+"&channel=2003";	
	public static final String AnimalComicsFilters=filtersurl+"&channel=2003";
	//导航
		private static String NavigationBaseUrl="http://po.funshion.com/v6/config/channelhome?cl=mweb&uc=30";
		
		public static final String VideoLibraryNavigation=NavigationBaseUrl+"&nav_id=40";

		
		
}


	
	
/*
 * 
 【影视库】http://po.funshion.com/v6/config/channelhome?nav_id=40&cl=mweb&uc=30
{
    "retcode": "200",
    "retmsg": "ok",
    "blocks": [
        {
            "id": "5",

【电影】

http://pam.funshion.com/v5/aggregate/retrieval?cl=mweb&uc=30&channel=2001&cate=0&area=0&year=0&pg=1&sz=42

{
    "retcode": "200",
    "retmsg": "ok",
    "total": "2000",
    "medias": [
        {
            "id": "47089",

【电视剧】
http://pam.funshion.com/v5/aggregate/retrieval?cl=mweb&uc=30&channel=2002&cate=0&area=0&year=0&pg=1&sz=42

{
    "retcode": "200",
    "retmsg": "ok",
    "total": "2000",
    "medias": [
        {
            "id": "82944",


【动漫】
http://pam.funshion.com/v5/aggregate/retrieval?cl=mweb&uc=30&channel=2003&cate=0&area=0&year=0&pg=1&sz=42

【综艺】
http://pam.funshion.com/v5/aggregate/retrieval?cl=mweb&uc=30&channel=2004&cate=0&area=0&year=0&pg=1&sz=42
 */
