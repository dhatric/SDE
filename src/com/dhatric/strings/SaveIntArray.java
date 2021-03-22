package com.dhatric.strings;

public class SaveIntArray {

	public static void main(String args[]) {
		String s ="aaabbbcc";
		
		int[] charArr = new int[26];
		
		for(char c : s.toCharArray()) {
			charArr[c-'a']++;
		}
		
		
		for(int element:charArr)
			System.out.println(element);
	}
}
