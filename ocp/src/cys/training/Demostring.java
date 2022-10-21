package cys.training;

import java.util.stream.IntStream;

public class Demostring {

	public static void main(String[] args) {

		String name1 = "Anu  radha";// memory in String pool
		IntStream chars = name1.chars();
		// System.out.println(chars);
		int count = name1.codePointCount(0, 6);
		System.out.println(count);

		//when string is created is new keyword - memory is occupied in Heap
		String name2 = new String("AnuPriya");
		System.out.println(name2.isEmpty());
		
		
	}

}
