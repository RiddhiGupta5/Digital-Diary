package info.digital_diary.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Reviews{
	private String useremailid;
	private String date;
	private String emotion;
	private String body;
	
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
	 public String getemotion(){
		 return emotion;
	 }
	 public void setemotion(String emotion){
		 if(isNullOrEmpty(emotion)){
	            throw new IllegalArgumentException("Invalid Entry for Emotion");
		 }
		 this.emotion=emotion;
	 }
	 public String getbody(){
		 return body;
	 }
	 public void setbody(String body){
		 this.body=body;
	 }
	 public static boolean isNullOrEmpty(String str) {
	        if(str != null && !str.isEmpty())
	            return false;
	        return true;
	    }
}
