package com.zhou.mail;

import com.zhou.htmlutil.HtmlToString;

public class SendMail {
	//String path=this.getClass().getClassLoader().getResource("").getPath();///C:/Users/zhoupp/workspace/seleniumandroid/bin/

//	public static String szFileName="";
//	public static String path="emailable-report2.html";
	public void sendMail(){
		
		 MailInfo mailInfo = new MailInfo();  
	        mailInfo.setMailServerHost("smtp.126.com");  
	        mailInfo.setMailServerPort("25");  
	        mailInfo.setValidate(true);  
	        mailInfo.setUsername("zpphnkjxy@126.com");  
	        mailInfo.setPassword("ZPPzpp123");// 您的邮箱密码  
	        mailInfo.setFromAddress("zpphnkjxy@126.com");  
	        mailInfo.setToAddress("819669450@qq.com");  //zhoupp@fun.tv
	        mailInfo.setSubject("autotest reporter");  
	        //String szFileName ="C:/Users/zhoupp/workspace/seleniumandroidpageobject/test-output/emailable-report2.html";        
	        String szFileName = "test-output/emailable-report2.html";//相对路径
	        
	        
	        //附件  
	        String[] attachFileNames={"test-output/emailable-report2.html"};  
	        mailInfo.setAttachFileNames(attachFileNames);  
	        mailInfo.setContent(HtmlToString.openFile(szFileName));  
	        SimpleMail.sendHtmlMail(mailInfo);// 发送html格式  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //将emailable-report2.html 邮件发出
		 SendMail sendMail =new SendMail();
		sendMail.sendMail();
	}

}
