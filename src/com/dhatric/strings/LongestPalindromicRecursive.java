package com.dhatric.strings;

public class LongestPalindromicRecursive {

	int lo, max;

	public String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		for (int i = 0; i < s.length() - 1; i++) {
			helper(i, i + 1, s);
			helper(i, i, s);
		}
		return s.substring(lo + 1, lo + max);
	}

	private void helper(int a, int b, String s) {
		while (a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b)) {
			a--;
			b++;
		}
		if (b - a > max) {
			lo = a;
			max = b - a;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
