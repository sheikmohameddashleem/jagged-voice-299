package com.masai.SparkFlow;

import java.util.Scanner;

import com.masai.Entity.CustomerSupportRepresentative;
import com.masai.Exceptions.SomeThingWentWrongException;
import com.masai.Service.CSRimpl;
import com.masai.Service.ICSRService;

public class CSRui {

	public static void CSRLogin(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();

		ICSRService csrService = new CSRimpl();
		try {
			csrService.login(username, password);
			CSRMenu(sc);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void displayCSRMenu() {
		System.out.println("1. View Issues");
		System.out.println("2. Assign Issue");
		System.out.println("3. Reply To Issue");
		System.out.println("4. Close Issue");
		System.out.println("5. View FEEDBACK");
		System.out.println("6. CHANGE PASSWORD");
		System.out.println("7. DELETE ACCOUNT");
		System.out.println("8. LogOut");
	}

	private static void CSRMenu(Scanner sc) {
		// TODO Auto-generated method stub
		int choice = 0;
		do {
			displayCSRMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				ViewIssues();
				break;
			case 2:
				assignIssue(sc);
				break;
			case 3:
				replyToIssues(sc);
				break;
			case 4:
				closeIssue(sc);
				break;
			case 5:
                ViewFeedback();
				break;
			case 6:
				changePassword(sc);
				break;
			case 7:
				DELETE(sc);
				break;
			case 8:
				System.out.println("Bye Bye Admin");
				break;
			default:
				System.out.println("Invalid Selection, try again");
			}
		} while (choice != 8);
	}

	private static void ViewFeedback() {
		// TODO Auto-generated method stub
		ICSRService csrService = new CSRimpl();
		csrService.viewFEEDBACK();
	}

	private static void closeIssue(Scanner sc) {
		// TODO Auto-generated method stub
		int id = 0;
		ICSRService csrService = new CSRimpl();
		try {
			csrService.closeIssue(id, sc);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void replyToIssues(Scanner sc) {
		// TODO Auto-generated method stub
		int id = 0;
		ICSRService csrService = new CSRimpl();
		try {
			csrService.replyToIssues(id, sc);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void assignIssue(Scanner sc) {
		// TODO Auto-generated method stub

		int choice = 0;
		do {
			System.out.println("Assign to Yourself(1) OR Assign to Others(2) or Exit(0);");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				AssigntoYou();
				break;
			case 2:
				assignToOther(sc);
				break;
			case 0:
				System.out.println("Exited!!");
				break;
			default:
				System.out.println("Invalid Selection, try again");
			}
		} while (choice != 0);
	}

	private static void assignToOther(Scanner sc) {
		// TODO Auto-generated method stub
		int id = 0;

		ICSRService csrService = new CSRimpl();
		try {
			csrService.assignToOther(id);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void AssigntoYou() {
		// TODO Auto-generated method stub
		ICSRService csrService = new CSRimpl();
		try {
			csrService.assignToYou();
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void ViewIssues() {
		// TODO Auto-generated method stub
		ICSRService csrService = new CSRimpl();

		csrService.ViewIssues();
	}

	private static void changePassword(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter Old Password");
		String op = sc.next();
		System.out.print("Enter New Password");
		String np = sc.next();
		ICSRService csrService = new CSRimpl();
		try {
			csrService.changePassword(op, np);
			;
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public static void CSRRegister(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter first name ");
		String fname = sc.next();
		System.out.print("Enter last name ");
		String lname = sc.next();
		System.out.print("Enter Email");
		String Email = sc.next();
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();

		CustomerSupportRepresentative csr = new CustomerSupportRepresentative(fname, lname, Email, username, password,
				1);

		ICSRService csrService = new CSRimpl();
		try {
			csrService.addCSR(csr);
		} catch (SomeThingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static void DELETE(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Are you sure you want to delete your account?[y/n] ");
		char choice = sc.next().toLowerCase().charAt(0);
		if (choice == 'y') {
			try {
				ICSRService customerService = new CSRimpl();
				customerService.deleteAccount();
				System.out.println("Its really sad to see you go, As per your request account is deleted");
			} catch (SomeThingWentWrongException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

}
