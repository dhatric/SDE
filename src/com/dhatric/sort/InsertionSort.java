package com.dhatric.sort;

public class InsertionSort {

	public static void insertionSort(int[] elements) {

		for (int i = 1; i < elements.length; i++) {
			int j = i ;
			while (j > 0 && elements[j] < elements[j-1]) {
				int temp = elements[j];
				elements[j] = elements[j-1];
				elements[j-1] = temp;
				j--;
			}
		}
		
		for(int i=0; i< elements.length ;i++) {
			System.out.println(elements[i]);
		}
		
	
	}

	public static void main(String[] args) {
		int[] elements = {20,40,10,60,80,5};
		insertionSort(elements);
	}

}
