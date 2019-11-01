package info.digitaldiary.models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Reminder{
	private String useremailid;
	private String time;
	private String date;
	private String Location;
	private String Category;
	private String Description
	
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
		 this.time = time;
	 }
	 public void gettime(){
		 return time;
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
	 public void getdate(){
		 return date;
	 }
	 public void setlocation(String Location){
		 this.Location = Location;
	 }
	 public void getlocation(){
		 return Location;
	 }
	 public void setcategory(String Category){
		 this.Category = Category;
	 }
	 public void getcategory(){
		 return Category;
	 }
	 public void setdesc(String Description){
		 this.Description = Description;
	 }
	 public void getdesc(){
		 return Description;
	 }
}