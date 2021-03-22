package com.dhatric.strings;

public class PrintSubstring {

	static void printAllSubString(String inputStr) {
		for (int i = 0; i < inputStr.length(); i++) {
			for (int j = i; j < inputStr.length(); j++) {
				System.out.println(inputStr.substring(i, j + 1));
			}
		}
	}

	static void printAllSubStringLenghtWise(String inputStr) {
		int length = inputStr.length();
		for (int l = 1; l <= length; l++) {
			for (int i = 0; i < length - l + 1; i++) {
				int j = i + l;
				System.out.println(inputStr.substring(i, j ));
			}
		}

	}

	public static void main(String[] args) {
		printAllSubStringLenghtWise("hello");

	}

}
