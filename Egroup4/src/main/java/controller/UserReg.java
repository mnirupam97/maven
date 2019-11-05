package controller;
import service.UsersDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;


/**
 * Servlet implementation class UserReg
 */
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		String cname=request.getParameter("cname");
		String coursetype=request.getParameter("coursetype");
		String city=request.getParameter("city");
		String fees=request.getParameter("fees");
		String pincode=request.getParameter("pincode");
		
      Users users= new Users(cid, cname, coursetype, city, fees, pincode);	
		
		boolean flag= new UsersDao().registerUser(users);
		if(flag){
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("#");
		}
	
	}
}
