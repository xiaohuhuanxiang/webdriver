package com.zhou.posidonautotest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class VplayUrl {
	private static Logger logger = LoggerFactory.getLogger(VplayUrl.class);
	private static String NavigationBaseUrl="http://po.funshion.com/v6/config/channelhome?cl=mweb&uc=30";
	
	//返回各频道的所有筛选条件
	private static String filtersurl="http://pv.funshion.com/v5/video/filters?cl=mweb&uc=30";
	private static String url="http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&pg=1&sz=40";


    //【军事】，按【全部】检索时：http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1026&order=pi&cate=0&pg=1&sz=40 
	//【军事】，按【军情】检索时：http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1026&order=pi&cate=193&pg=1&sz=40
	public static final String  militaryNavigation=NavigationBaseUrl+"&nav_id=15";
	public static final String militaryFilters= filtersurl +"&channel=1026";
	public static final String militaryAll= url +"&channel=1026&order=pi&cate=0";
	public static final String militarySituation=url +"&channel=1026&order=pi&cate=193";
	
//	【科技】-【全部】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1010&order=pi&cate=0&pg=1&sz=40 
//	【科技】-【最新】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1010&order=mo&cate=0&pg=1&sz=40
	public static final String  scienceNavigation=NavigationBaseUrl+"&nav_id=22";
	public static final String scienceFilters= filtersurl +"&channel=1010";
	public static final String scienceAll= url +"&channel=1010&order=pi&cate=0";
	public static final String scienceLatest=url +"&channel=1010&order=mo&cate=0";
	
//	【生活】-【全部】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1029&order=mo&cate=0&pg=1&sz=40
//	【生活】-【美食】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1029&order=mo&cate=51&pg=1&sz=40
	public static final String  lifeNavigation=NavigationBaseUrl+"&nav_id=25";
	public static final String lifeFilters= filtersurl +"&channel=1029";
	public static final String lifeAll= url +"&channel=1029&order=mo&cate=0";
	public static final String lifeFood=url +"&channel=1029&order=mo&cate=51";
	
//	【英超】-【全部】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1037&order=mo&cate=200&pg=1&sz=40
//	【英超】-【曼联】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1037&order=mo&cate=980&pg=1&sz=40
	public static final String  EPLNavigation=NavigationBaseUrl+"&nav_id=26";
	public static final String EPLFilters= filtersurl +"&channel=1037";
	public static final String EPLAll= url +"&channel=1037&order=mo&cate=200";
	public static final String EPLManchester=url +"&channel=1037&order=mo&cate=980";
	
	
//	【格斗】-【全部】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1038&order=mo&cate=198&pg=1&sz=40
//	【格斗】-【拳击】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1038&order=mo&cate=237&pg=1&sz=40
	public static final String  fightingNavigation=NavigationBaseUrl+"&nav_id=28";
	public static final String fightingFilters= filtersurl +"&channel=1038";
	public static final String fightingAll= url +"&channel=1038&order=mo&cate=198";
	public static final String fightingBoxing=url +"&channel=1038&order=mo&cate=237";

//	【时尚】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1008&order=mo&cate=0&pg=1&sz=40
//	【时尚】-【明星风范】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1008&order=mo&cate=80&pg=1&sz=40
	public static final String  fashionNavigation=NavigationBaseUrl+"&nav_id=24";
	public static final String fashionFilters= filtersurl +"&channel=1008";
	public static final String fashionAll= url +"&channel=1008&order=mo&cate=0";
	public static final String fashionStarStyle=url +"&channel=1008&order=mo&cate=80";
	
	//【旅游】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1007&order=pi&cate=0&pg=1&sz=40
//		【旅游】-【环球八卦】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1007&order=pi&cate=91&pg=1&sz=40
	public static final String tourismNavigation=NavigationBaseUrl+"&nav_id=23";
	public static final String tourismFilters= filtersurl +"&channel=1007";
	public static final String tourismAll= url +"&channel=1007&order=pi&cate=0";
	public static final String tourismGlobalGossip=url +"&channel=1007&order=pi&cate=91";
	
//	【汽车】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1005&order=mo&cate=0&pg=1&sz=40
//		【汽车】-【风FUN车闻】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1005&order=mo&cate=57&pg=1&sz=40
	public static final String carNavigation=NavigationBaseUrl+"&nav_id=21";
	public static final String carFilters= filtersurl +"&channel=1005";
	public static final String carAll= url +"&channel=1005&order=mo&cate=0";
	public static final String carFunNews=url +"&channel=1005&order=mo&cate=57";
	

//【游戏】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1011&order=pi&cate=0&pg=1&sz=40
//【游戏】-【游戏赛事】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1011&order=pi&cate=99&pg=1&sz=40
	public static final String gameNavigation=NavigationBaseUrl+"&nav_id=18";
	public static final String gameFilters= filtersurl +"&channel=1011";
	public static final String gameAll= url +"&channel=1011&order=pi&cate=0";
	public static final String gameCompetition=url +"&channel=1011&order=pi&cate=99";

//	【体育】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1002&order=pi&cate=0&pg=1&sz=40
//		【体育】-【篮球】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1002&order=pi&cate=33&pg=1&sz=40
	public static final String sportsNavigation=NavigationBaseUrl+"&nav_id=17";
	public static final String sportsFilters= filtersurl +"&channel=1002";
	public static final String sportsAll= url +"&channel=1002&order=pi&cate=0";
	public static final String sportsBasketball=url +"&channel=1002&order=pi&cate=33";
	
//	【广场舞】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1027&order=pl&cate=0&pg=1&sz=40
//		【广场舞】-【广场舞教学】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1027&order=pl&cate=137158&pg=1&sz=40
	public static final String  SquaredanceNavigation=NavigationBaseUrl+"&nav_id=16";
	public static final String SquaredanceFilters= filtersurl +"&channel=1027";
	public static final String SquaredanceAll= url +"&channel=1027&order=pl&cate=0";
	public static final String SquaredanceTeaching=url +"&channel=1027&order=pl&cate=137158";
	
//	【搞笑】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1004&order=pi&cate=0&pg=1&sz=40
//		【搞笑】-【宠物日常】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1004&order=pi&cate=233&pg=1&sz=40
	public static final String  FunnyNavigation=NavigationBaseUrl+"&nav_id=10";
	public static final String FunnyFilters= filtersurl +"&channel=1004";
	public static final String FunnyAll= url +"&channel=1004&order=pi&cate=0";
	public static final String FunnyPetDaily=url +"&channel=1004&order=pi&cate=233";
	
//	【新闻】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1003&order=pi&cate=0&date=monthly&pg=1&sz=40本月
//		【新闻】-【国内】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1003&order=pi&cate=322&date=monthly&pg=1&sz=40本月
	public static final String  NewsNavigation=NavigationBaseUrl+"&nav_id=9";
	public static final String NewsFilters= filtersurl +"&channel=1003";
	public static final String NewsAll= url +"&channel=1003&order=pi&cate=0&date=monthly";
	public static final String NewsDomestic=url +"&channel=1003&order=pi&cate=322&date=monthly";

//	【娱乐】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1001&order=pi&cate=0&pg=1&sz=40
//		【娱乐】-【头条】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1001&order=pi&cate=11&pg=1&sz=40
	public static final String EntertainmentNavigation=NavigationBaseUrl+"&nav_id=8";
	public static final String EntertainmentFilters= filtersurl +"&channel=1001";
	public static final String EntertainmentAll= url +"&channel=1001&order=pi&cate=0";
	public static final String EntertainmentHeadlines=url +"&channel=1001&order=pi&cate=11";	
	
//	【热点】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1020&order=pl&cate=0&date=weekly&pg=1&sz=40本周
//		【热点】-【本月】http://pv.funshion.com/v5/video/retrieval?cl=mweb&uc=30&channel=1020&order=pl&cate=0&date=monthly&pg=1&sz=40
	public static final String HotspotNavigation=NavigationBaseUrl+"&nav_id=7";
	public static final String HotspotFilters= filtersurl +"&channel=1020";
	public static final String HotspotAll= url +"&channel=1020&order=pl&cate=0&date=weekly";
	public static final String HotspotThisMonth=url +"&channel=1020&order=pl&cate=0&date=monthly";	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
