package com.masai.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(unique = true,nullable = false, length = 50)
	private String email;
	
	@Column(unique = true,nullable = false, length = 50)
	private String UserName;
	
	@Column(nullable = false, length = 50)
	private String password;
	
	@Column(name = "is_deleted", nullable = false)
	private int isDeleted;

	public Customer(String name, String email, String userName, String password, int isDeleted) {
		super();
		this.name = name;
		this.email = email;
		this.UserName = userName;
		this.password = password;
		this.isDeleted = isDeleted;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", UserName=" + UserName + ", password="
				+ password + ", isDeleted=" + isDeleted + "]";
	}
	
	
	
}
