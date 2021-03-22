package com.dhatric.arrays;

/*
 * Find K largest element from an array
 * 
 * Elements range from 0-9
 * 
 */
public class FindLargestNumber {

	public static int getLargestNumberFromArray(int[] arr, int k) { 

		int[] hash = new int[10];
		for (int i = 0; i < arr.length; i++) {
			hash[arr[i]]++;
		}
		
		int digitCounter = 0;
		int output=0;
		for (int i = 9; i >= 0 && digitCounter<k; i--) {
			for (int j = 0; j < hash[i] && digitCounter<k ; j++,digitCounter++) {
				System.out.print(i);
				output = output*10 + i;
			}
		}

		return output;
	}

	public static void main(String args[]) {
		int[] arr = { 0, 4, 6, 8, 7, 2, 1 };
		System.out.println("\n"+getLargestNumberFromArray(arr, 4));

	}

}
