package info.digital_diary.converters;

import org.bson.types.ObjectId;

import info.digital_diary.models.*;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
public class ReminderConverter{
	
	public static DBObject toDBObject(Reminders r){
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("userEmail", r.getuseremailid())
				.append("time",r.gettime())
				.append("date",r.getdate())
				.append("location",r.getlocation())
				.append("category",r.getcategory())
				.append("description",r.getdesc());
		return builder.get();
	}
	public static Reminders toReminder (DBObject doc){
		Reminders r=new Reminders();
		r.setuseremailid((String) doc.get("userEmail"));
		r.setdate((String) doc.get("date"));
		r.settime((String) doc.get("time"));
		r.setlocation((String) doc.get("location")); 
		r.setcategory((String) doc.get("category")); 
		r.setdesc((String) doc.get("description"));
		return r; 

	}
}
