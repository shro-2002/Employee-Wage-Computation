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

			System.out.println("Enter details for company " + (i + 1));
			EmployeeWageBuilder employeeWage = new EmployeeWageBuilder();
			allcompany[i] = employeeWage.addDetails(sc);
			employeeWage.calculateWagesTillCondition(allcompany[i]);

		}

		// print the total wage for each company
		EmployeeWageBuilder employeeWage = new EmployeeWageBuilder();
		employeeWage.printWages(allcompany, companies);

	}
}