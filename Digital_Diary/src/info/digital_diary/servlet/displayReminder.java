package info.digital_diary.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import info.digital_diary.mongo.MongoCRUD;

/**
 * Servlet implementation class displayReminder
 */
@WebServlet("/displayReminder")
public class displayReminder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String page = null, userEmail = null;
		boolean success=true;
		
		Cookie titleCookie = new Cookie("title","displayReminder");
		titleCookie.setMaxAge(30*60);
		response.addCookie(titleCookie);
		
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
    	
    	
    	
    	MongoCRUD remindersMongo = new MongoCRUD();
    	
    	ArrayList<String> res = new ArrayList<String>();
    	
    	DBCursor cursor = remindersMongo.viewReminders(userEmail);
    	
    	String temp = null;
    	
    	
    	try
    	{
	    	
    		while (cursor.hasNext()) {
    			BasicDBObject obj = (BasicDBObject) cursor.next();
    			temp = "Time: " + obj.getString("time") 
    			+ "<br>Date: " + obj.getString("date") 
    			+ "<br>Location: " + obj.getString("location")
    			+ "<br>Category: " + obj.getString("category")
    			+ "<br>Description: " + obj.getString("description");
    			res.add(temp);
    		}
    	}
    	catch(Exception e)
    	{
    		request.setAttribute("response", res);
        	request.setAttribute("title", "Reminders");
        	page = "/displaypage.jsp";
    		
    	}
    	
    	
    	response.getWriter().append("Served at: ");
    	
    	
    	request.setAttribute("response", res);
    	request.setAttribute("title", "Reminders");
    	page = "/displaypage.jsp";
    	
    	RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
