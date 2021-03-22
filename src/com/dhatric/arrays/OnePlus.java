package com.dhatric.arrays;

public class OnePlus {

	public static void main(String[] args) {
		plusOneM(new int[] {1,2,3});

	}

	public static int[] plusOneM(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] result = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}
}
