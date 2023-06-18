package com.masai.Service;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.CSRDaoImpl;
import com.masai.Dao.CustomerDao;
import com.masai.Dao.ICSRDao;
import com.masai.Dao.ICustomerDao;
import com.masai.Entity.Customer;
import com.masai.Entity.Issues;
import com.masai.Entity.LoggedIn;
import com.masai.Entity.Status;
import com.masai.Exceptions.SomeThingWentWrongException;

public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void addCustomer(Customer customer) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICustomerDao csrdao=new CustomerDao();
		csrdao.addCSR(customer);
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICustomerDao cdao=new CustomerDao();
		cdao.login(username,password);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICustomerDao cdao=new CustomerDao();
		cdao.changePassword(oldPassword, newPassword);
	}

	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICustomerDao cdao=new CustomerDao();
		cdao.delete();
	}


	@Override
	public void raiseIssue(String description) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICustomerDao cdao=new CustomerDao();
		cdao.raiseIssue(description);
	}

	@Override
	public void giveFeedback() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ICustomerDao cdao=new CustomerDao();
		
		ICSRDao csrdao=new CSRDaoImpl();
		List<Issues> issues=csrdao.viewIssues();
		
		for(Issues i:issues) {
			if(i.getStatus().equals(Status.CLOSED) && i.getCustomer().getId()==LoggedIn.userid) {
				System.out.println(i.getId()+" "+i.getDescription()+" "+i.getReply());
			}
		}
		System.out.println("SELECT closed issues to give feedback");
		int id=sc.nextInt();
		System.out.println("Enter the feed back");
		sc.nextLine();
		String feedback=sc.nextLine();
		System.out.println("Rate 1 to 5");
		int rating=sc.nextInt();
		cdao.giveFeedback(id,feedback,rating);
		
	}

}
