package com.StudentRegistration.Dao;
import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Hibernate.util.HibernateUtil;

import Modle.StudentModle;

public class StudentDao {

	
	public StudentModle saveStudent(StudentModle theStudents) {
		
		try {
			
			Session ss=HibernateUtil.getSessionFactory().openSession();
			ss.save(theStudents);
		    Transaction tr=ss.beginTransaction();
		    tr.commit();
		    ss.close();
		    return theStudents;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	// update Student
	
	public StudentModle updateStudent(String user_id,String user_name,String password) {
		
		
		 try {
			 Session ss=HibernateUtil.getSessionFactory().openSession();
			 Transaction tr=ss.beginTransaction();
			 // retrieve data by user_id from the database by using StudentModle 
			 StudentModle theStudent = new StudentModle();
			 theStudent = ss.get(StudentModle.class, user_id);
			 // Then its time to update
			 if(user_id ==theStudent.getUser_id())
			 {
				 theStudent.setUser_name(user_name);
				 theStudent.setPassword(password);
				 ss.update(theStudent);
				 tr.commit();
			 }else
			
			 ss.close();
			 return theStudent;
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		return null;
	}
	
	// Login DAO
	
	public StudentModle studentLogin(String username, String password) {
	    try {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        Query query = session.createQuery("select  student FROM StudentModle student WHERE student.user_name = :username AND student.password = :password",StudentModle.class);
	        query.setParameter("username", username);
	        query.setParameter("password", password);
	        StudentModle student = (StudentModle) query.uniqueResult();
	        transaction.commit();
	        if(student !=null) {
	        	return student;
	        }
	        session.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	      
	    }
	 return null;
	}

	}



