package com.masai.Dao;

import com.masai.Entity.Customer;
import com.masai.Exceptions.SomeThingWentWrongException;

public interface ICustomerDao {

	void addCSR(Customer customer) throws SomeThingWentWrongException;

	void login(String username, String password) throws SomeThingWentWrongException;
	void changePassword(String oldPassword,String newPassword) throws SomeThingWentWrongException;

	void delete() throws SomeThingWentWrongException;

	void raiseIssue(String description) throws SomeThingWentWrongException;

	void giveFeedback(int id, String feedback, int rating) throws SomeThingWentWrongException;
}
