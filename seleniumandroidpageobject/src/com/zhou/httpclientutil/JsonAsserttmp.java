package com.zhou.httpclientutil;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class JsonAsserttmp {
	private static Logger logger = LoggerFactory.getLogger(JsonAsserttmp.class);
	
	private JSONObject jsonResult;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "JsonAssert [jsonResult=" + jsonResult + "]";
	}






	public JsonAsserttmp(JSONObject jsonResult) {
		super();
		this.jsonResult = jsonResult;
	}






	public JSONObject getJsonResult() {
		return jsonResult;
	}






	public void setJsonResult(JSONObject jsonResult) {
		this.jsonResult = jsonResult;
	}


//	public boolean hasValue(String name){
//		
//		
//		
//	}




	public static void main(String[] args) {
//		Integer a=1;
//		System.out.println(a instanceof Integer);//true
//		
//		JSONArray b=new JSONArray();
//		System.out.println(b instanceof JSONArray);//true
		
//		String str = "{'TI':[{'value':'aa1','count':10},{'value':'aa2','count':15},{'value':'aa3','count':20}]," +  
//                "'AB':[{'value':'ab','count':110},{'value':'ab2','count':115},{'value':'ab3','count':210}]}";  
		
		String str = "{'value':'aa3','count':20}";
		
		
		
        JSONArray newArray = new JSONArray();  
        JSONObject newJson = new JSONObject();  
        try {  
            JSONObject obj = new JSONObject(str);  
            
            
            
            Iterator it = obj.keys();  
            while (it.hasNext()) {  
                String key = (String) it.next();  //AB   TI
              
       
                String value = obj.getString(key);  //[{"count":110,"value":"ab"},{"count":115,"value":"ab2"},{"count":210,"value":"ab3"}]
                System.out.println(value);  
                //JSONObject["count"] is not a JSONArray.
//                JSONArray array = obj.getJSONArray(key); //[{"count":110,"value":"ab"},{"count":115,"value":"ab2"},{"count":210,"value":"ab3"}]
//               
//                
//                
//                for(int i=0;i<array.length();i++){  
//                    ////类型强转失败会异常 
//                    JSONObject jsonobject = array.getJSONObject(i);  
//                    jsonobject.put("name", key);  
//                    jsonobject.put("exp", key+"="+jsonobject.getString("value"));  
//                    newArray.put(jsonobject);  
//                }  
            }  
            /*
             * 
             
             {
    "groups": [
        {
            "count": 110,
            "name": "AB",
            "exp": "AB=ab",
            "value": "ab"
        },
        {
            "count": 115,
            "name": "AB",
            "exp": "AB=ab2",
            "value": "ab2"
        },
        {
            "count": 210,
            "name": "AB",
            "exp": "AB=ab3",
            "value": "ab3"
        },
        {
            "count": 10,
            "name": "TI",
            "exp": "TI=aa1",
            "value": "aa1"
        },
        {
            "count": 15,
            "name": "TI",
            "exp": "TI=aa2",
            "value": "aa2"
        },
        {
            "count": 20,
            "name": "TI",
            "exp": "TI=aa3",
            "value": "aa3"
        }
    ]
}
             */
            newJson.put("groups",newArray);  
            System.out.println(newJson);  
        } catch (JSONException e) {  
            e.printStackTrace();  
        }  
        

	}

}
