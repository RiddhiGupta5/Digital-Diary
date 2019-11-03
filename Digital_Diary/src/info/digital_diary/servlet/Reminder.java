package info.digital_diary.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.digital_diary.models.Reminders;
import info.digital_diary.mongo.MongoCRUD;

/**
 * Servlet implementation class Reminder
 */
@WebServlet("/Reminder")
public class Reminder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null, userEmail = null;
		boolean success=true;
		
		Cookie emailCookie = null;
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
        	for(Cookie cookie : cookies){
        		if(cookie.getName().equals("email")){
        			emailCookie = cookie;
        		}        		
        	}
        }
    	else
    	{
    		success = false;
    		page = "/";
    	}
        
    	if(emailCookie != null){
        		
    		userEmail = emailCookie.getValue();
        }
    	else
    	{
    		success = false;
    		page = "/";
    	}
        	
    	
		
		String date = request.getParameter("date");		
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		
		
		
		if ((date == null || date.equals(""))
				|| (time == null || time.equals(""))
				|| (location == null || location.equals(""))
				|| (description == null || description.equals(""))
				|| (category == null || category.equals("")))
		{
			request.setAttribute("error", "Mandatory Parameters Missing");
			page = "/reminder.jsp";
			
		}
		
		
		
		else {
			
			Reminders r = new Reminders();
			
			try
			{
				if(success) {
					r.setcategory(category);
					r.setdate(date);
					r.setdesc(description);
					r.setlocation(location);
					r.settime(time);
					r.setuseremailid(userEmail);
				
				
					try {
						MongoCRUD reviewMongo = new MongoCRUD();
						success = reviewMongo.insertReminder(r);
						
						if(success)
						{
							page = "/reminder.jsp";
							request.setAttribute("error", "Review saved successfully");
						}
						else
						{
							page = "/reminder.jsp";
							request.setAttribute("error", "There Was Some Problem");
							
						}
					}
					catch( Exception e)
					{
						page = "/reminderjsp";
						request.setAttribute("error", "There Was Some Problem");
					}
				}
				
				
				
			}
			catch (IllegalArgumentException e)
			{
				page = "/reminder.jsp";
				request.setAttribute("error", e.getMessage());
			}
			
			
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
		
	}
}


