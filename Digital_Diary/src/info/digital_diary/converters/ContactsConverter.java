package info.digital_diary.converters;

import org.bson.types.ObjectId;

import info.digital_diary.models.*;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class ContactsConverter {

	// convert User Object to MongoDB DBObject
	// take special note of converting id String to ObjectId
	public static DBObject toDBObject(Contacts c) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("name", c.getName())
				.append("date", c.getDate())
				.append("phoneNo", c.getPhoneNo())
				.append("address", c.getAddress())
				.append("email", c.getEmail())
				.append("userEmail", c.getUserEmail());
		return builder.get();
	}

	// convert DBObject Object to User
	// take special note of converting ObjectId to String
	public static Contacts toUser(DBObject doc) {
		Contacts c = new Contacts();
		c.setName((String) doc.get("name"));
		c.setDate((String) doc.get("date"));
		c.setPhoneNo((String) doc.get("phoneNo"));
		c.setAddress((String) doc.get("address"));
		c.setEmail((String) doc.get("email"));
		c.setUserEmail((String) doc.get("userEmail"));
		return c;

	}
	
}