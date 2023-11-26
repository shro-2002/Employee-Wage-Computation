package com.bridgelabs.Master;

public class CompanyWage {

	String companyName;
	int wagePerHour;
	int maxWorkingDays;
	int maxWorkingHours;
	int totalEmpWage;
	int totalEmpHrs;
	int totalWorkingDays;

	public CompanyWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.maxWorkingDays = maxWorkingDays;
		this.maxWorkingHours = maxWorkingHours;
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
