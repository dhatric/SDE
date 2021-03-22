package com.dhatric.strings;

public class LongestPalindromicSubString {

	public static void main(String args[]) {
		System.out.println(getLongestPalindrome("cbbd"));
	}

	public static String getLongestPalindrome(String input) {
		int maxLength = 0;
		int maxI = 0;
		int maxJ = 0;
		if (input == null) {
			return null;
		} else if (input.length() == 1) {
			return input;
		} else if (input.length() == 2 && input.charAt(0) == input.charAt(1)) {
			return input;
		}

		int memory[][] = new int[input.length()][input.length()];

		for (int i = 0; i < memory.length; i++) {
			memory[i][i] = 1;
		}

		for (int i = 0; i < memory.length - 1; i++) {
			int j = i + 1;
			if (input.charAt(i) == input.charAt(j)) {
				memory[i][j] = 1;
				if (j - i + 1 > maxLength) {
					maxLength = j - i + 1;
					maxI = i;
					maxJ = j;
				}
			}

		}

		for (int subStrLength = 3; subStrLength < input.length(); subStrLength++) {
			for (int i = 0; i <= input.length() - subStrLength; i++) {
				int j = i + subStrLength - 1;
				if (input.charAt(i) == input.charAt(j) && memory[i + 1][j - 1] == 1) {
					memory[i][j] = 1;
					if (j - i + 1 > maxLength) {
						maxLength = j - i + 1;
						maxI = i;
						maxJ = j;
					}
				}

			}

		}

		return input.substring(maxI, maxJ + 1);
	}

}
