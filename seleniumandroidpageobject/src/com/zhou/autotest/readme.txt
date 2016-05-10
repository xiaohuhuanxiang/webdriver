1. m1.fun.tv 点击链接跳过

使用id和 xpath出现： org.openqa.selenium.WebDriverException: unknown error: Element is not clickable at point (541, 90). 


解决： js
http://stackoverflow.com/questions/32628675/webdriverexception-unknown-error-element-is-not-clickable-at-point


	    WebElement element= driver.findElement(By.xpath("html/body/div[1]/div[2]/div/a"));

	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", element);
	    
	    
	    
	    ----------------
播放暂停： 完全使用  js来获取元素  播放  和 暂停

-------------------------
】 针对android 

	// 待   屏幕旋转   +  触摸和滚动 P 148 针对手机，如android
	
//	driver.get("http://m.fun.tv/");
//	((Rotatable)driver).rotate(ScreenOrientation.PORTRAIT);// 屏幕旋转
//	TouchActions touch = new TouchActions(driver);//触摸和滚动 
//	touch.scroll(200, 800).build().perform();


--------------

]日志  

---------------
]发邮件---相对路径？？？


读取html--》string ----》 发html的邮件


-------------------

]test-output/emailable-report.html 统计失败率---在emailable-report.html中直接加入




]  几个类串起来    ok

]不根据url 而是根据 用户的习惯 来找url

  1] 检查导航显示
 
  
  3】 点击播放，暂停
  
  】     滚动
  

 
  
------------------------------------

检索页可能因为编辑没有配置，造成app和 m站都没有结果
  
对结果的验证----有结果

】按不同条件检索时，  结果有数据

】 assert完毕， 打印出 按什么条件检索，方便定位问题

】 httpclient 发送请求  + 验证json串


