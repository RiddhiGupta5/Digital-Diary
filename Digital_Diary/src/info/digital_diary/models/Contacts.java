package info.digital_diary.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Contacts {
	
	private String userEmail; //Used foreign key
	private String date; 
	private String phoneNo; 
	private String email; 
	private String name;
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		
		if (!Pattern.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", userEmail)) {
			throw new IllegalArgumentException("Invalid Email Address");
		}
		
		this.userEmail = userEmail;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		if (date.equals("default"))
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDateTime now = LocalDateTime.now();
			this.date = dtf.format(now);
		}
		else
		{
			this.date = date;
		}
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		if (!Pattern.matches("^[9876][0-9]{9}", phoneNo)) {
			throw new IllegalArgumentException("Invalid phone No");
		}
		this.phoneNo = phoneNo;
	}
	
	public String getEmail() {		
		return email;
	}
	public void setEmail(String email) {
		if (!Pattern.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", email)) {
			throw new IllegalArgumentException("Invalid Email Address");
		}
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
