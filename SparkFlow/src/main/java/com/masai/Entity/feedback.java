package com.masai.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 255, nullable = false)
	private String message;

	@Column(nullable = true)
	private int rating;

	@ManyToOne
	@JoinColumn(name = "issue_id")
	private Issues issue;

	public feedback(String message, int rating, Issues issue) {
		super();
		this.message = message;
		this.rating = rating;
		this.issue = issue;
	}

	public feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Issues getIssue() {
		return issue;
	}

	public void setIssue(Issues issue) {
		this.issue = issue;
	}

	@Override
	public String toString() {
		return "feedback [id=" + id + ", message=" + message + ", rating=" + rating + ", issue=" + issue + "]";
	}

}
