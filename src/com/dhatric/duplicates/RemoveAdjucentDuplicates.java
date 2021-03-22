package com.dhatric.duplicates;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Logic to remove duplicates when they are consecutive 
 * 
 * Time complexity - O(n)
 * Space complexity - O(1)
 * 
 * @author gdhatric
 *
 */
public class RemoveAdjucentDuplicates {
	
	public static int[] removeAdjDuplicates(int[] dupArray) {
		int j=1;
		for(int i=1; i<dupArray.length; i++) {
			if(dupArray[i-1] != dupArray[i]) {
				dupArray[j++] = dupArray[i];
			}
		}
		
		int[] myarr = new int[j];
		
		for(int x=0; x<j ; x++) {
			myarr[x]=dupArray[x];
		}
		return myarr;
	}

	public static int[] removeAdjDuplicatesCollections(int[] dupArray) {
		List<Integer> dupList=Arrays.stream(dupArray).boxed().distinct().collect(Collectors.toList());
		int[] distArray =new int[dupList.size()];
		for(int i=0; i<dupList.size(); i++) {
			distArray[i] = dupList.get(i);
		}
		return distArray;
	}
	
	public static void main(String[] args) {
		
		int[] dupElements = {1,1,3,3,3,5,5,6};
		System.out.println(dupElements.length);
		int[] distElements= removeAdjDuplicates(dupElements);
		for(int i=0; i<distElements.length; i++) {
			System.out.print(distElements[i]);
		}
		removeAdjDuplicatesCollections(dupElements);
		
	}

}
