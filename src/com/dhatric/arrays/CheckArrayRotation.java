package com.dhatric.arrays;

public class CheckArrayRotation {

	static boolean is_rotation(int[] A, int[] B) {

		if (A.length != B.length) {
			return false;
		}

		boolean matchIndexFound = false;
		for (int aIndex = 0, bIndex = 0; aIndex < A.length;) {

			if (!matchIndexFound) {
				if (bIndex == B.length) {
					return false;
				} else if (A[aIndex] != B[bIndex]) {
					bIndex++;
				} else {
					matchIndexFound = true;
				}

			} else if (matchIndexFound) {
				if (bIndex == B.length) {
					bIndex = 0;
				}
				if (A[aIndex] != B[bIndex]) {
					return false;
				}
				bIndex++;
				aIndex++;
			}

		}
		return true;

	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7 };
		int[] B = { 4, 5, 6, 7, 0, 2, 3 };
		System.out.print(is_rotation(A, B));

	}

}
