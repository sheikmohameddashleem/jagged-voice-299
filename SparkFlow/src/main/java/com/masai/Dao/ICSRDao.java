package com.masai.Dao;


import java.util.List;

import com.masai.Entity.CustomerSupportRepresentative;
import com.masai.Entity.Issues;
import com.masai.Entity.feedback;
import com.masai.Exceptions.SomeThingWentWrongException;

public interface ICSRDao {

	void addCSR(CustomerSupportRepresentative customer) throws SomeThingWentWrongException;
	void login(String username,String password) throws SomeThingWentWrongException;
	void changePassword(String oldPassword,String newPassword) throws SomeThingWentWrongException;
	void delete() throws SomeThingWentWrongException;
	List<Issues> viewIssues();
	void assignToYou() throws SomeThingWentWrongException;
	List<CustomerSupportRepresentative> ViewCsr();
	void assignToOther(int id) throws SomeThingWentWrongException;
	void replyTOissue(int id, String reply) throws SomeThingWentWrongException;
	void closeIssue(int id) throws SomeThingWentWrongException;
	List<feedback> getFeedback();
}
