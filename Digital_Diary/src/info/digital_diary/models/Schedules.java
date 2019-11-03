package info.digital_diary.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Schedules{
	
	 private String useremailid;
	 private String date;
	 private String Activity;
	 private String time;
	 private String location;
	 
	 public String getuseremailid() {
		 return useremailid;
	 }
	 public void setuseremailid(String useremailid) {
		 if (!Pattern.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", useremailid)) {
				throw new IllegalArgumentException("Invalid Email Address");
		 }
		 this.useremailid=useremailid;
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
	public String getActivity() {
		return Activity;
	}
	public void setActivity(String Activity) {
		this.Activity=Activity;
	}
	public String gettime(){
		return time;
		
	}
	public void settime(String time)
	{
		if (!Pattern.matches("^[0-9]{2}:[0-9]{2}$", time)) {
			throw new IllegalArgumentException("Invalid time");
		}
		this.time=time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	 
		 
	 
}