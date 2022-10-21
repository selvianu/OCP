package self.practise;

import java.text.DecimalFormat;

public class DecimalComparator {

	public static void main(String[] args) {
		System.out.println(areEqualByThreeDecimalPlaces(3.1752, 3.1751));
	}

	public static boolean areEqualByThreeDecimalPlaces(Double num1, double num2) {
	//	final DecimalFormat df = new DecimalFormat("0.000");
		

	//	String dnum1 = df.format(num1);
	//	String dnum2 = df.format(num2);
		String fnum1 = String.format("%.3f", num1);
		String fnum2 = String.format("%.3f", num2);

		if (fnum1 == fnum2)
			return true;
		else
			return false;

	}
}
