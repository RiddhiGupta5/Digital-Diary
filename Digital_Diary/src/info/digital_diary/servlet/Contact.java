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
 * Servlet implementation class Contact
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet {
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
        	
		
    	String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNo = request.getParameter("phone_no");
		String address = request.getParameter("address");
		
		
		if ((name == null || name.equals(""))
				|| (phoneNo == null || phoneNo.equals(""))
				|| (address == null || address.equals(""))
				|| (email == null || email.equals("")))
		{
			request.setAttribute("error", "Mandatory Parameters Missing");
			page = "/contact.jsp";
		}
		
		else {
			Contacts c = new Contacts();
			
			
			
			try
			{
				if(success) {
					c.setName(name);
					c.setDate("default");
					c.setPhoneNo(phoneNo);
					c.setAddress(address);
					c.setEmail(email);
					c.setUserEmail(userEmail);
				
				
					try {
						MongoCRUD contactMongo = new MongoCRUD();
						success = contactMongo.insertContact(c);
						
						if(success)
						{
							page = "/contact.jsp";
							request.setAttribute("error", "Contact Saved Successfully");
						}
						else
						{
							page = "/contact.jsp";
							request.setAttribute("error", "There Was Some Problem");
							
						}
					}
					catch( Exception e)
					{
						page = "/contact.jsp";
						request.setAttribute("error", "There Was Some Problem");
					}
				}
				
				
				
			}
			catch (IllegalArgumentException e)
			{
				page = "/contact.jsp";
				request.setAttribute("error", e.getMessage());
			}
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		}
    	
	}

