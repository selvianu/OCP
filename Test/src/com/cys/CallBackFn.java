package com.cys;

public class CallBackFn {

	public static void main(String[] args) {
		add(3, 4);
	}

	public static void add(int a, int b,  display) {
		int c = a + b;
		System.out.println(c);
		display();
	}

	public static void display() {
		System.out.println("welcome....");
	}
}
