# Employee Wage Computation Program

Welcome to the Employee Wage Computation Program!

## Overview

This Java program manages the computation of employee wages for multiple companies based on various conditions. It provides functionalities such as checking employee presence, calculating daily employee wage, handling part-time employees, and more.

## Use Cases

### 1. UC_1_Check_Employee_IS_Present_Or_Absent

This use case involves checking whether an employee is present or absent. The method `EmployeeWageBuilder.checkEmpPresentOrAbsent()` generates a random value (0 or 1) to simulate employee attendance and prints whether the employee is present or absent.

### 2. UC_2_Calculate_Daily_Employee_Wage

In this use case, the program calculates the daily employee wage. The method `EmployeeWageBuilder.solvingUsingSwitchCase()` uses a switch case statement to determine whether the employee is full-time or part-time and calculates the wage accordingly.

### 3. UC_3_Add_Part_Time_Employee_and_Wage

This use case extends the functionality to include part-time employees. Similar to UC_2, the method `EmployeeWageBuilder.solvingUsingSwitchCase()` now handles part-time employees by assigning appropriate working hours and calculating the wage.

### 4. UC_4_Solving_using_Switch_Case_Statement

The program uses a switch case statement to solve the logic for determining the type of employee (full-time or part-time) in the method `EmployeeWageBuilder.solvingUsingSwitchCase()`.

### 5. UC-5_Calculating_Wages_for_a_Month

This use case calculates the wages for a month. The method `EmployeeWageBuilder.calculateWagesTillCondition()` iterates through days until either the total working hours or the maximum working days are reached, calculating daily wages and updating company details.

### 6. UC-6_Calculate_Wages_till_a_condition

Similar to UC-5, this use case calculates wages until a condition (total working hours or days) is met. The method `EmployeeWageBuilder.calculateWagesTillCondition()` iterates through days, calculates daily wages, and updates company details.

### 7. UC_7_Refactor_the_Code

Refactor the code for improved structure and readability. This use case focuses on maintaining clean and organized code by applying best practices and adhering to coding conventions.

### 8. UC_8_Compute_Employee_Wage_for_multiple_companies

The program can now compute employee wages for multiple companies. The methods `EmployeeWageBuilder.addDetails()` and `EmployeeWageBuilder.calculateWages()` allow users to input details for multiple companies and calculate wages accordingly.

### 9. UC_9_save_the_TotalWage_for_Each_Company

This use case involves saving the total wage for each company. The method `CompanyWage.setTotalEmpWage()` sets the total employee wage for a specific company.

### 10. UC_10_Manage_Employee_Wage_of_multiple_companies

Building on UC_8, this use case enables users to manage employee wages for multiple companies. The methods `EmployeeWageBuilder.addDetails()` and `EmployeeWageBuilder.calculateWages()` allow users to input details for and calculate wages for multiple companies.

### 11. UC_11_Manage_Employee_Wage_of_multiple_companies_using_Interface

Introduces the use of an interface (`EmpWageBuilder`) to manage employee wages for multiple companies. The interface includes methods such as `addDetails()`, `calculateWages()`, and `getTotalWageByCompany()`.

### 12. UC_12_Refactor_Using_ArrayLists

Refactors the code to use ArrayLists for managing details of multiple companies. The class `EmployeeWageBuilder` now uses an `ArrayList<CompanyWage>` to store information about different companies.

### 13. UC_13_Store_Daily_Wages

Enhances the program to store daily wages for each company. The method `CompanyWage.addDailyWage()` is responsible for adding daily wages to the list of daily wages for a specific company.

### 14. UC_14_Query_Total_Wages
This use case allows querying the total wages for a specific company. The method `EmpWageBuilder.getTotalWageByCompany()` retrieves the total wage for a given company.



## Program Structure

- **EmployeeWageBuilder.java:** Contains the main logic for computing employee wages.
- **CompanyWage.java:** Represents details for each company, including daily wages.

### RandomGenerator.java

Utility class for generating random values related to employee details.

### EmpWageBuilder.java

Interface for managing employee wages for different companies.

