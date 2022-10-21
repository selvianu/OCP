package self.practise;

public class MinutesToYearsDaysCalculator {

	public static void main(String[] args) {
		printYearsAndDays(525600);
		printYearsAndDays(561600);
		printYearsAndDays(1051200);
	}

	public static void printYearsAndDays(long minutes) {
		if (minutes < 0)
			System.out.println("Invalid Value");
		else {
			long yearDays = minutes / (60 * 24);
			// yearDays/365;
			System.out.println(minutes + " min = "+(yearDays / 365) + " y and " + yearDays % 365 + " d");
		}
	}
}
