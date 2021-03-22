package com.dhatric.arrays;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsSortedArrays {
	
	static Integer[] getCommonElements(int[] A, int[] B){
		int aLenght=A.length;
		int bLenght=B.length;
		List<Integer> commonList = new ArrayList<Integer>();
		
		for(int aIndex=0, bIndex=0; aIndex<aLenght && bIndex<bLenght;){
			if(A[aIndex] == B[bIndex]){
				commonList.add(A[aIndex]);
				aIndex++;
				bIndex++;
			}else if(A[aIndex] < B[bIndex]){
				aIndex++;
			}else{
				bIndex++;
			}
		}
		Integer[] result= new Integer[commonList.size()];
		return commonList.toArray(result);
	}

	public static void main(String[] args) {
		int[] A={1,2,3,4,5,6};
		int[] B= {2,4,6};
		for(int element :getCommonElements(A,B)) {
			System.out.println(element);
		}
	}

}
