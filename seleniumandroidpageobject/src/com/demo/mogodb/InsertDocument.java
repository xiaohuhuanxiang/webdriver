package com.demo.mogodb;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;


public class InsertDocument {

	public static void main(String[] args) {
//		通过JAVA代码向Mongodb插入以上格式的JSON数据:4种方法
//		使用BasicDBObject
//		使用BasicDBObjectBuilder对象
//		使用Map对象
//		直接插入JSON格式数据
		
Mongo mongo;
try {
	mongo = new Mongo("localhost", 27017);

DB db = mongo.getDB("yourdb");
// get a single collection
DBCollection collection = db.getCollection("dummyColl");
			
			// JSON parse example
String json ="{'database' : 'mkyongDB','table' : 'hosting',"+
"'detail' : {'records' : 99, 'index' : 'vps_index1', 'active' : 'true'}}}";
DBObject dbObject =(DBObject)JSON.parse(json);
collection.insert(dbObject);
DBCursor cursorDocJSON = collection.find();
while(cursorDocJSON.hasNext()){
System.out.println(cursorDocJSON.next());
}
collection.remove(new BasicDBObject());
} catch (UnknownHostException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		
	
	}

}
