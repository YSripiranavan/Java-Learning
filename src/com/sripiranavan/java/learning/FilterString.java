package com.sripiranavan.java.learning;

import java.util.Arrays;
import java.util.Scanner;

public class FilterString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any words separated by space: ");
		String userInput = sc.nextLine();
		System.out.print("Please, enter minumum word length to filter words: ");
		int minLength = sc.nextInt();

		String[] words = userInput.split("\\s+");
		String[] filteredWords = filterWordsByLength(minLength, words);
		System.out.println(Arrays.toString(filteredWords));
	}

	public static String[] filterWordsByLength(int minLength, String[] words) {
		String filterWords = "";
		for (String word : words) {
			int wordLenth = word.toCharArray().length;
			if (wordLenth >= minLength) {
				filterWords += word + ",";
			}
		}
		return filterWords.split(",");
	}
}
