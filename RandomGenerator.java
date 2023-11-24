package com.bridgelabs.Master;

public class RandomGenerator {
	
	public static int generateattendance() {
		return (int) Math.floor(Math.random() * 10) % 2;
	}

	public static int employee_type() {
		return (int) Math.floor(Math.random() * 10) % 2;
	}

}
