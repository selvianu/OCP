package cys.training.java8;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {

	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<>();
		
		for (Integer integer : integerList) {
			integerList.add(integer);

		}

		// integerList.forEach(System.out::print);
	}

}
