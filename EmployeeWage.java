package com.bridgelabs.Master;

/*
 * @Class Variables: 6
 * 
 * @Class Methods: 7
 * 
 * @Description: Calculating and Managing employee wages based on different conditions
 */

public class EmployeeWage {

	private final static int FULL_TIME = 1;
	private static final int PRESENT = 1;
	private static final int WAGE_PER_HOUR = 20;
	private static final int PART_TIME = 0;
	private static final int NUM_OF_WORKING_DAYS = 20;
	private static final int MAX_WORKING_HRS = 100;

	public static void main(String[] args) {

		System.out.println("Welcome to Employee Wage  Computation Program");
		calculateWagesTillCondition();

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

	public static int calculateDailyEmployeeWage() {

		int attend = checkEmpPresentOrAbsent();

		int empHrs = (attend == PRESENT) ? 8 : 0;

		int empWage = empHrs * WAGE_PER_HOUR;
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

		int empWage = empHrs * WAGE_PER_HOUR;
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

		int empWage = empHrs * WAGE_PER_HOUR;
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

		int totalEmpWage = 0;

		int[] empDetails = new int[2];

		for (int day = 0; day < NUM_OF_WORKING_DAYS; day++) {
			System.out.println(day + 1);
			empDetails = solvingUsingSwitchCase();
			totalEmpWage += empDetails[0];

		}
		System.out.println("Total Employee Wage : " + totalEmpWage);
	}

	// UC-6 : Calculate Wages till a condition of total working hours or days is
	// reached for a month

	/*
	 * @params : None
	 * 
	 * @return : None
	 * 
	 * @Description : UC-6 Calculate Wages till a condition of total working hours
	 * or days is reached for a month
	 */

	public static void calculateWagesTillCondition() {

		int totalEmpHrs, totalWorkingDays, totalEmpWage;

		totalEmpHrs = totalWorkingDays = totalEmpWage = 0;

		int[] empDetails = new int[2];

		while (totalEmpHrs <= MAX_WORKING_HRS && totalWorkingDays < NUM_OF_WORKING_DAYS) {
			System.out.println("DAY: " + (totalWorkingDays + 1));
			empDetails = solvingUsingSwitchCase();
			totalEmpWage += empDetails[0];
			totalEmpHrs += empDetails[1];

			totalWorkingDays++;

			System.out.println();

		}

		System.out.println("Total Employee Wage : " + totalEmpWage);
		System.out.println("Total Working hours : " + totalEmpHrs);
		System.out.println("Total Working days : " + totalWorkingDays);

	}

}
