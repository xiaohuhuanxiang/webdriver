package com.zhou.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator{
	private String username;  
    private String password;  
  
  
    public MyAuthenticator(String username, String password) {  
        super();  
        this.username = username;  
        this.password = password;  
    }  
  
    protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication(username, password);  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
