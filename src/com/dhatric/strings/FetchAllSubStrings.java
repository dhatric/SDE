package com.dhatric.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FetchAllSubStrings {
	
	static List<String> fetchAllSubStrings(String input) {
		List<String> output = new ArrayList<>();

		for (int length = 1; length < input.length(); length++) {
			for (int i = 0; i <= input.length() - length; i++) {
				int j = i + length;
				StringBuilder str= new StringBuilder();
				for (int k = i; k < j; k++) {
					str.append(input.charAt(k));
				}
				output.add(str.toString());
			}
		}

		return output;
	}

	public static void main(String[] args) {

		List<String> subStrings = fetchAllSubStrings("abcd");
		subStrings.forEach(element -> System.out.println(element));
		
	}

}
