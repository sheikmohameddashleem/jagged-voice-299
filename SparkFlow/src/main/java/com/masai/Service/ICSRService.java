package com.masai.Service;

import java.util.Scanner;

import com.masai.Entity.CustomerSupportRepresentative;
import com.masai.Exceptions.SomeThingWentWrongException;

public interface ICSRService {

	void addCSR(CustomerSupportRepresentative customer) throws SomeThingWentWrongException;
	void login(String username,String password) throws SomeThingWentWrongException;
	void changePassword(String oldPassword,String newPassword) throws SomeThingWentWrongException;
	void deleteAccount() throws SomeThingWentWrongException;
	void ViewIssues();
	void assignToYou() throws SomeThingWentWrongException;
	void replyToIssues(int id, Scanner sc) throws SomeThingWentWrongException;
	void viewCSR();
	void assignToOther(int id) throws SomeThingWentWrongException;
	void closeIssue(int id,Scanner sc) throws SomeThingWentWrongException;
	void viewFEEDBACK();
	void ViewStatus();
}
