package ocp.day1;

public class Example_Constructor {
//The constructor runs after all fields and instance initializer blocks have run;

	public void display() {
		System.out.println("Displayed name" + name);
	}

	String name = "firstName";

	public Example_Constructor() {
		//The constructor runs after all fields and instance initializer blocks have run;
		// value in the constructor overrides the initial value 
		name = "Anu";
	}

	public static void main(String[] args) {
		Example_Constructor d1 = new Example_Constructor();
		d1.display();
	}

}
