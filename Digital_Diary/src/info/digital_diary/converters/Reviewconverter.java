package info.digitaldiary.converters;

import org.bson.types.ObjectId;

import info.digitaldiary.models.*;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
public class Reviewconverter{
	public static DBObject toDBObject(Review t) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("useremailid", t.getuseremailid())
				.append("date",t.getdate())
				.append("emotion",t.getemotion())
				.append("body",t.getbody());
		return builder.get();
	}
	public static Review toUser (DBObject doc){
		Review t=new Review();
		t.setuseremailid((String) doc.get("useremailid"));
		t.setdate((String) doc.get("date"));
		t.setemotion((String) doc.get("emotion"));
		t.setbody((String) doc.get("body"));
		return t;
	}
}

	