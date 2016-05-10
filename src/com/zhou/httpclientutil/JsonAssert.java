package com.zhou.httpclientutil;

import java.util.Iterator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class JsonAssert {
	private static Logger logger = LoggerFactory.getLogger(JsonAssert.class);
	
//	private static JSONObject json;
	
	
	
	
	
	
	

//	public boolean hasValue(String name){
//		
//		
//		
//	}

	//http://blog.csdn.net/wangqianjiao/article/details/8669137
    public static void decodeJSONObject(JSONObject json){  
        Iterator<String> keys=json.keys();  
        JSONObject jo=null;  
        JSONArray ja = null;
        Object o;  
        String key;  
        while(keys.hasNext()){  
            key=keys.next();  

            o=json.get(key);  
            if(o instanceof JSONObject){  
                jo=(JSONObject)o;  
                if(jo.keySet().size()>0){  
                    decodeJSONObject(jo);  
                }else{  
                    System.out.println(key);  
                }  
            }
            else if(o instanceof JSONArray){
            	ja = (JSONArray)o;
            	for(int i=0;i<ja.size();i++){
            	decodeJSONObject(ja.getJSONObject(i));
            	}
            }
            else{  
                System.out.println(o);  
            }  
        }  
    }
    
    
    
    // httpclient 只保证在 array [] 内的 有序，所以 结果只对[] 内的排序有效
    
    public static boolean asc(JSONObject json,String param){
    	
    	 int lastmin=java.lang.Integer.MIN_VALUE;
    	 if(null == getValue(json,param)){//不含param时
    		 return false;
    	 }
    	 return ascutil(json,param,lastmin);
    	
    }
    
    public static boolean ascutil(JSONObject json,String param,int lastmin){
    	
    	int tmpint=lastmin;
    	Iterator<String> keys=json.keys();  
        JSONObject jo=null;  
        JSONArray ja = null;
        Object o;  
        String key;  
        
//        int lastmin=java.lang.Integer.MIN_VALUE;
        boolean result = true;
        
        while(keys.hasNext()){  
            key=keys.next();  

            o=json.get(key);  
            
            if (param.equals(key) && !(o instanceof JSONArray)&& !(o instanceof JSONObject) ){// 找到后直接返回  
            
            	if(tmpint <= Integer.parseInt(o.toString())){
            		
            		tmpint = Integer.parseInt(o.toString());
            	}
            	else {
            		
            		result = false;
            		break;
            	}
            	
            }  
            else if (o instanceof JSONObject){  
                jo=(JSONObject)o;  
                if(jo.keySet().size()>0){  
                	result=ascutil(jo,param,tmpint);  
                	if( !result )
                		break;
                }else{  
//                    
                }  
            }
            else if(o instanceof JSONArray){
            	ja = (JSONArray)o;
            	for(int i=0;i<ja.size();i++){
            		result= ascutil(ja.getJSONObject(i),param,tmpint);
            		if( !result)
                		break;
            	}
            	if( !result)
            		break;
            }
            
        }  
    	
    	return result;
    	
    	
    }
    
    
    // 对array统计size， 不含有param 或者 param 非array，返回-1
    public static int  arrayHasSize(JSONObject json,String param){
    	
    	Iterator<String> keys=json.keys();  
        JSONObject jo=null;  
        JSONArray ja = null;
        Object o;  
        String key;  
        
        int size = -1;
        
        while(keys.hasNext()){  
            key=keys.next();  

            o=json.get(key);  
            
            if (param.equals(key) && o instanceof JSONArray){// 找到后直接返回  
              ja = (JSONArray)o;
            	size = ja.size();
            	break;
            }  
            else if (o instanceof JSONObject){  
                jo=(JSONObject)o;  
                if(jo.keySet().size()>0){  
                	size=arrayHasSize(jo,param);  
                	if( size !=-1)
                		break;
                }else{  
//                    
                }  
            }
            else if(o instanceof JSONArray){
            	ja = (JSONArray)o;
            	for(int i=0;i<ja.size();i++){
            		size= arrayHasSize(ja.getJSONObject(i),param);
            		if( size !=-1)
                		break;
            	}
            	if( size !=-1)
            		break;
            }
            
        }  
    	
    	return size;
    	
    }
    
    // 必须含有param， 并且 值为“”
    public static boolean valueIsNull(JSONObject json,String param){
    	
    	return getValue(json,param).equals("");
    	
    }
    
    // null param不存在，否则 找到就返回
    public static String getValue(JSONObject json,String param){
    	
    	Iterator<String> keys=json.keys();  
        JSONObject jo=null;  
        JSONArray ja = null;
        Object o;  
        String key;  
        
        String result=null;
        
        while(keys.hasNext()){  
            key=keys.next();  

            o=json.get(key);  
            
            if (param.equals(key)){// 找到后直接返回  
//                System.out.println(o);  
            	result = o.toString();
            	break;
            }  
            else if (o instanceof JSONObject){  
                jo=(JSONObject)o;  
                if(jo.keySet().size()>0){  
                	result=getValue(jo,param);  
                	if( result !=null)
                		break;
                }else{  
//                    
                }  
            }
            else if(o instanceof JSONArray){
            	ja = (JSONArray)o;
            	for(int i=0;i<ja.size();i++){
            		result= getValue(ja.getJSONObject(i),param);
            		if( result !=null)
                		break;
            	}
            	if( result !=null)
            		break;
            }
            
        }  
    	
    	return result;
    	
    	
    	
    }


	public static void main(String[] args) {

		String url="http://pm.funshion.com/v7/media/play/?id=624226&cl=mweb&uc=30";
		JSONObject jsonResult =	Httpclient.httpGet(url);
		System.out.println((jsonResult));  
		System.out.println(asc(jsonResult,"filesize"));  


	}

}
