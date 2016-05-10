package com.zhou.posidonautotest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MplayUrl {

private static Logger logger = LoggerFactory.getLogger(MplayUrl.class);
// 导航
public static String NavigationUrl="http://po.funshion.com/v7/config/channel?cl=mweb&uc=30";
private static String NavigationBaseUrl="http://po.funshion.com/v6/config/channelhome?cl=mweb&uc=30";
//返回各频道的所有筛选条件
private static String filtersurl="http://pm.funshion.com/v5/media/filters?cl=mweb&uc=30";
private static String url="http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&pg=1&sz=42";
// 推荐
public static final String RecommentNavigation=NavigationBaseUrl+"&nav_id=1";

//【电影】http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=1&order=pl&cate=0&area=0&year=0&pg=1&sz=42
//【电影】-【动作】【内地】【2015】http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=1&order=pl&cate=14&area=11&year=2015&pg=1&sz=42
	public static final String FilmNavigation=NavigationBaseUrl+"&nav_id=3";
	public static final String FilmFilters= filtersurl +"&channel=1";
	public static final String FilmAll= url +"&channel=1&order=pl&cate=0&area=0&year=0";
	public static final String FilmDetail=url +"&channel=1&order=pl&cate=14&area=11&year=2015";
	
//	【电视剧】http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=2&order=pl&cate=0&area=0&year=0&pg=1&sz=42
//	【电视剧】-【古装】【内地】【2016】http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=2&order=pl&cate=19&area=11&year=2016&pg=1&sz=42
	public static final String TVSeriesNavigation=NavigationBaseUrl+"&nav_id=4";
	public static final String TVSeriesFilters= filtersurl +"&channel=2";
	public static final String TVSeriesAll= url +"&channel=2&order=pl&cate=0&area=0&year=0";
	public static final String TVSeriesDetail=url +"&channel=2&order=pl&cate=19&area=11&year=2016";
	
//	【动漫】http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=3&order=pl&cate=0&area=0&year=0&pg=1&sz=42
//	【动漫】-【热血】【内地】【2016】http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=3&order=pl&cate=50&area=11&year=2016&pg=1&sz=42
	public static final String AnimalComicsNavigation=NavigationBaseUrl+"&nav_id=5";
	public static final String AnimalComicsFilters= filtersurl +"&channel=3";
	public static final String AnimalComicsAll= url +"&channel=3&order=pl&cate=0&area=0&year=0";
	public static final String AnimalComicsDetail=url +"&channel=3&order=pl&cate=50&area=11&year=2016";
	
//	【综艺】http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=4&order=pl&cate=0&area=0&year=0&pg=1&sz=42
//	【综艺】-【搞笑】【内地】【2015】http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=4&order=pl&cate=38&area=11&year=2015&pg=1&sz=42
	public static final String VarietyShowNavigation=NavigationBaseUrl+"&nav_id=6";
	public static final String VarietyShowFilters= filtersurl +"&channel=4";
	public static final String VarietyShowAll= url +"&channel=4&order=pl&cate=0&area=0&year=0";
	public static final String VarietyShowDetail=url +"&channel=4&order=pl&cate=38&area=11&year=2015";

//	【微电影】http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=5&order=pl&cate=0&area=0&year=0&pg=1&sz=42
//	【微电影】-【爱情】【国内】【2015】http://pm.funshion.com/v5/media/retrieval?cl=mweb&uc=30&channel=5&order=pl&cate=51&area=11&year=2015&pg=1&sz=42	
	public static final String MicrofilmNavigation=NavigationBaseUrl+"&nav_id=12";
	public static final String MicrofilmFilters= filtersurl +"&channel=5";
	public static final String MicrofilmAll= url +"&channel=5&order=pl&cate=0&area=0&year=0";
	public static final String MicrofilmDetail=url +"&channel=5&order=pl&cate=51&area=11&year=2015";


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
