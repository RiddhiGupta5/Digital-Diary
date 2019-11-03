package info.digital_diary.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.digital_diary.models.Reviews;
import info.digital_diary.mongo.MongoCRUD;

/**
 * Servlet implementation class Review
 */
@WebServlet("/Review")
public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
       
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
        	
    	
		
		String emotion = request.getParameter("emotion");		
		String body = request.getParameter("body");
		
		
		
		if ((emotion == null || emotion.equals(""))
				|| (body == null || body.equals("")))
		{
			request.setAttribute("error", "Mandatory Parameters Missing");
			page = "/review.jsp";
			
		}
		
		
		
		else {
			
			Reviews r = new Reviews();
			
			try
			{
				if(success) {
					r.setbody(body);
					r.setDate("default");
					r.setemotion(emotion);
					r.setuseremailid(userEmail);
				
				
					try {
						MongoCRUD reviewMongo = new MongoCRUD();
						success = reviewMongo.insertReview(r);
						
						if(success)
						{
							page = "/review.jsp";
							request.setAttribute("error", "Review saved successfully");
						}
						else
						{
							page = "/review.jsp";
							request.setAttribute("error", "There Was Some Problem");
							
						}
					}
					catch( Exception e)
					{
						page = "/review.jsp";
						request.setAttribute("error", "There Was Some Problem");
					}
				}
				
				
				
			}
			catch (IllegalArgumentException e)
			{
				page = "/review.jsp";
				request.setAttribute("error", e.getMessage());
			}
			
			
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
		
	}
}


