package com.sripiranavan.java.learning;

import java.util.Arrays;
import java.util.Scanner;

public class Pramid {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Please, enter height of the pyramid: ");
//		int height = sc.nextInt();
//		for (int i = 0; i < height; i++) {
//			for (int j = 0; j < height; j++) {
//				if (i >= j) {
//					System.out.printf("*");
//				}
//			}
//			System.out.println();
//		}
//		for (int i = 0; i < height; i++) {
//			for (int j = 0; j < height; j++) {
//				if (i < j) {
//					System.out.printf("*");
//				}
//			}
//			System.out.println();
//		}
//		int[][] matrix = {
//				{1, 2, 3, 4, 5,},
//				{6, 7},
//				{8, 9, 10}
//		};
//		
//		for(int[] mat:matrix){
//		    for(int i:mat){
//		        System.out.printf("%d",i);
//		    }
//		    System.out.println();
//		}

		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter integer numbers separated by space: ");
		String line = sc.nextLine();
		String[] numbers = line.split(" ");
		int[] intArray = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			intArray[i] = Integer.parseInt(numbers[i]);
		}
		int maxInt = findMaxIntInArray(intArray);
		System.out.println("*** Initial Array ***");
		System.out.println(Arrays.toString(intArray));
		System.out.println("*** Max number in array ***");
		System.out.println(maxInt);
	}

	public static int findMaxIntInArray(int[] intArray) {
		int largeNumber = 0;
		for(int num:intArray) {
			if (num > largeNumber) {
				largeNumber = num;
			}
		}
		return largeNumber;
	}
}
