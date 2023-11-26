package com.bridgelabs.Master;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * @Class Variables: int, int, int
 * 
 * @Class Methods: checkEmpPresentOrAbsent(), calculateDailyEmployeeWage(), addPartTimeEmployeeAndWage(), solvingUsingSwitchCase(), calculateWagesForMonth(), calculateWagesTillCondition()
 * 
 * @Description: Calculating and Managing employee wages based on different conditions
 */

class EmployeeWageBuilder implements EmpWageBuilder {

//	Constants
	private final static int FULL_TIME = 1;
	private static final int PRESENT = 1;
	private static final int PART_TIME = 0;

	private ArrayList<CompanyWage> allCompanies;

	public EmployeeWageBuilder() {
		this.allCompanies = new ArrayList<>();
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

	// UC-4 : Solving using Switch Case Statement

	/*
	 * @params : None
	 * 
	 * @return : int[]
	 * 
	 * @Description : UC-4 Solving using Switch Case Statement
	 */

	public int[] solvingUsingSwitchCase(CompanyWage company) {

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

		int empWage = empHrs * company.wagePerHour;
		System.out.println("Employee Wage : " + empWage);
		empDetails[0] = empWage;
		empDetails[1] = empHrs;

		return empDetails;
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

		while (totalEmpHrs <= Company.maxWorkingHours && totalWorkingDays < Company.maxWorkingDays) {
			System.out.println("DAY: " + (totalWorkingDays + 1));
			empDetails = solvingUsingSwitchCase(Company);
			totalEmpWage += empDetails[0];
			totalEmpHrs += empDetails[1];
			Company.addDailyWage(empDetails[0]);

			totalWorkingDays++;

			System.out.println();

		}

		Company.setTotalEmpWage(totalEmpWage);
		Company.setTotalEmpHrs(totalEmpHrs);
		Company.setTotalWorkingDays(totalWorkingDays);
		System.out.println();

	}

	@Override
	public void addDetails(Scanner sc) {
		Scanner sc1 = new Scanner(System.in);

		System.out.println("Company Name : ");
		String companyName = sc1.next();

		System.out.println("Enter wage per hour");
		int wagePerHour = sc1.nextInt();

		System.out.println("Enter maximum working days");
		int maxWorkingDays = sc1.nextInt();

		System.out.println("Enter maximum working hours");
		int maxWorkingHours = sc1.nextInt();

		CompanyWage Company = new CompanyWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);

		allCompanies.add(Company);

	}

	@Override
	public void printWages() {

		for (CompanyWage company : allCompanies) {
			System.out.println("Company Name : " + company.companyName);
			System.out.println("Total Employee Wage : " + company.totalEmpWage);
			System.out.println("Total Employee Hours : " + company.totalEmpHrs);
			System.out.println("Total Working Days : " + company.totalWorkingDays);
			System.out.println("Daily Wages: " + company.dailyWages);
			System.out.println();

		}

	}

	@Override
	public void calculateWages() {
		for (CompanyWage company : allCompanies) {
			calculateWagesTillCondition(company);
		}

	}

}