package info.digital_diary.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
    	Cookie nameCookie = null;
    	Cookie emailCookie = null;
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("name")){
    			nameCookie = cookie;
    		}
    		if(cookie.getName().equals("email")){
    			emailCookie = cookie;
    		}
    		
    	}
    	}
    	if(nameCookie != null){
    		nameCookie.setMaxAge(0);
    		emailCookie.setMaxAge(0);
        	response.addCookie(nameCookie);
        	response.addCookie(emailCookie);
    	}
    	response.sendRedirect("index.jsp");
		
	}

}
