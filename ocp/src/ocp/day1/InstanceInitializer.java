package ocp.day1;

public class InstanceInitializer {
//Fields and instance initializer blocks are run in the order in which they appear in the file;

	public static void main(String[] args) {

		// new InstanceInitializer();

		{
			System.out.println("inside main");

		}
		new InstanceInitializer();

	}

	{
		System.out.println("InstanceInitializer");

	}

}
