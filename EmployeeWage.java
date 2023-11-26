package com.bridgelabs.Master;

import java.util.Scanner;

/*
 * @Class Variables: None
 * 
 * @Class Methods: Main Method
 * 
 * @Description: Main Method to call the methods of EmployeeWage class
 */

public class EmployeeWage {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//	

		System.out.println("Welcome to Employee Wage Computation Program");
		int choice = 0;

		while (true) {
			System.out.println("1. Calculate Wages for the Company");
			System.out.println("2. Exit");

			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Company Name : ");
				String companyName = sc.next();

				System.out.println("Enter wage per hour");
				int wagePerHour = sc.nextInt();

				System.out.println("Enter maximum working days");
				int maxWorkingDays = sc.nextInt();

				System.out.println("Enter maximum working hours");
				int maxWorkingHours = sc.nextInt();

				EmployeeWageBuilder employeeWage = new EmployeeWageBuilder(companyName, wagePerHour, maxWorkingDays,
						maxWorkingHours);

				employeeWage.calculateWagesTillCondition();
				break;
			case 2:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}