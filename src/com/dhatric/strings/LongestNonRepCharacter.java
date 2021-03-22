package com.dhatric.strings;

import java.util.HashSet;

public class LongestNonRepCharacter {
	public int lengthOfLongestSubstring(String input) {
		int max = 1;
		if (input == null || input.equals("")) {
			return 0;
		} else if (input.length() == 1) {
			return 1;
		}

		int start = 0;
		int end = 1;

		while (end < input.length()) {
			String subString = input.substring(start, end + 1);

			if (hasUniqueChars(subString)) {
				if (end - start + 1 > max) {
					max = end - start + 1;
				}
				end++;
			} else {
				start++;
				end++;
			}

		}
		return max;
	}

	public boolean hasUniqueChars(String input) {
		HashSet<Character> chars = new HashSet<Character>();
		for (char c : input.toCharArray()) {
			if (chars.contains(c)) {
				return false;
			}
			chars.add(c);
		}
		return true;
	}
}
