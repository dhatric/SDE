package com.dhatric.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MostFrequentOccurance {

	static Integer mostFrequentOptimized(int[] inputArray) {
		Map<Integer, Integer> counterMap = new HashMap<>();
		if (inputArray.length == 0) {
			return null;
		} else if (inputArray.length == 1) {
			return inputArray[0];
		}
		int mostFrequentNumber = inputArray[0];
		int maxCounter = 0;

		for (int index = 0; index < inputArray.length; index++) {
			int innerCounter = 1;
			if (counterMap.containsKey(inputArray[index])) {
				innerCounter = counterMap.get(inputArray[index]) + 1;
			}
			counterMap.put(inputArray[index], innerCounter);

			if (innerCounter > maxCounter) {
				mostFrequentNumber = inputArray[index];
				maxCounter = innerCounter;
			}

		}
		return mostFrequentNumber;
	}

	public static void main(String[] args) {
		int[] inputArray = { 1, 3, 1, 3, 2, 1 };
		System.out.println(mostFrequentOptimized(inputArray) + " is the most frequently occuring number");

	}

}
