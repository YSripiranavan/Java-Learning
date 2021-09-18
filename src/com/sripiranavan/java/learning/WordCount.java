package com.sripiranavan.java.learning;

import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any text: ");
		String line = sc.nextLine();
		int amountOfWords = getWordsAmount(line);

		System.out.println("Amount of words in your text: " + amountOfWords);
	}

	public static int getWordsAmount(String text) {
		String[] wordArr = text.split("[\\s,]+");
		return wordArr.length;
	}

}
