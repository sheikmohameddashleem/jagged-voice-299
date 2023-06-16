package com.masai.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

	
}
