package com.StudentRegistration.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentRegistration.Dao.StudentDao;

import Modle.StudentModle;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// get some input from the user (use html form)
		
		   String user_id1=request.getParameter("studentId");
		   String username=request.getParameter("username");
		   String password=request.getParameter("password");
		   
	 // use StudentModle to send the collected data to DAO
		   
		  StudentModle theStudents= new StudentModle();
		  theStudents.setUser_id(user_id1);
		  theStudents.setUser_name(username);
		  theStudents.setPassword(password);
		  
 	// use DAO to save data into the database
		  
	   StudentDao students =new StudentDao();  	
	   
	  StudentModle data=students.updateStudent(user_id1, username, password);
	  
	   if(data !=null) {
		   // call anather form
		   response.sendRedirect("LoginPage.html");
	   }else {
		   response.sendRedirect("saveStudent.html");
	   }
	  
	  
		
	}

}
