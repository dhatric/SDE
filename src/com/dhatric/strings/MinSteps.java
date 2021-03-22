package com.dhatric.strings;

import java.util.HashMap;
import java.util.Map.Entry;

public class MinSteps {
	public static int minSteps(String s, String t) {

		int counter = 0;

		HashMap<Character, Integer> scMap = new HashMap<>();
		HashMap<Character, Integer> tcMap = new HashMap<>();

		for (char c : s.toCharArray()) {
			scMap.put(c, scMap.getOrDefault(c, 0) + 1);
		}

		for (char c : t.toCharArray()) {
			tcMap.put(c, tcMap.getOrDefault(c, 0) + 1);
		}

		for (Entry<Character, Integer> entry : tcMap.entrySet()) {
			counter = counter + entry.getValue() - scMap.getOrDefault(entry.getKey(), 0);

		}
		return counter;

	}

	public static void main(String[] args) {
		System.out.println(minSteps("leetcode", "practice"));
	}

}
