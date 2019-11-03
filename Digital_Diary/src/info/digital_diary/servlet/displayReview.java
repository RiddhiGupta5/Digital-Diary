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

/**
 * Servlet implementation class displayReview
 */
@WebServlet("/displayReview")
public class displayReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String page=null;
    	ArrayList<String> res = new ArrayList<String>();
    	
    	Cookie titleCookie = new Cookie("title","Reviews");
		titleCookie.setMaxAge(30*60);
		response.addCookie(titleCookie);
    	
    	request.setAttribute("response", res);
    	request.setAttribute("title", "REVIEWS");
    	page = "/displaypage_with_date.jsp";
    	
    	RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);;
	}

}
