package com.bridgelabs.Master;

import com.bridgelabs.usecase1.Attendance;

public class EmployeeWage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Employee Wage  Computation Program");

		calculateDailyEmployeeWage();

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

}
