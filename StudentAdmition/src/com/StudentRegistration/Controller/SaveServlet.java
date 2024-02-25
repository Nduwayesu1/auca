package com.StudentRegistration.Controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentRegistration.Dao.StudentDao;

import Modle.StudentModle;


//@WebServlet("/saveSudents")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// get request from client 
		String user_id=request.getParameter("userId");
		String user_name=request.getParameter("username");
		String password=request.getParameter("password");
	
		
		// create student Object by using Modle
		StudentModle theStudents= new StudentModle();
		theStudents.setUser_id(user_id);
		theStudents.setUser_name(user_name);
		theStudents.setPassword(password);
	
		
		//save student data by using Dao
		
		StudentDao dao =new StudentDao();
	  StudentModle saved=	dao.saveStudent(theStudents);
		
		// get a feed back from Anather html form by using redirectMethod()
		if(saved !=null) {
			response.sendRedirect("LoginPage.html");
		}else {
			
				response.sendRedirect("saveStudent.html");
		}
	}

}
