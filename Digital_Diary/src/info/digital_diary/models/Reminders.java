package info.digital_diary.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Reminders{
	private String useremailid;
	private String time;
	private String date;
	private String Location;
	private String Category;
	private String Description;
	
	public String getuseremailid(){
		return useremailid;
	}
	
	 public void setuseremailid(String useremailid) {
		 if (!Pattern.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", useremailid)) {
				throw new IllegalArgumentException("Invalid Email Address");
		 }
		 this.useremailid=useremailid;
	 }
	 
	 public void settime(String time){
		 if (!Pattern.matches("^[0-9]{2}:[0-9]{2}$", time)) {
			throw new IllegalArgumentException("Invalid time");
		}
		this.time=time;
	 }
	 
	 public String gettime(){
		 return time;
	 }
	 
	 public void setdate(String date) {
		 if (!Pattern.matches("^[0-9]{2}[-/][0-9]{2}[-/][12][0-9]{3}$", date)) {
				throw new IllegalArgumentException("Invalid date");
		 }
		 this.date = date;
		}
	 
	 public String getdate(){
		 return date;
	 }
	 
	 public void setlocation(String Location){
		 this.Location = Location;
	 }
	 
	 public String getlocation(){
		 return Location;
	 }
	 
	 public void setcategory(String Category){
		 this.Category = Category;
	 }
	 
	 public String getcategory(){
		 return Category;
	 }
	 
	 public void setdesc(String Description){
		 this.Description = Description;
	 }
	 
	 public String getdesc(){
		 return Description;
	 }
}
