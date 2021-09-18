package com.sripiranavan.java.learning;

import java.util.Scanner;

public class CircleCircumference {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Calculate the Circle Circumference");
			System.out.println("Enter the radius of the circle");
			double r = sc.nextDouble();

			double circumference = 2 * Math.PI * r;
			System.out.println("Circle Circumference is " + circumference);
		}
	}
}
