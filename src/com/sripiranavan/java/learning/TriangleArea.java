package com.sripiranavan.java.learning;

import java.util.Scanner;

public class TriangleArea {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Calculate the Triangle Area");
			System.out.println("Enter the first side length:");
			int sideA = sc.nextInt();
			System.out.println("Enter the second side length:");
			int sideB = sc.nextInt();
			System.out.println("Enter the third side length:");
			int sideC = sc.nextInt();

			double s = (sideA + sideB + sideC) / 2;
			double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
			System.out.println("Triangle Area: " + area);
		}

	}

}
