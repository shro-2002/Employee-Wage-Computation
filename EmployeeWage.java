package com.bridgelabs.Master;

import java.util.Scanner;

/*
 * @Class Variables: int, int, int
 * 
 * @Class Methods: checkEmpPresentOrAbsent(), calculateDailyEmployeeWage(), addPartTimeEmployeeAndWage(), solvingUsingSwitchCase(), calculateWagesForMonth(), calculateWagesTillCondition()
 * 
 * @Description: Calculating and Managing employee wages based on different conditions
 */
class EmployeeWageBuilder {

//	Constants
	private final static int FULL_TIME = 1;
	private static final int PRESENT = 1;
	private static final int PART_TIME = 0;

//	Instance Variables
	private final String companyName;
	private final int wagePerHour;
	private final int maxWorkingDays;
	private final int maxWorkingHours;

	/*
	 * @params : String, int, int, int
	 * 
	 * @return : None
	 * 
	 * @Description : Parameterized Constructor
	 */

	EmployeeWageBuilder(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {

		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.maxWorkingDays = maxWorkingDays;
		this.maxWorkingHours = maxWorkingHours;
	}

	/*
	 * @ params : None
	 * 
	 * @ return : None
	 * 
	 * @Description : UC-1 Check Employee is Present or Absent
	 */

	public static int checkEmpPresentOrAbsent() {

		int empCheck = RandomGenerator.generateattendance();

		if (empCheck == PRESENT)
			System.out.println("Employee is Present");
		else
			System.out.println("Employee is Absent");

		return empCheck;
	}

	/*
	 * @params : None
	 * 
	 * @return : int
	 * 
	 * @Description : UC-2 Calculate Daily Employee Wage
	 */

	public static int calculateDailyEmployeeWage(int wagePerHour) {

		int attend = checkEmpPresentOrAbsent();

		int empHrs = (attend == PRESENT) ? 8 : 0;

		int empWage = empHrs * wagePerHour;
		System.out.println("Employee Wage : " + empWage);
		return empWage;

	}

	// UC-3 : Add Part Time Employee and Wage

	/*
	 * @params : None
	 * 
	 * @return : int
	 * 
	 * @Description : UC-3 Add Part Time Employee and Wage
	 */
	public int addPartTimeEmployeeAndWage() {

		int empHrs = 0;

		int attend = checkEmpPresentOrAbsent();

		int time = RandomGenerator.employee_type();

//			If employee present
		if (attend == PRESENT)

		{
//				Part time
			if (time == PART_TIME) {
				empHrs = 4;
				System.out.println("Employee is Part Time");
			}
//				Full-time
			else if (time == FULL_TIME) {
				empHrs = 8;
				System.out.println("Employee is Full Time");
			}
		}
//				If absent

		else
			empHrs = 0;

		int empWage = empHrs * wagePerHour;
		System.out.println("Employee Wage : " + empWage);
		return empWage;
	}

	// UC-4 : Solving using Switch Case Statement

	/*
	 * @params : None
	 * 
	 * @return : int[]
	 * 
	 * @Description : UC-4 Solving using Switch Case Statement
	 */

	public int[] solvingUsingSwitchCase() {

		int attend = checkEmpPresentOrAbsent();
		int empHrs = 0;

		int[] empDetails = new int[2];

		int time = RandomGenerator.employee_type();

		switch (attend) {
		case 1:
			if (time == PART_TIME) {
				empHrs = 4;
				System.out.println("Employee is Part Time");
			} else if (time == FULL_TIME) {
				empHrs = 8;
				System.out.println("Employee is Full Time");
			}
			break;
		default:
			empHrs = 0;
			System.out.println("Employee is Absent");
		}

		int empWage = empHrs * wagePerHour;
		System.out.println("Employee Wage : " + empWage);
		empDetails[0] = empWage;
		empDetails[1] = empHrs;

		return empDetails;
	}

	// UC-5 Calculating Wages for a Month Assume 20 Working Day per Month

	/*
	 * @params : void
	 * 
	 * @return : void
	 * 
	 * @Description : UC-5 Calculating Wages for a Month
	 */

	public void calculateWagesForMonth() {

		int totalEmpWage = 0;

		int[] empDetails = new int[2];

		for (int day = 0; day < maxWorkingDays; day++) {
			System.out.println(day + 1);
			empDetails = solvingUsingSwitchCase();
			totalEmpWage += empDetails[0];

		}
		System.out.println("Total Employee Wage : " + totalEmpWage);
	}

	// UC-6 : Calculate Wages till a condition of total working hours or days is
	// reached for a month

	/*
	 * @params : String, int, int, int
	 * 
	 * @return : None
	 * 
	 * @Description : UC-6 Calculate Wages till a condition of total working hours
	 * or days is reached for a month
	 */

	public void calculateWagesTillCondition() {

		int totalEmpHrs, totalWorkingDays, totalEmpWage;
		totalEmpHrs = totalWorkingDays = totalEmpWage = 0;

		int[] empDetails = new int[2];

		while (totalEmpHrs <= maxWorkingHours && totalWorkingDays < maxWorkingDays) {
			System.out.println("DAY: " + (totalWorkingDays + 1));
			empDetails = solvingUsingSwitchCase();
			totalEmpWage += empDetails[0];
			totalEmpHrs += empDetails[1];

			totalWorkingDays++;

			System.out.println();

		}
		System.out.println("Company Name : " + companyName);
		System.out.println("Total Employee Wage : " + totalEmpWage);
		System.out.println("Total Working hours : " + totalEmpHrs);
		System.out.println("Total Working days : " + totalWorkingDays);
		System.out.println();

	}

}

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