package info.digital_diary.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
 * Servlet implementation class displayWithDate
 */
@WebServlet("/displayWithDate")
public class displayWithDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String date = request.getParameter("date");
    	String userEmail = null, page = null;
    	String title = null;
    	boolean success;
    	
    	ArrayList<String> res = new ArrayList<String>();
    	
    	
    		Cookie emailCookie = null;
        	Cookie[] cookies = request.getCookies();
        	if(cookies != null){
            	for(Cookie cookie : cookies){
            		if(cookie.getName().equals("email")){
            			emailCookie = cookie;
            		}
            		if(cookie.getName().equals("title")) {
            			title = cookie.getValue();
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
        	
        	if (!Pattern.matches("^[0-9]{2}[-/][0-9]{2}[-/][12][0-9]{3}$", date)) {
        		request.setAttribute("error", "Invalid Date");
        		page = "/displaypage_with_date.jsp";
        	}
        	
        	
        	
        	MongoCRUD findMongo = new MongoCRUD();
        	
        	
        	
        	try
        	{
        		res = findMongo.viewParameterWithDate(userEmail, date, title);
        		System.out.println(res);
        		
        	}
        	catch(Exception e)
        	{
        		request.setAttribute("response", res);
            	request.setAttribute("title", title.toUpperCase());
            	page = "/displaypage_with_date.jsp";
        		
        	}
        	
       
    	request.setAttribute("response", res);
    	request.setAttribute("title", title.toUpperCase());
    	page = "/displaypage_with_date.jsp";
    	
    	
    	RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
    	
	}

}
