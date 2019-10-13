package info.digital_diary.converters;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import info.digital_diary.models.*;

public class KeynotesConverter {
	
	// convert User Object to MongoDB DBObject
		// take special note of converting id String to ObjectId
		public static DBObject toDBObject(Keynotes k) {

			BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
					.append("userEmail", k.getUserEmail())
					.append("note", k.getNote());
			return builder.get();
		}

		// convert DBObject Object to User
		// take special note of converting ObjectId to String
		public static Keynotes toUser(DBObject doc) {
			Keynotes k = new Keynotes();
			k.setUserEmail((String) doc.get("userEmail"));
			k.setNote((String) doc.get("note"));
			return k;

		}

}
