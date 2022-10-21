package cys.training;

public class Example_Variable {

	public void display() {
		String name = "ram";// Local Variable
		System.out.println(name);
	}

	public void displays() {
		// static variable is also class variable
		String address = "Chennai";
	}

	public static void main(String args[]) {
		Example_Variable e = new Example_Variable();
		e.display();
		System.out.println();
	}
}
