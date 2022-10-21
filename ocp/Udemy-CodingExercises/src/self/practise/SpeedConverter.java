package self.practise;

public class SpeedConverter {

	public static void main(String[] args) {
		System.out.println(toMilesPerHour(1.5));
		System.out.println(toMilesPerHour(10.25));
		System.out.println(toMilesPerHour(-5.6));
		printConversion(10.25);
		printConversion(-5.6);
		printConversion(75.114);
		printConversion(95.75);

	}

	public static long toMilesPerHour(double kilometersPerHour) {
		if (kilometersPerHour < 0)
			return -1;
		else
			return Math.round(kilometersPerHour);
	}

	public static void printConversion(double kilometersPerHour) {
		if (kilometersPerHour < 0)
			System.out.println("Invalid Value");
		else {
			long milesPerHour2 = toMilesPerHour(kilometersPerHour);
			System.out.println("Rounded value : "+milesPerHour2);
			double milesPerHour = Math.round(milesPerHour2 * 0.621371192);
			System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
		}

	}

}
