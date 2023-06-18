package com.masai.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CSR")
public class CustomerSupportRepresentative {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = false, length = 50)
	private String firstName;

	@Column(unique = false, length = 50)
	private String lastName;

	@Column(unique = true, length = 50, nullable = false)
	private String Email;

	@Column(unique = true, length = 50, nullable = false)
	private String username;

	@Column(nullable = false, length = 50)
	private String password;

	@Column(name = "is_deleted", nullable = false)
	private int isDeleted;

	public CustomerSupportRepresentative() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerSupportRepresentative(String firstName, String lastName, String email, String username,
			String password, int isDeleted) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		Email = email;
		this.username = username;
		this.password = password;
		this.isDeleted = isDeleted;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	
	
}
