package com.bridgelabs.Master;

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

	EmployeeWageBuilder(CompanyWage Company) {

		this.companyName = Company.companyName;
		this.wagePerHour = Company.wagePerHour;
		this.maxWorkingDays = Company.maxWorkingDays;
		this.maxWorkingHours = Company.maxWorkingHours;
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

	public void calculateWagesTillCondition(CompanyWage Company) {

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

		Company.setTotalEmpWage(totalEmpWage);
		Company.setTotalEmpHrs(totalEmpHrs);
		Company.setTotalWorkingDays(totalWorkingDays);
		System.out.println();

	}

}