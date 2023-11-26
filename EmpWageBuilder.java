package com.bridgelabs.Master;

import java.util.Scanner;

public interface EmpWageBuilder {

	CompanyWage addDetails(Scanner sc);
	void printWages(CompanyWage[] allcompany, int companies);

}
