package com.dhatric.strings;

public class FindSubString {

	public static boolean find(String mainString, String subString){
		char[] mainChars = mainString.toCharArray();
		char[] subChars = subString.toCharArray();
		
		if(null == mainString || null == subString)
			return false;
		
		int j=0;
		for(int i=0; i< mainChars.length-subChars.length;i++){
			
			if(mainChars[i] != subChars[j]){
				j=0;
			}else{
				++j;
			}
			
			if( j == subChars.length)
				return true;
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.print(find("Hellohowareyou","how"));

	}

}
