package self.practise;

public class BarkingDog {

	public static void main(String[] args) {
		System.out.println(shouldWakeUp(true, 1));
		System.out.println(shouldWakeUp(false, 2));
		System.out.println(shouldWakeUp(true, 8));
		System.out.println(shouldWakeUp(true, 23));

	}

	public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		if (isBarking) {
			if ((hourOfDay >= 0) && (hourOfDay <=23)) {
				if ((hourOfDay < 8) || (hourOfDay > 22))
					return true;
				else
					return false;
			}
			return false;
		}
		return false;
	}

}
