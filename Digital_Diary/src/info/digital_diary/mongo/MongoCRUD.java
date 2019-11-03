package info.digital_diary.mongo;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.Cursor;
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
	
	public boolean insertSchedule(Schedules s)
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital_diary");
		DBCollection col = db.getCollection("Schedules");
		
		DBObject doc = ScheduleConverter.toDBObject(s);
		
		try {
	        col.insert(doc);
	        return true;
	    } catch (MongoWriteException e) {
	    	return false;
	    }
	}
	
	public boolean insertReview(Reviews r)
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital_diary");
		DBCollection col = db.getCollection("Reviews");
		
		DBObject doc = ReviewConverter.toDBObject(r);
		
		try {
	        col.insert(doc);
	        return true;
	    } catch (MongoWriteException e) {
	    	return false;
	    }
	}
	
	public boolean insertReminder(Reminders r)
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital_diary");
		DBCollection col = db.getCollection("Reminders");
		
		DBObject doc = ReminderConverter.toDBObject(r);
		
		try {
	        col.insert(doc);
	        return true;
	    } catch (MongoWriteException e) {
	    	return false;
	    }
	}
	
	public DBCursor viewKeynotes(String userEmail)
	{
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital_diary");
		DBCollection col = db.getCollection("Keynotes");
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("userEmail", userEmail);
	  
	    DBCursor cursor = col.find(whereQuery);
		return cursor;		
	}
	
	public DBCursor viewReminders(String userEmail)
	{
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital_diary");
		DBCollection col = db.getCollection("Reminders");
		
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("userEmail", userEmail);
	  
	    DBCursor cursor = col.find(whereQuery);
		return cursor;		
	}
	
	public ArrayList<String> viewParameterWithDate(String userEmail, String date, String title)
	{
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital_diary");
		DBCollection col = db.getCollection(title);
		
		ArrayList<String> res = new ArrayList<String>();
		
		List<BasicDBObject> findObj = new ArrayList<BasicDBObject>();
		findObj.add(new BasicDBObject("userEmail", userEmail));
		findObj.add(new BasicDBObject("date", date));
		
		BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("$and", findObj);
	  
	    DBCursor cursor = col.find(whereQuery);
	    
	    String temp = null;
		
	    while (cursor.hasNext()) {
			BasicDBObject obj = (BasicDBObject) cursor.next();
			if (title.equals("Contacts")) {
				temp = "Name: " + obj.getString("name") 
				+ "<br>Phone No: " + obj.getString("phoneNo") 
				+ "<br>Address: " + obj.getString("address")
				+ "<br>Email: " + obj.getString("email");
			}
			else if(title.equals("Schedules")) {
				temp = "Activity: " + obj.getString("activity") 
				+ "<br>Locaion: " + obj.getString("location")
				+ "<br>Time: " + obj.getString("time"); 
			}
			else if(title.equals("Reviews")) {
				temp = "Emotion: " + obj.getString("emotion") 
				+ "<br>Description: " + obj.getString("body"); 
			}
			res.add(temp);
		}
	    
		return res;
		
	}

}
