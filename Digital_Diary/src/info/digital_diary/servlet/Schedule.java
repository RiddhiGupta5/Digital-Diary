package info.digital_diary.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.digital_diary.models.*;
import info.digital_diary.mongo.*;

/**
 * Servlet implementation class Schedule
 */
@WebServlet("/Schedule")
public class Schedule extends HttpServlet {
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
    		page = "/index.jsp";
    	}
        
    	if(emailCookie != null){
        		
    		userEmail = emailCookie.getValue();
        }
    	else
    	{
    		success = false;
    		page = "/index.jsp";
    	}
        	
    	
		
		String time = request.getParameter("time");		
		String task = request.getParameter("task");
		String location = request.getParameter("location");
		
		if ((time == null || time.equals(""))
				|| (task == null || task.equals(""))
				|| (location == null || location.equals("")))
		{
			request.setAttribute("error", "Mandatory Parameters Missing");
			page = "/schedule.jsp";
		}
		
		else {
			Schedules s = new Schedules();
			
			try
			{
				if(success) {
					s.settime(time);
					s.setActivity(task);
					s.setDate("default");
					s.setuseremailid(userEmail);
					s.setLocation(location);
				
				
					try {
						MongoCRUD scheduleMongo = new MongoCRUD();
						success = scheduleMongo.insertSchedule(s);
						
						if(success)
						{
							page = "/schedule.jsp";
							request.setAttribute("error", "Schedule saved successfully");
						}
						else
						{
							page = "/schedule.jsp";
							request.setAttribute("error", "There Was Some Problem");
							
						}
					}
					catch( Exception e)
					{
						page = "/schedule.jsp";
						request.setAttribute("error", "There Was Some Problem");
					}
				}
				
				
				
			}
			catch (IllegalArgumentException e)
			{
				page = "/schedule.jsp";
				request.setAttribute("error", e.getMessage());
			}
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

}
