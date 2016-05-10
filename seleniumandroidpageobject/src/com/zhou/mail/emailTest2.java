package com.zhou.mail;

import com.zhou.htmlutil.HtmlToString;

public class emailTest2 {

	public static void main(String[] args) {
		
//				emailHost=smtp.126.com
//				emailFrom=zpphnkjxy@126.com
//				emailUserName=zpphnkjxy
//				emailPassword = 890526
//
//				subject = "recover interface"
//				toEmails = 819669450@qq.com
//
//				mail.smtp.auth=true
//				mail.smtp.timeout=25000
		
		 MailInfo mailInfo = new MailInfo();  
	        mailInfo.setMailServerHost("smtp.126.com");  
	        mailInfo.setMailServerPort("25");  
	        mailInfo.setValidate(true);  
	        mailInfo.setUsername("zpphnkjxy@126.com");  
	        mailInfo.setPassword("ZPPzpp123");// 您的邮箱密码  
	        mailInfo.setFromAddress("zpphnkjxy@126.com");  
	        mailInfo.setToAddress("819669450@qq.com");  
	        mailInfo.setSubject("html test");  
	        String szFileName ="。。/test-output/emailable-report2.html";        
	        //附件  
	        String[] attachFileNames={"C:/Users/zhoupp/workspace/seleniumandroid/test-output/emailable-report2.html"};  
	        mailInfo.setAttachFileNames(attachFileNames);  
	          
	        // 这个类主要来发送邮件  
	        //mailInfo.setContent("设置邮箱内容");  
	        //SimpleMail.sendTextMail(mailInfo);// 发送文体格式  
//	        StringBuffer demo = new StringBuffer();  
//	        demo.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")  
//	        .append("<html>")  
//	        .append("<head>")  
//	        .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")  
//	        .append("<title>测试邮件</title>")  
//	        .append("<style type=\"text/css\">")  
//	        .append(".test{font-family:\"Microsoft Yahei\";font-size: 18px;color: red;}")  
//	        .append("</style>")  
//	        .append("</head>")  
//	        .append("<body>")  
//	        .append("<span class=\"test\">大家好，这里是测试Demo</span>")  
//	        .append("</body>")  
//	        .append("</html>");  
	        
	        
	        mailInfo.setContent(HtmlToString.openFile(szFileName));  
	        SimpleMail.sendHtmlMail(mailInfo);// 发送html格式  
	    }  
	}


