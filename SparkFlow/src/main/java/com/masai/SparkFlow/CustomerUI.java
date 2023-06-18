package com.masai.SparkFlow;

import java.util.Scanner;

import com.masai.Dao.CustomerDao;
import com.masai.Dao.ICustomerDao;
import com.masai.Entity.Customer;
import com.masai.Exceptions.SomeThingWentWrongException;
import com.masai.Service.CSRimpl;
import com.masai.Service.CustomerServiceImpl;
import com.masai.Service.ICSRService;
import com.masai.Service.ICustomerService;

public class CustomerUI {

	public static void userLogin(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();

		ICustomerService csrService = new CustomerServiceImpl();
		try {
			csrService.login(username, password);
			CustomerMenu(sc);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void displayCustomerMenu() {
		System.out.println("1. Raise Issue");
		System.out.println("2. View Issue Status");
		System.out.println("3. Provide FeedBack");
		System.out.println("4. CHANGE PASSWORD");
		System.out.println("5. LOGOUT");
		System.out.println("6. DELETE ACCOUNT");
	}

	private static void CustomerMenu(Scanner sc) {
		// TODO Auto-generated method stub
		int choice = 0;
		do {
			displayCustomerMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				raiseIssue(sc);
				break;
			case 2:
				viewIssueStatus();
				break;
			case 3:
				GiveFeedback();
				break;
			case 4:
				changePassword(sc);
				break;
			case 5:
				System.out.println("Bye Bye Admin");
				break;
			case 6:
				DELETE(sc);
				break;
			default:
				System.out.println("Invalid Selection, try again");
			}
		} while (choice != 5);
	}

	private static void changePassword(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter Old Password");
		String op = sc.next();
		System.out.print("Enter New Password");
		String np = sc.next();
		ICustomerService csrService = new CustomerServiceImpl();
		try {
			csrService.changePassword(op, np);
			;
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	private static void GiveFeedback() {
		// TODO Auto-generated method stub
		ICustomerService customerService = new CustomerServiceImpl();
		try {
			customerService.giveFeedback();
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void viewIssueStatus() {
		// TODO Auto-generated method stub
		ICSRService customerService = new CSRimpl();
		customerService.ViewStatus();

	}

	private static void raiseIssue(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter Description ");
		sc.nextLine();
		String Description = sc.nextLine();

		ICustomerService customerService = new CustomerServiceImpl();
		try {
			customerService.raiseIssue(Description);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void DELETE(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Are you sure you want to delete your account?[y/n] ");
		char choice = sc.next().toLowerCase().charAt(0);
		if (choice == 'y') {
			try {
				ICustomerService customerService = new CustomerServiceImpl();
				customerService.deleteAccount();
				System.out.println("Its really sad to see you go, As per your request account is deleted");
			} catch (SomeThingWentWrongException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void customerRegistration(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter name ");
		String fname = sc.next();
		System.out.print("Enter Email");
		String Email = sc.next();
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();

		Customer customer = new Customer(fname, Email, username, password, 1);

		ICustomerService cService = new CustomerServiceImpl();
		try {
			cService.addCustomer(customer);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
