package self.practise;

/*
 * Teen Number Checker
We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
Write a method named hasTeen with 3 parameters of type int.
The method should return boolean and it needs to return true if one of the parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return false.
Write another method named isTeen with 1 parameter of type int.
The method should return boolean and it needs to return true if the parameter is in range 13(inclusive) - 19 (inclusive). Otherwise return false.
 * 
 */
public class TeenNumberChecker {

	public static void main(String[] args) {
		System.out.println(hasTeen(-9, 99, 9));
		System.out.println(hasTeen(23, 15, 42));
		System.out.println(hasTeen(22, 23, 34));
		System.out.println(isTeen(9));
		System.out.println(isTeen(14));
	}

	public static boolean hasTeen(int person1Age, int person2Age, int person3Age) {
		if (((person1Age >= 13) && (person1Age <= 19)) || ((person2Age >= 13) && (person2Age <= 19))
				|| ((person3Age >= 13) && (person3Age <= 19)))
			return true;

		else
			return false;
	}

	public static boolean isTeen(int person1Age) {
		if ((person1Age >= 13) && (person1Age <= 19))
			return true;
		else
			return false;
	}
}
