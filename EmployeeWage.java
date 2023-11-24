package com.bridgelabs.Master;

public class EmployeeWage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Employee Wage  Computation Program");

		checkEmpPresentOrAbsent();

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

}
