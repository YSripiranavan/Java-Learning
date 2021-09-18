package com.sripiranavan.java.learning;

import java.util.Scanner;

public class RegexExpression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("Please, enter any text: ");
//		String userInput = sc.nextLine();
//		System.out.print("You entered these words: ");
//		System.out.println(Arrays.toString(userInput.split("\\s+|(?=\\p{Punct})|(?<=\\p{Punct})")));
		System.out.print("Please, enter any integer: ");
		String number = sc.nextLine();
		char[] numberArr = number.toCharArray();
		for(char num:numberArr) {
			System.out.println(num);
		}
	}

}
