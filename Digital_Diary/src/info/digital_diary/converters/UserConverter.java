package info.digital_diary.converters;

import org.bson.types.ObjectId;

import info.digital_diary.models.User;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class UserConverter {

	// convert User Object to MongoDB DBObject
	// take special note of converting id String to ObjectId
	public static DBObject toDBObject(User u) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("name", u.getName())
				.append("dateOfSignup", u.getDateOfSignup())
				.append("dateOfBirth", u.getDateOfBirth())
				.append("phoneNo", u.getPhoneNo())
				.append("password", u.getPassword())
				.append("gender", u.getGender())
				.append("locality", u.getLocality())
				.append("city", u.getCity())
				.append("state", u.getState())
				.append("country", u.getCountry())
				.append("email", u.getEmail());
		return builder.get();
	}

	// convert DBObject Object to User
	// take special note of converting ObjectId to String
	public static User toUser(DBObject doc) {
		User u = new User();
		u.setName((String) doc.get("name"));
		u.setDateOfBirth((String) doc.get("dateOfBirth"));
		u.setDateOfSignup((String) doc.get("dateOfSignup"));
		u.setGender((String) doc.get("gender"));
		u.setPassword((String) doc.get("password"));
		u.setPhoneNo((String) doc.get("phoneNo"));
		u.setLocality((String) doc.get("locality"));
		u.setCity((String) doc.get("city"));
		u.setCountry((String) doc.get("country"));
		u.setEmail((String) doc.get("email"));
		return u;

	}
	
}