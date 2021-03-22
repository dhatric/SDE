package com.dhatric.arrays;

public class Sequence{
	
	public static Character getLongestConsqChar(String s){
		
		if(s == null || s.length() == 0){
			return null;
		}
		
		int maxCount=0;
		Character prevChar = null;
		Character maxCharacter=null;
		int count=0;
		
		for(int index=0; index < s.length() ; index++){
			
			if (prevChar!=null &&  prevChar == s.charAt(index)){
				count+=1;
			}else{
				count=1;
			}
			if(count > maxCount){
				maxCount= count;
				maxCharacter= s.charAt(index);
			}
			prevChar = s.charAt(index);
		}	
		return maxCharacter;
	}
	
	
	public static void main(String args[]){
		
		System.out.print(getLongestConsqChar("AABBCCCAB"));		
	}
	
}