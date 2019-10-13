package info.digital_diary.models;

import java.util.regex.Pattern;

public class Keynotes {
	
	private String userEmail; //used as Unique key
	private String note;
	
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		if (!Pattern.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", userEmail)) {
			throw new IllegalArgumentException("Invalid Email Address");
		}
		this.userEmail = userEmail;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	

}
