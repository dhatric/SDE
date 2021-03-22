package com.dhatric.strings;

public class AlmostPalandrome {

	public static void main(String[] args) {
		 System.out.println(validPalindrome("eedede",false));

	}

	public static boolean validPalindrome(String s, boolean subString) {
		if (s == null) {
			return false;
		} else if (s.length() == 1) {
			return true;
		}
		s = s.toLowerCase();
		int midStart = 0;
		int midEnd = 0;

		if (s.length() % 2 == 0) {
			midStart = (s.length() / 2) - 1;
			midEnd = s.length() / 2;
		} else {
			midStart = s.length() / 2;
			midEnd = s.length() / 2;
		}

		// System.out.println(midStart+" "+midEnd);
		System.out.println(s);
		while (midStart >= 0 && midEnd < s.length()) {
			if (s.charAt(midStart) == s.charAt(midEnd)) {
				midStart--;
				midEnd++;
			} else {

				if (subString) {
					return false;
				}
				String sWithoutMidStart = getStringWithoutIndex(s, midStart);
				String sWithoutMidEnd = getStringWithoutIndex(s, midEnd);
				if (validPalindrome(sWithoutMidStart, true) || validPalindrome(sWithoutMidEnd, true)) {
					return true;
				}else {
					return false;
				}

			}

		}

		return true;
	}

	public static String getStringWithoutIndex(String input, int index) {
		char[] output = new char[input.length() - 1];
		int outputIndex = 0;

		for (int i = 0; i < input.length(); i++) {
			if (i != index) {
				output[outputIndex++] = input.charAt(i);
			}
		}
		return String.valueOf(output);
	}

}
