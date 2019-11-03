package com.sm.mongo;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class JavaMongoConnection {
	
	public static void main(String args[])
	{
		//Connection with server
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("digital diary");
		System.out.println("Server Connection Successfully done");
		//Create collection
		DBCollection col = db.getCollection("Reminder");
		//System.out.println("Collection created successfully");
		//Inserting Documents into Reminder
		BasicDBObject doc1 = new BasicDBObject("useremailid", "varunm@gmail.com").
				append("time","9 am").
				append("date", "05-11-19").
				append("Location", "Bangalore").
				append("Category","Meeting").
				append("Description","Meeting with IEEE");
		col.insert(doc1);
		//System.out.println("Document Inserted");
		BasicDBObject doc2 = new BasicDBObject("useremailid", "divyanshm@gmail.com").
				append("time","8 am").
				append("date", "06-02-19").
				append("Location", "Kota").
				append("Category","Meeting").
				append("Description","Meeting with developers circle");
		col.insert(doc2);
		BasicDBObject doc3 = new BasicDBObject("useremailid", "riddhig@gmail.com").
				append("time","10 am").
				append("date", "07-11-19").
				append("Location", "Surat").
				append("Category","Meeting").
				append("Description","Meeting with DSC");
		col.insert(doc3);
		BasicDBObject doc4 = new BasicDBObject("useremailid", "rithikj@gmail.com").
				append("time","11 am").
				append("date", "12-09-19").
				append("Location", "Bangalore").
				append("Category","Deadline").
				append("Description","Digital Assignment deadline");
		col.insert(doc4);
		BasicDBObject doc5 = new BasicDBObject("useremailid", "ramg@gmail.com").
				append("time","2 pm").
				append("date", "25-01-19").
				append("Location", "Delhi").
				append("Category","Event").
				append("Description","Sunburn");
		col.insert(doc5);
		BasicDBObject doc1 = new BasicDBObject("useremailid", "shamg@gmail.com").
				append("time","9 am").
				append("date", "05-11-19").
				append("Location", "Delhi").
				append("Category","Event").
				append("Description","Sunburn");
		col.insert(doc6);
		BasicDBObject doc6 = new BasicDBObject("useremailid", "ramesha@gmail.com").
				append("time","9 am").
				append("date", "05-11-19").
				append("Location", "Bangalore").
				append("Category","Meeting").
				append("Description","Meeting with IEEE");
		col.insert(doc7);
		BasicDBObject doc1 = new BasicDBObject("useremailid", "sayanm@gmail.com").
				append("time","11 pm").
				append("date", "06-05-19").
				append("Location", "Kolkata").
				append("Category","Deadline").
				append("Description","Paper Submission Deadline");
		col.insert(doc7);
		
		//next table - Schedule
		DBCollection col = db.getCollection("Schedule");
		BasicDBObject doc1 = new BasicDBObject("useremailid", "varunm@gmail.com").
				append("time","9 am").
				append("date", "05-11-19").
				append("Location", "Bangalore").
				append("Activity","Meeting");
		col.insert(doc1);
		BasicDBObject doc2 = new BasicDBObject("useremailid", "divyanshm@gmail.com").
				append("time","8 am").
				append("date", "06-02-19").
				append("Location", "Kota").
				append("Activity","Study");
		col.insert(doc2);
		BasicDBObject doc3 = new BasicDBObject("useremailid", "riddhig@gmail.com").
				append("time","10 am").
				append("date", "07-11-19").
				append("Location", "Surat").
				append("Activity","Assignment");
		col.insert(doc3);
		BasicDBObject doc4 = new BasicDBObject("useremailid", "rithikj@gmail.com").
				append("time","11 am").
				append("date", "12-09-19").
				append("Location", "Bangalore").
				append("Activity","Paper Submission");
		col.insert(doc4);
		BasicDBObject doc5 = new BasicDBObject("useremailid", "ramg@gmail.com").
				append("time","2 pm").
				append("date", "24-01-19").
				append("Location", "Delhi").
				append("Activity","Jog");
		col.insert(doc5);
		BasicDBObject doc6 = new BasicDBObject("useremailid", "shamg@gmail.com").
				append("time","9 am").
				append("date", "25-11-19").
				append("Location", "Delhi").
				append("Activity","Study");
		col.insert(doc6);
		BasicDBObject doc7 = new BasicDBObject("useremailid", "ramesha@gmail.com").
				append("time","9 am").
				append("date", "11-11-19").
				append("Location", "Bangalore").
				append("Activity","Breakfast");
		col.insert(doc7);
		BasicDBObject doc8 = new BasicDBObject("useremailid", "sayanm@gmail.com").
				append("time","11 pm").
				append("date", "07-05-19").
				append("Location", "Kolkata").
				append("Activity","Sleep");
		col.insert(doc8);
		BasicDBObject doc9 = new BasicDBObject("useremailid", "anirudha@gmail.com").
				append("time","1 pm").
				append("date", "11-05-19").
				append("Location", "Vellore").
				append("Activity","Lunch");
		col.insert(doc9);
		
		//next table - Review
		DBCollection col = db.getCollection("Review");
		BasicDBObject doc1 = new BasicDBObject("useremailid", "varunm@gmail.com").
				append("emotion","Happy").
				append("date", "05-11-19").
				append("body","Had a productive day today.");
		col.insert(doc1);
		BasicDBObject doc2 = new BasicDBObject("useremailid", "divyanshm@gmail.com").
				append("emotion","Neutral").
				append("date", "06-02-19").
				append("body","Tiring day today.Should get some rest.");
		col.insert(doc2);
		BasicDBObject doc3 = new BasicDBObject("useremailid", "riddhig@gmail.com").
				append("emotion","Sad").
				append("date", "07-11-19").
				append("body","Didn't do very well on test.Should reflect on mistake in preperation.");
		col.insert(doc3);
		BasicDBObject doc4 = new BasicDBObject("useremailid", "rithikj@gmail.com").
				append("emotion","Neutral").
				append("date", "12-09-19").
				append("body","Travelling back to college was tiring.Should get some rest.");
		col.insert(doc4);
		BasicDBObject doc5 = new BasicDBObject("useremailid", "ramg@gmail.com").
				append("emotion","Happy").
				append("date", "24-01-19").
				append("body","Passed test with flying colors.Will enjoy now.");
		col.insert(doc5);
		BasicDBObject doc6 = new BasicDBObject("useremailid", "shamg@gmail.com").
				append("emotion","Sad").
				append("date", "25-11-19").
				append("body","Didn't get the promotion I deserved.Will work harder.");
		col.insert(doc6);
		BasicDBObject doc7 = new BasicDBObject("useremailid", "ramesha@gmail.com").
				append("emotion","Happy").
				append("date", "11-11-19").
				append("body","Come home for vacation.");
		col.insert(doc7);
		BasicDBObject doc8 = new BasicDBObject("useremailid", "sayanm@gmail.com").
				append("emotion","Happy").
				append("date", "07-05-19").
				append("body","Won the football tournamnet.Super Stoked");
		col.insert(doc8);

	}


		
		
		
