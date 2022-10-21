package cys.training;

import java.util.Iterator;

public class PlanDay1 {

	public static void main(String args[]) {
		// public static void main(String [] args) {

		int no = 23;
		// int no1 = 23456789876;// The literal 23456789876 of type int is out of range
		long no1 = 345l;
		double no2 = 345.32d;
		// array declaration
		int studentRollNo[] = new int[5];
		studentRollNo[0] = 13;
		studentRollNo[1] = 45;
		int studentRollNumber[] = new int[] { 34, 65, 424 };

		for (int i = 0; i <= studentRollNo.length; i++) {
			System.out.println(studentRollNo[i]);
		}

		System.out.println("Hello World" + no2);
	}

}
