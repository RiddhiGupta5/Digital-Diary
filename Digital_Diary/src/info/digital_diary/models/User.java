/**
 * 
 */
package info.digital_diary.models;

import java.util.regex.Pattern;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * @author Riddhi Gupta
 *
 */
public class User {
	
	private String email; //Used as Primary key
	private String name;
	private String password;
	private String dateOfSignup;
	private String dateOfBirth;
	private String phoneNo;
	private String gender;
	private String locality;
	private String city;
	private String state;
	private String country;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		if (!Pattern.matches("^[0-9]{2}-[0-9]{2}-[0-9]{4}", dateOfBirth)) {
			throw new IllegalArgumentException("Invalid date of birth");
		}
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfSignup() {
		return dateOfSignup;
	}

	public void setDateOfSignup(String dateOfSignup) {
		if (dateOfSignup.equals("default"))
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDateTime now = LocalDateTime.now();
			this.dateOfSignup = dtf.format(now);
		}
		else
		{
			this.dateOfSignup = dateOfSignup;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if (!Pattern.matches("^[FM]", gender)) {
			throw new IllegalArgumentException("Invalid gender");
		}
		this.gender = gender;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
