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

		System.out.println("Welcome to Employee Wage Computation Program");

		System.out.println("Enter the number of companies  : ");
		int companies = sc.nextInt();

		EmployeeWageBuilder employeeWage = new EmployeeWageBuilder();

// 			Input the Company details 
		for (int i = 0; i < companies; i++) {

			System.out.println("Enter details for company " + (i + 1));
			employeeWage.addDetails(sc);

		}

		employeeWage.calculateWages();

		// print the total wage for each company

		employeeWage.printWages();

	}
}