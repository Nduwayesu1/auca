package Modle;

import javax.persistence.*;

@Entity
@Table(name="StudentModle" )
public class StudentModle {
   @Id
   private String user_id;
   @Column
   private String user_name;
   @Column
   private String password;
   
public StudentModle() {
	super();
	
}
public StudentModle(String user_id, String user_name, String password) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.password = password;
	
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


   
   
}
