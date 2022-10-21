package self.practise;

public class ExampleOverLoading {

	public static void main(String[] args) {
		calcFeetAndInchesToCentimeters(6, 6);
	}

	public static int calcFeetAndInchesToCentimeters(int feet, int inches) {
		if ((feet > 0)) {
			if ((inches <= 12) && (inches > 0)) {
				double feetToCM = feet * 30.48;
				double incToCm = inches * 2.54;
				System.out.println(feetToCM + "  " + incToCm);

			} else
				return -1;
		}
		return inches;

	}
}
