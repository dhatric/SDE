package com.dhatric.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubArrays {
	public static void main(String args[]) {
		int[] arr = { 1, 2, 3, 4, 5 };
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int[] subArr = new int[j - i + 1];
				int index = 0;
				for (int k = i; k <= j; k++) {
					subArr[index++] = arr[k];
				}
				list.add(subArr);
			}
		}

		System.out.println(list);
	}

}
