package info.digital_diary.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.digital_diary.mongo.MongoCRUD;

import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "Pankaj";
	private final String password = "journaldev";
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		MongoCRUD userMongo = new MongoCRUD();
		boolean success = userMongo.findUser(name, email, password);
		
		if(success)
		{
			Cookie nameCookie = new Cookie("name",name);
			Cookie emailCookie = new Cookie("email",email);
			//setting cookie to expiry in 30 mins
			nameCookie.setMaxAge(30*60);
			emailCookie.setMaxAge(30*60);
			response.addCookie(nameCookie);
			response.addCookie(emailCookie);
			request.setAttribute("name", name);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard.jsp");
			rd.forward(request, response);
		
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
		
	}

}
