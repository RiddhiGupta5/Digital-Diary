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

import info.digital_diary.mongo.*;
import info.digital_diary.models.*;

/**
 * Servlet implementation class displayKeynote
 */
@WebServlet("/displayKeynote")
public class displayKeynote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = null, userEmail = null;
		boolean success=true;
		
		Cookie titleCookie = new Cookie("title","displayKeynote");
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
    	
    	
    	
    	MongoCRUD keynoteMongo = new MongoCRUD();
    	
    	ArrayList<String> res = new ArrayList<String>();
    	
    	DBCursor cursor = keynoteMongo.viewKeynotes(userEmail);
    	
    	
    	
    	
    	try
    	{
	    	
    		while (cursor.hasNext()) {
    			BasicDBObject obj = (BasicDBObject) cursor.next();
    			res.add(obj.getString("note"));
    		}
    	}
    	catch(Exception e)
    	{
    		request.setAttribute("response", res);
        	request.setAttribute("title", "Keynotes");
        	page = "/displaypage.jsp";
    		
    	}
    	
    	
    	response.getWriter().append("Served at: ");
    	
    	
    	request.setAttribute("response", res);
    	request.setAttribute("title", "Keynotes");
    	page = "/displaypage.jsp";
    	
    	RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

}
