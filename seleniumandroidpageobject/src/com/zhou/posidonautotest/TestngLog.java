package com.zhou.posidonautotest;

import org.testng.Reporter;

import com.zhou.httpclientutil.HttpAssert;

public class TestngLog {//向 报告中打印assert错误的url 和判断规则
	
	public static void log(String url,String method){
		//打印分类 getCategories
		Reporter.log(HttpAssert.getCategories(url),true);//打印url
		Reporter.log(url,true);//打印url
		Reporter.log(HttpAssert.getAssertRule(method),true);//获取验证规则
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
