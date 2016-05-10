package com.zhou.po;

/*
 *
 
 
 java中的switch用String作为条件
 
在开发java程序的过程中，我们遇到了条件判断首选就是switch，但是遗憾的是，

我们java中的switch功能不如C#中的强大，她不支持字符串作为条件。这时我们该怎么办呢？
 */
public enum Driver {

     chrome, firefox, ie, android,

	novalue;


	public static Driver toDriver(String str)

	{

	try {

	return valueOf(str);

	}

	catch (Exception ex) {

	return novalue;

	}

	}
}
