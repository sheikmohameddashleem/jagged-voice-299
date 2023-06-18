package com.masai.Service;

import com.masai.Entity.Customer;
import com.masai.Exceptions.SomeThingWentWrongException;

public interface ICustomerService {

	void addCustomer(Customer customer) throws SomeThingWentWrongException;
	void login(String username,String password) throws SomeThingWentWrongException;
	void changePassword(String oldPassword,String newPassword) throws SomeThingWentWrongException;
	void deleteAccount() throws SomeThingWentWrongException;
	void raiseIssue(String description) throws SomeThingWentWrongException;
	void giveFeedback() throws SomeThingWentWrongException;

}
