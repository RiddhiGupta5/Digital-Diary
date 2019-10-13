package info.digital_diary.mongo;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoWriteException;
import com.mongodb.DBObject;

import info.digital_diary.converters.*;
import info.digital_diary.models.*;

public class MongoCRUD {
	
	public boolean insertUser(User u) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital_diary");
		DBCollection col = db.getCollection("Users");
	    
	    col.createIndex(new BasicDBObject().append("email",1),  "User_unique_email_constraint", true);
		DBObject doc = UserConverter.toDBObject(u);
		
		try {
	        col.insert(doc);
	        return true;
	    } catch (MongoWriteException e) {
	    	return false;
	    }
		
	}
	
	public boolean findUser(String name, String email, String password) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital_diary");
		DBCollection col = db.getCollection("Users");
		
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("email", email));
		obj.add(new BasicDBObject("password", password));
		obj.add(new BasicDBObject("name", name));
		
		BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("$and", obj);
		
		try {
			DBCursor cursor = col.find(whereQuery);
			if(cursor.count()==0)
			{
				return false;
			}
	        return true;
	    } catch (MongoWriteException e) {
	    	return false;
	    }
	}
	
	public boolean insertKeyNote(Keynotes k)
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital_diary");
		DBCollection col = db.getCollection("Keynotes");
		
		DBObject doc = KeynotesConverter.toDBObject(k);
		
		try {
	        col.insert(doc);
	        return true;
	    } catch (MongoWriteException e) {
	    	return false;
	    }
	}
	
	public boolean insertContact(Contacts c)
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital_diary");
		DBCollection col = db.getCollection("Contacts");
		
		DBObject doc = ContactsConverter.toDBObject(c);
		
		try {
	        col.insert(doc);
	        return true;
	    } catch (MongoWriteException e) {
	    	return false;
	    }
	}

}
