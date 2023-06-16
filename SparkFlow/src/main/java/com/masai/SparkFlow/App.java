package com.masai.SparkFlow;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. CustomerSupportRepresentative Login");
			System.out.println("2. CustomerSupportRepresentative Registration");
			System.out.println("3. Customer Login");
			System.out.println("4. Customer Registration");
			System.out.println("0. Exit");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				CSRLogin(sc);
				break;
			case 2:
				CSRRegister(sc);
				break;
			case 3:
				CustomerUI.userLogin(sc);
				break;
			case 4:
				CustomerUI.customerRegistration(sc);
				break;	
			case 0:
				System.out.println("Thanks for using the services");
				break;
			default:
				System.out.println("Invalid Selection, try again");
			}
		} while (choice != 0);
		sc.close();
	}

	private static void CSRRegister(Scanner sc) {
		
		
	}

	private static void CSRLogin(Scanner sc) {
		
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}

	static void displayAdminMenu() {
		System.out.println("1. Add Insurance Company");
		System.out.println("2. View All Insurance Companies");
		System.out.println("3. Update Insurance Company Details");
		System.out.println("4. Add Insurance Plan");
		System.out.println("5. View All Insurance Plan");
		System.out.println("6. Update Insurance Plan");
		System.out.println("7. Update premium for an age band of a plan");
		System.out.println("8. See List of all Customers");
		System.out.println("9. See policy reports");
		System.out.println("10. Make Policies Discountinued");
		System.out.println("0. Logout");
	}
	
	private static void adminMenu(Scanner sc) {
		// TODO Auto-generated method stub
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
//    				CSRui.addCompany(sc);
    				break;
    			case 2:
//    				CSRui.viewCompanies();
    				break;
    			case 3:
//    				CSRui.updateCompanyDetails(sc);
    				break;
    			case 4:
//    				CSRui.addPlan(sc);
    				break;
    			case 5:
//    				CSRui.viewPlan();
    				break;
    			case 6:
//    				CSRui.updatePlan(sc);
    				break;
    			case 7:
//    				CSRui.updatePremiumAndSurcharge(sc);
    				break;
    			case 8:
//    				CSRui.viewAllCustomers();
    				break;
    			case 9:
//    				CSRui.viewPolicyReport();
    				break;
    			case 10:
//    				CSRui.makePoliciesDiscontinued();
    				break;
    			case 0:
    				System.out.println("Bye Bye Admin");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
}
