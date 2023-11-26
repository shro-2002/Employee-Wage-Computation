package com.bridgelabs.Master;

import java.util.ArrayList;

public class CompanyWage {

	String companyName;
	int wagePerHour;
	int maxWorkingDays;
	int maxWorkingHours;
	int totalEmpWage;
	int totalEmpHrs;
	int totalWorkingDays;
	ArrayList<Integer> dailyWages;

	public CompanyWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.maxWorkingDays = maxWorkingDays;
		this.maxWorkingHours = maxWorkingHours;
		this.dailyWages = new ArrayList<>();
	}

	public void addDailyWage(int dailyWage) {
		dailyWages.add(dailyWage);
	}

	public void printDailyWages() {
		System.out.println("Daily wages for " + companyName + " are: ");
		for (int wages : dailyWages) {
			System.out.println(wages);
		}
	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}

	public void setTotalEmpHrs(int totalEmpHrs) {
		this.totalEmpHrs = totalEmpHrs;
	}

	public void setTotalWorkingDays(int totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}

}
