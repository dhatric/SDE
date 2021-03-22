package com.dhatric.strings;

import java.util.ArrayList;
import java.util.List;

public class WordsVertical {

	public static void main(String[] args) {
		
		List<String> outputList = printVertically("TO BE OR NOT TO BE");
		for(String s : outputList)
			System.out.println(s);
	}

	public static List<String> printVertically(String s) {
        List<String> outputList = new ArrayList<>();
        String[] words = s.split(" ");
       
        int maxLength=0;
   
        for(String word: words){
          maxLength = Math.max(maxLength, word.length());
        }
        
      for(int index=0; index < maxLength;index++){
       StringBuilder sb = new StringBuilder();
        for(String word: words){
          if(index < word.length()){
            sb.append(word.charAt(index));
          }
        }
      outputList.add(sb.toString());
      }
          
        
      return outputList; 
        
    }
}
