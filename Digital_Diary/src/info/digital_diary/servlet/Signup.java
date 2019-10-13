package info.digital_diary.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import info.digital_diary.models.User;
import info.digital_diary.mongo.MongoCRUD;;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page;
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String phoneNo = request.getParameter("phone_no");
		String gender = request.getParameter("gender");
		String locality = request.getParameter("locality");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		
		
		if ((name == null || name.equals(""))
				|| (email == null || email.equals(""))
				|| (password == null || password.equals(""))
				|| (country == null || country.equals(""))
				|| (dateOfBirth == null || dateOfBirth.equals(""))
				|| (phoneNo == null || phoneNo.equals(""))
				|| (gender == null || gender.equals(""))) {
			
			request.setAttribute("error", "Mandatory Parameters Missing");
			page = "/signup.jsp";
			
		} 
		else {
			User u = new User();
			
			try
			{
				u.setName(name);
				u.setDateOfBirth(dateOfBirth);
				u.setDateOfSignup("default");
				u.setGender(gender);
				u.setPassword(password);
				u.setPhoneNo(phoneNo);
				u.setLocality(locality);
				u.setCity(city);
				u.setCountry(country);
				u.setEmail(email);
				u.setState(state);
				
				try {
					MongoCRUD userMongo = new MongoCRUD();
					boolean success = userMongo.insertUser(u);
					
					if(success)
					{
						page = "/index.jsp";
					}
					else
					{
						page = "/signup.jsp";
						request.setAttribute("error", "User Already Exists");
						
					}
				}
				catch( Exception e)
				{
					page = "/signup.jsp";
					request.setAttribute("error", "User Already Exists");
				}
				
				
				
			}
			catch (IllegalArgumentException e)
			{
				page = "/signup.jsp";
				
				//PrintWriter out = response.getWriter();
				//out.println("ERROR");
				request.setAttribute("error", e.getMessage());
			}
			
			
			
			
			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

}
