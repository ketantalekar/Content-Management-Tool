package com.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String userName;
	private String email;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uid, String userName, String email) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.email = email;
	}

	public int getuId() {
		return uid;
	}

	public void setuId(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + uid + ", userName=" + userName + ", email=" + email + "]";
	}
	
	
}
