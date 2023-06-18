package com.masai.Service;


import java.util.List;
import java.util.Scanner;

import com.masai.Dao.CSRDaoImpl;
import com.masai.Dao.ICSRDao;
import com.masai.Entity.CustomerSupportRepresentative;
import com.masai.Entity.Issues;
import com.masai.Entity.LoggedIn;
import com.masai.Entity.Status;
import com.masai.Entity.feedback;
import com.masai.Exceptions.SomeThingWentWrongException;

public class CSRimpl implements ICSRService{

	@Override
	public void addCSR(CustomerSupportRepresentative customer) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		csrdao.addCSR(customer);
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		csrdao.login(username, password);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		csrdao.changePassword(oldPassword, newPassword);;
	}

	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		csrdao.delete();
	}

	@Override
	public void ViewIssues() {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		List<Issues> issues=csrdao.viewIssues();
		if(issues.size()>0) {
			System.out.println("IssueID"+" "+"CustomerID"+"               "+"Description"+"                   "+"Status"+"   "+"AssignedTo");

			for(Issues i:issues) {
				if(i.getCsr()==null) {
					System.out.println(i.getId()+"           "+i.getCustomer().getId()+"         "+i.getDescription()+" "+i.getStatus()+" "+"NOT YET");
				}else {
					System.out.println(i.getId()+"           "+i.getCustomer().getId()+"         "+i.getDescription()+" "+i.getStatus()+" "+i.getCsr().getId());
				}
				
			}
		}
		
	}

	@Override
	public void assignToYou() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		csrdao.assignToYou();
	}
    
	@Override
	public void replyToIssues(int id,Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		List<Issues> issues=csrdao.viewIssues();
		for(Issues i:issues) {
			if(i.getCsr().getId()== LoggedIn.userid && i.getStatus()==Status.OPEN) {
				System.out.println(i.getId()+"  "+i.getDescription());
			}
		}
		System.out.println("Enter Issue Id to reply");
		id=sc.nextInt();
		System.out.println("Enter Your Reply");
		sc.nextLine();
		String reply=sc.nextLine();
		csrdao.replyTOissue(id,reply);
	}
 
	public void viewCSR() {
		ICSRDao csrdao=new CSRDaoImpl();
		List<CustomerSupportRepresentative> csrList=csrdao.ViewCsr();
		
		for(CustomerSupportRepresentative i:csrList) {
			System.out.println(i.getId()+" "+i.getFirstName());
		}
	}

	@Override
	public void assignToOther(int id) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		csrdao.assignToOther(id);
	}

	@Override
	public void closeIssue(int id,Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		List<Issues> issues=csrdao.viewIssues();
		for(Issues i:issues) {
			if(i.getCsr().getId()== LoggedIn.userid && i.getStatus()==Status.OPEN) {
				System.out.println(i.getId()+"  "+i.getDescription());
			}
		}
		System.out.println("Enter Issue Id to reply");
		id=sc.nextInt();
		csrdao.closeIssue(id);
	}

	@Override
	public void viewFEEDBACK() {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		List<feedback> feedback=csrdao.getFeedback();
		
		for(feedback i:feedback) {
			if(i.getIssue().getCsr().getId()==LoggedIn.userid) {
				System.out.println(i.getIssue().getDescription()+"---->"+i.getMessage());
			}
		}
		
	}

	@Override
	public void ViewStatus() {
		// TODO Auto-generated method stub
		ICSRDao csrdao=new CSRDaoImpl();
		List<Issues> issues=csrdao.viewIssues();
		for(Issues i:issues) {
			if(i.getCustomer().getId()==LoggedIn.userid) {
				System.out.println(i.getId()+" "+i.getDescription()+" "+i.getStatus());
			}
		}
	}

}
