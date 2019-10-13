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
import info.digital_diary.mongo.MongoCRUD;

/**
 * Servlet implementation class Keynote
 */
@WebServlet("/Keynote")
public class Keynote extends HttpServlet {
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
        	
		
		String note = request.getParameter("notes");
		
		if ((note == null || note.equals("")))
		{
			request.setAttribute("error", "Mandatory Parameters Missing");
			page = "/keynote.jsp";
		}
		
		else {
			Keynotes k = new Keynotes();
			
			try
			{
				if(success) {
					k.setNote(note);
					k.setUserEmail(userEmail);
				
				
					try {
						MongoCRUD keynoteMongo = new MongoCRUD();
						success = keynoteMongo.insertKeyNote(k);
						
						if(success)
						{
							page = "/dashboard.jsp";
						}
						else
						{
							page = "/keynote.jsp";
							request.setAttribute("error", "There Was Some Problem");
							
						}
					}
					catch( Exception e)
					{
						page = "/keynote.jsp";
						request.setAttribute("error", "There Was Some Problem");
					}
				}
				
				
				
			}
			catch (IllegalArgumentException e)
			{
				page = "/keynote.jsp";
				request.setAttribute("error", e.getMessage());
			}
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
	}

}
