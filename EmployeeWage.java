package com.bridgelabs.Master;

import com.bridgelabs.usecase1.Attendance;
import com.bridgelabs.usecase4.SwitchCase;

public class EmployeeWage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Employee Wage  Computation Program");

		calculateWagesForMonth();

	}

	/*
	 * @ params : None
	 * 
	 * @ return : None
	 * 
	 * @Description : UC-1 Check Employee is Present or Absent
	 */

	public static int checkEmpPresentOrAbsent() {
		int PRESENT = 1;
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

	public static int calculateDailyEmployeeWage() {

		int attend = Attendance.checkEmpPresentOrAbsent();
		int full_time = 1;
		int wage_per_hour = 20;
		int empHrs = 0;
		int empWage = 0;

		if (attend == full_time)
			empHrs = 8;
		else
			empHrs = 0;

		empWage = empHrs * wage_per_hour;
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
	public static int addPartTimeEmployeeAndWage() {
		int part_time;
		int full_time, present;
		int wage_per_hour = 20;
		int empHrs = 0;
		int empWage = 0;
		int attend = Attendance.checkEmpPresentOrAbsent();

		part_time = 0;
		full_time = present = 1;

		int time = RandomGenerator.employee_type();

//		If employee present
		if (attend == present)

		{
//			Part time
			if (time == part_time) {
				empHrs = 4;
				System.out.println("Employee is Part Time");
			}
//			Full-time
			else if (time == full_time) {
				empHrs = 8;
				System.out.println("Employee is Full Time");
			}
		}
//			If absent

		else
			empHrs = 0;

		empWage = empHrs * wage_per_hour;
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

	public static int[] solvingUsingSwitchCase() {
		int part_time;
		int full_time;
		int wage_per_hour = 20;
		int empHrs = 0;
		int empWage = 0;
		int attend = Attendance.checkEmpPresentOrAbsent();

		int[] empDetails = new int[2];

		part_time = 0;
		full_time = 1;

		int time = RandomGenerator.employee_type();

		switch (attend) {
		case 1:
			if (time == part_time) {
				empHrs = 4;
				System.out.println("Employee is Part Time");
			} else if (time == full_time) {
				empHrs = 8;
				System.out.println("Employee is Full Time");
			}
			break;
		default:
			empHrs = 0;
			System.out.println("Employee is Absent");
		}

		empWage = empHrs * wage_per_hour;
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

	public static void calculateWagesForMonth() {

		int NUM_OF_WORKING_DAYS = 20;

		int totalEmpWage = 0;

		int[] empDetails = new int[2];

		for (int day = 0; day < NUM_OF_WORKING_DAYS; day++) {
			System.out.println(day + 1);
			empDetails = SwitchCase.solvingUsingSwitchCase();
			totalEmpWage += empDetails[0];

		}
		System.out.println("Total Employee Wage : " + totalEmpWage);
	}

}
