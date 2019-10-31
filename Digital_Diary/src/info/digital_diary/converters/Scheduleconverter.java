package info.digitaldiary.converters;

import org.bson.types.ObjectId;

import info.digitaldiary.models.*;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
public class Scheduleconverter{
	     
	public static DBObject toDBObject(Schedule s) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
		 .append("useremailid",s.getuseremailid())
		 .append("date",s.getDate())
		 .append("Activity",s.getActivity())
		 .append("time",s.gettime());
		return builder.get();
	}
	public static Schedule toUser (DBObject doc) {
		Schedule s=new Schedule();
		s.setuseremailid((String) doc.get("useremailid"));
		s.setDate((String) doc.get("date"));
		s.setActivity((String) doc.get("Activity"));
		s.settime((String) doc.get("time"));
		return s;
	}
	
		
		
		
		
		
	
	
}