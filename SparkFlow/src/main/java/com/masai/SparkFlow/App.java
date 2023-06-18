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
			System.out.println("WELCOME TO SPARKFLOW");
			System.out.println("1. CustomerSupportRepresentative Login");
			System.out.println("2. CustomerSupportRepresentative Registration");
			System.out.println("3. Customer Login");
			System.out.println("4. Customer Registration");
			System.out.println("0. Exit");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				CSRui.CSRLogin(sc);
				break;
			case 2:
				CSRui.CSRRegister(sc);
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

	
	
	
}
