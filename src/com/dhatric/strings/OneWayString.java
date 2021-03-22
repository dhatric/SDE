package com.dhatric.strings;

public class OneWayString {
	
	public static Boolean isOneAway(String s1, String s2) {
		int delta = Math.abs(s1.length() - s2.length());
		if(delta != 0  &&  delta != 1 ){
			return false;
		}else if(s1.equals(s2)) {
			return true;
		}
		String maxCharacterString = s1.length() >= s2.length()? s1: s2;
		String minCharacterString = s1.length() < s2.length()? s1: s2;
		boolean changedOnce=false;
		for(int indexMax=0, indexMin=0; indexMax < maxCharacterString.length() && indexMin <minCharacterString.length() ; ){
			if(maxCharacterString.charAt(indexMax) == minCharacterString.charAt(indexMin)){
				indexMax++;
				indexMin++;
			}else if(!changedOnce && maxCharacterString.length() == minCharacterString.length()){
				changedOnce=true;
				indexMax++;
				indexMin++;
			}else if(!changedOnce){
				changedOnce=true;
				indexMax++;
			}else{
				return false;
			}
		}
        return true;
 }

	public static void main(String[] args) {

		System.out.println(isOneAway("aaa", "abc"));

	}

}
