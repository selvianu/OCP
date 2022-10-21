package cys.training;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter roll Number");
		int rollNo = s.nextInt();
		System.out.println("Your rollNo is : " + rollNo);
		System.out.println("Enter your name");
		String name = s.next();
		// System.out.println("Enter last name");
		// String lastName = s.nextLine();//
		// System.out.println(name);

		System.out.println("Enter mark1");

		int mark1 = s.nextInt();
		if ((mark1 > 0) && (mark1 <= 100)) {
			System.out.println("Enter mark2");
			int mark2 = s.nextInt();
			if (mark2 > 0) {
				if (mark2 <= 100) {
					System.out.println("mark2 : " + mark2);
				} else {
					System.out.println("marks cant be more than 100");
				}
			} else {
				System.out.println("Marks cant be negative value");
			}

		}

		else {
			System.out.println("enter valid marks");
		}

		System.out.println("Enter mark3");
		int mark3 = s.nextInt();
		// System.out.println("Marks : " + mark1 + "mark2 : " + mark2 + "Mark3 : " +
		// mark3);

	}

}
