package com.sripiranavan.java.learning;

import java.util.Scanner;

public class RotateMatrix {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Please, enter matrix size: ");
			int size = sc.nextInt();
			double[][] matrix = generateMatrix(size);

			System.out.println("How you want to rotate matrix:" + System.lineSeparator() + "\t1 - 90"
					+ System.lineSeparator() + "\t2 - 180" + System.lineSeparator() + "\t3 - 270");
			int mode = sc.nextInt();

			System.out.println(System.lineSeparator() + "Base matrix:" + System.lineSeparator());
			printMatrixToConsole(matrix);
			System.out.println();
		}
	}

	public static void printMatrixToConsole(double[][] matrix) {
		rotate90(matrix);
	}
	
	public static void rotate90(double[][] matrix) {
		
	}
	
	public static double[][] generateMatrix(int size) {
		double[][] matrix = new double[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				double num = (double) i + (0.1 * j);
				System.out.printf("%.1f ", num);
			}
			System.out.println();
		}

		return matrix;
	}

}
