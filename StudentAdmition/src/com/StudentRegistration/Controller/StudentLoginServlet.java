package com.StudentRegistration.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.StudentRegistration.Dao.StudentDao;

import Modle.StudentModle;


//@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // collect data from the form HTML
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Modle
        StudentModle students= new StudentModle();
       
      
        // send data to dao
        StudentDao dao= new StudentDao();
      
        StudentModle theStudents=dao.studentLogin(username, password);
        if(theStudents !=null && theStudents.getUser_name().equals(username) && theStudents.getPassword().equals(password)) {
        	
        	//Open Session
        	HttpSession session = request.getSession(true);
            session.setAttribute("student", theStudents);
        	response.sendRedirect("admitionPage.html");
        }else {
        	response.sendRedirect("LoginPage.html");
        }
        
}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	// collect data from the form HTML
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Modle
        StudentModle students= new StudentModle();
       
      
        // send data to dao
        StudentDao dao= new StudentDao();
        StudentModle theStudents=dao.studentLogin(username, password);
        if(theStudents !=null && theStudents.getUser_name().equals(username) && theStudents.getPassword().equals(password)) {
        	//Open Session
        	HttpSession session = request.getSession(true);
            session.setAttribute("student", theStudents);
        	response.sendRedirect("admitionPage.html");
        }else {
        	response.sendRedirect("LoginPage.html");
        }
    }
}



