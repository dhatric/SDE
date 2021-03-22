package com.dhatric.arrays;

public class ReorganizeString {
	
	public static String reorganizeString(String inputStr) {
        int length = inputStr.length();
        int[] counts = new int[26];
        int maxCount = 0;
        int maxCountIndex = -1;
        
        // Get count of each character
        for (char c : inputStr.toCharArray()) {
            counts[c - 'a'] += 1;
            if(maxCount < counts[c-'a']) {
                maxCount = counts[c-'a'];
                maxCountIndex = c-'a';
            }
        }

        // if any character with count more than half then not possible
        if (maxCount > (length + 1) / 2) return "";

        // fill characters alternative indexes 0,2,4 etc, when index>lenght start from 1 & then 3,5 etc
        char[] outputStr = new char[length];
        int index = 0;
        //first fill the character with max frequency, to handle cases where frequency is == n/2 +1 e.g vvvlo
        for(int j=0; j<counts[maxCountIndex]; j++){
            if(index >=length) index = 1;

            outputStr[index] = (char)(maxCountIndex +'a');
            index += 2;
        }

        for(int i=0; i< 26;i++){
            if(i== maxCountIndex) continue;

            char ch = (char) ('a'+i);
            for(int j=0; j<counts[i]; j++){
                if(index >=length) index = 1;

                outputStr[index] = ch;
                index += 2;
            }
        }

        return String.valueOf(outputStr);
    }
	
	public static void main(String[] args) {
		System.out.println(reorganizeString("aabb"));
	}

}
