package cys.venkattraining.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Lessons {
	public void LessonA() {
		List<Phone> phonelist = new ArrayList<Phone>();
		Phone.print();
		// Phone::print;//direct calling method reference , not working
		phonelist.add(new Phone());
		phonelist.add(new Phone());
		phonelist.add(new Phone());
		phonelist.add(new Phone());
		phonelist.add(new Phone());
		phonelist.forEach(System.out::println);// calls toString() for all above above
	}

	public void LessonB() {
		List<Long> phoneNumbers = new ArrayList<Long>();
		phoneNumbers.add(12367899999876l);
		phoneNumbers.add(1876567878l);
		phoneNumbers.add(78945678l);
		phoneNumbers.add(678987654345678l);
		phoneNumbers.add(145678900987l);
		// Classname::nethod name to use static method
		// phoneNumbers.forEach(Phone::makeCalls);//static method used method reference
		Phone phone = new Phone();
		// Objectname::method to use non-static method
		phoneNumbers.forEach(phone::makeCalls);// non static method using object reference
	}

//Constructor reference
	public void LessonC() {
		PhoneEmpty mobileA = Phone::new;// constructor reference
		Phone firstPhone = mobileA.get();// factory method
		firstPhone.makeCalls(456789765l);
		PhoneWithNumberAndModel mobileB = Phone::new;
		Phone secondPhone = mobileB.get(567887643456l, "Readlme");// factory method
		secondPhone.makeCalls(999999999999l);
		System.out.println(secondPhone.toString());
	}

	public static void testD() {
		Map<Long, String> phoneMap = new HashMap<Long, String>();
		phoneMap.put(56788678L, "samsung");
		phoneMap.put(2346678L, "vivo");
		phoneMap.put(9878767L, "readlme");
		phoneMap.put(5678912345L, "oppo");
		phoneMap.put(987643456L, "nokia");
		Stream<Long> stream = phoneMap.keySet().stream();
		Phone[] phoneArray = stream.map(Phone::new).toArray(Phone[]::new);
		/*
		 * int length = phoneArray.length; for (int i = 0; i < length; i++) {
		 * System.out.println(phoneArray[i]); }
		 */
		Arrays.stream(phoneArray).forEach(System.out::println);

	}
}

//2interface//functional interface for non parameterized constructor
//interface to match default constructor SMA
interface PhoneEmpty {
	Phone get();
}

//functional interface for parameterized constructor
//interace to match parameter constructor
interface PhoneWithNumberAndModel {
	Phone get(long number, String modelName);
}

class Phone {
	private long number;
	private String modelName;

	public Phone(long number) {
		this.number = number;
		this.modelName = "yet to assign";
		System.out.println(number);
	}

//Default Constructor
	public Phone() {
		System.out.println("Default Constructor");
	}

//Parametrised constructor
	public Phone(long number, String modelName) {
		this.number = number;
		this.modelName = modelName;
		System.out.println(number + modelName);
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	// There can be only one public class - provided many classess
	public void makeCalls(long number) {
		System.out.println("call me.." + number);
	}

	public static void print() {
		System.out.println("print document");
	}

	public String toString() {
		System.out.println();
		return this.number + "" + this.modelName;
	}
}
