package info.digitaldiary.converters;

import org.bson.types.ObjectId;

import info.digitaldiary.models.*;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
public class Reminderconverter{
	
	public static DBObject toDBObject(Reminder r){
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("useremailid", r.getuseremailid())
				.append("time",r.gettime())
				.append("date",r.getdate())
				.append("Location",r.getlocation())
				.append("Category",r.getcategory())
				.append("Description",r.getdesc());
		return builder.get();
	}
	public static Reminder toUser (DBObject doc){
		Reminder r=new Reminder();
		s.setuseremailid((String) doc.get("useremailid"));
		s.setdate((String) doc.get("date"));
		s.settime((String) doc.get("time"));
		s.setlocation((String) doc.get("Location")); 
		s.setcategory((String) doc.get("Category")); 
		s.setdesc((String) doc.get("Description")); 

	}
}