package com.masai.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Issues {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=255,nullable=false)
	private String description;
	@Column(length=10,nullable=false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	@ManyToOne
	@JoinColumn(name="Customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="CSR_id",nullable=true)
	private CustomerSupportRepresentative csr;
	
	@Column(length=255,nullable=true)
	private String reply;

	public Issues(String description, Status status, Customer customer, CustomerSupportRepresentative csr,String reply) {
		super();
	
		this.description = description;
		this.status = status;
		this.customer = customer;
		this.csr = csr;
		this.reply=reply;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Issues() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerSupportRepresentative getCsr() {
		return csr;
	}

	public void setCsr(CustomerSupportRepresentative csr) {
		this.csr = csr;
	}

	@Override
	public String toString() {
		return "Issues [id=" + id + ", description=" + description + ", status=" + status + ", customer=" + customer
				+ ", csr=" + csr + "]";
	}
	
	
}
