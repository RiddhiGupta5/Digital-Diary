package info.digital_diary.converters;

import org.bson.types.ObjectId;

import info.digital_diary.models.*;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
public class ScheduleConverter{
	     
	public static DBObject toDBObject(Schedules s) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
		 .append("userEmail",s.getuseremailid())
		 .append("date",s.getDate())
		 .append("activity",s.getActivity())
		 .append("time",s.gettime())
		 .append("location", s.getLocation());
		return builder.get();
	}
	public static Schedules toSchedule (DBObject doc) {
		Schedules s=new Schedules();
		s.setuseremailid((String) doc.get("userEmail"));
		s.setDate((String) doc.get("date"));
		s.setActivity((String) doc.get("activity"));
		s.settime((String) doc.get("time"));
		s.setLocation((String) doc.get("location"));
		return s;
	}	
}
