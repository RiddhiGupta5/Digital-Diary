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
		BasicDBObject doc6 = new BasicDBObject("useremailid", "shamg@gmail.com").
				append("time","9 am").
				append("date", "05-11-19").
				append("Location", "Delhi").
				append("Category","Event").
				append("Description","Sunburn");
		col.insert(doc6);
		BasicDBObject doc7 = new BasicDBObject("useremailid", "ramesha@gmail.com").
				append("time","9 am").
				append("date", "05-11-19").
				append("Location", "Bangalore").
				append("Category","Meeting").
				append("Description","Meeting with IEEE");
		col.insert(doc7);
		BasicDBObject doc8 = new BasicDBObject("useremailid", "sayanm@gmail.com").
				append("time","11 pm").
				append("date", "06-05-19").
				append("Location", "Kolkata").
				append("Category","Deadline").
				append("Description","Paper Submission Deadline");
		col.insert(doc8);
		
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

		
		//For table Contacts
		DBCollection col = db.getCollection("Contacts");
		BasicDBObject doc1 = new BasicDBObject("useremailid", "varunm@gmail.com").
				append("name","Laksh").
				append("phoneNO", "9876543211").
				append("date", "05-11-19").
				append("email","laskhg@gmail.com").
				append("address", "L block, Vellore Institute of Technology, Vellore");
		col.insert(doc1);
		BasicDBObject doc2 = new BasicDBObject("useremailid", "divyanshm@gmail.com").
				append("name","Varun").
				append("phoneNO", "1234567891").
				append("date", "25-01-19").
				append("email","varunm@gmail.com").
				append("address", "301 Brigade, Indiranagar, Bangalore");
		col.insert(doc2);
		BasicDBObject doc3 = new BasicDBObject("useremailid", "riddhig@gmail.com").
				append("name","Ritik").
				append("phoneNO","2131434231").
				append("date","06-10-18").
				append("email","ritikj@gmail.com").
				append("address","Prestige Shantiniketan, Whitefied, Bangalore");
		col.insert(doc3);
		BasicDBObject doc4 = new BasicDBObject("useremailid", "rithikj@gmail.com").
				append("name","Riddhi").
				append("phoneNO","9879879879").
				append("date", "08-04-19").
				append("email","riddhig@gmail.com").
				append("address","Mahadevpura, street#2, Hydrabad");
		col.insert(doc4);
		BasicDBObject doc5 = new BasicDBObject("useremailid", "ramg@gmail.com").
				append("name","Aryaman").
				append("phoneNO","9238472348").
				append("date", "22-08-19").
				append("email","aryamang@gmail.com").
				append("address", "Q block, Vellore Institute of Technology, Vellore");
		col.insert(doc5);
		BasicDBObject doc6 = new BasicDBObject("useremailid", "shamg@gmail.com").
				append("name","Abhishek").
				append("phoneNO","9248723982").
				append("date","28-12-18").
				append("email","abhisheks@gmail.com").
				append("address","Kartik Nagar, Second cross, Bangalore");
		col.insert(doc6);
		BasicDBObject doc7 = new BasicDBObject("useremailid", "ramesha@gmail.com").
				append("name","Steve").
				append("phoneNO","9876598765").
				append("date", "15-12-17").
				append("email","stevem@gmail.com").
				append("address","Wisconsin Madisson University,Wisconin");
		col.insert(doc7);
		BasicDBObject doc8 = new BasicDBObject("useremailid", "sayanm@gmail.com").
				append("name","Sukrit").
				append("phoneNO","8765432911").
				append("date", "01-04-19").
				append("email","sukritl@gmail.com").
				append("address","MG road, First cross, Kolkata");
		col.insert(doc8);
		
		//For table Keynotes
		DBCollection col = db.getCollection("Keynotes");
		BasicDBObject doc1 = new BasicDBObject("useremailid", "varunm@gmail.com").
				append("body", "I will take 27 credits this winter semester.");
		col.insert(doc1);
		BasicDBObject doc2 = new BasicDBObject("useremailid", "divyanshm@gmail.com").
				append("body", "Summer internship oppurtunities will open somewhere towards the end of the year.");
		col.insert(doc2);
		BasicDBObject doc3 = new BasicDBObject("useremailid", "riddhig@gmail.com").
				append("body", "Need to start saving up for the car.");
		col.insert(doc3);
		BasicDBObject doc4 = new BasicDBObject("useremailid", "rithikj@gmail.com").
				append("body", "Need to keep track of the upcoming Hackathons.");
		col.insert(doc4);
		BasicDBObject doc5 = new BasicDBObject("useremailid", "ramg@gmail.com").
				append("body", "Need to start saving up for a house.");
		col.insert(doc5);
		BasicDBObject doc6 = new BasicDBObject("useremailid", "shamg@gmail.com").
				append("body", "Need to purchase groceries for this month.");
		col.insert(doc6);
		BasicDBObject doc7 = new BasicDBObject("useremailid", "shamg@gmail.com").
				append("body", "Need to purchase groceries for this month.");
		col.insert(doc7);
	}


		
		
		
