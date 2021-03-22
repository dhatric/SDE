package com.dhatric.strings;

import java.util.HashMap;

public class NonRepeativeCharacter {

	 public static Character nonRepeating(String s) {
			HashMap<Character,Integer> countMap = new HashMap<>();
			Character nonRepeatChar=null;
			for(Character c : s.toCharArray()){
				if(countMap.containsKey(c)){
					countMap.put(c,countMap.get(c)+1);
				}else{
					countMap.put(c,1);
				}
			}
			
			for(Character c : s.toCharArray()){
				if(1 == countMap.get(c)){
					nonRepeatChar = c;
					break;
				}
			}
			System.out.println(nonRepeatChar);
	        return nonRepeatChar;
	    }
	 
	public static void main(String[] args) {
        nonRepeating("abcab"); // should return 'c'
        nonRepeating("abab"); // should return null
        nonRepeating("aabbbc"); // should return 'c'
        nonRepeating("aabbdbc"); // should return 'd

	}

}
