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

		System.out.println("Enter the number of companies  : ");
		int companies = sc.nextInt();

		CompanyWage[] allcompany = new CompanyWage[companies];

		for (int i = 0; i < companies; i++) {
			System.out.println("Company Name : ");
			String companyName = sc.next();

			System.out.println("Enter wage per hour");
			int wagePerHour = sc.nextInt();

			System.out.println("Enter maximum working days");
			int maxWorkingDays = sc.nextInt();

			System.out.println("Enter maximum working hours");
			int maxWorkingHours = sc.nextInt();

			CompanyWage compwage = new CompanyWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);

			EmployeeWageBuilder employeeWage = new EmployeeWageBuilder(compwage);

			employeeWage.calculateWagesTillCondition(compwage);

			allcompany[i] = compwage;

		}

		// print the total wage for each company
		for (int i = 0; i < companies; i++) {
			System.out.println("Total wage for " + allcompany[i].companyName + " is " + allcompany[i].totalEmpWage);

		}

	}
}