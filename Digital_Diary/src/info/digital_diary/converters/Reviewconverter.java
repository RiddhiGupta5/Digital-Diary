package info.digital_diary.converters;

import org.bson.types.ObjectId;

import info.digital_diary.models.*;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
public class ReviewConverter{
	public static DBObject toDBObject(Reviews t) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("userEmail", t.getuseremailid())
				.append("date",t.getDate())
				.append("emotion",t.getemotion())
				.append("body",t.getbody());
		return builder.get();
	}
	public static Reviews toReview (DBObject doc){
		Reviews t=new Reviews();
		t.setuseremailid((String) doc.get("userEmail"));
		t.setDate((String) doc.get("date"));
		t.setemotion((String) doc.get("emotion"));
		t.setbody((String) doc.get("body"));
		return t;
	}
}

	
