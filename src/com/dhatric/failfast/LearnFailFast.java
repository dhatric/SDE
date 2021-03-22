package com.dhatric.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LearnFailFast {
	
	public static void main(String args[]) {
		List<Integer> myList= new ArrayList<Integer>();
		
		myList.add(10);
		myList.add(20);
		myList.add(30);
		myList.add(40);
		
		
		//did not work
		//tryIteration(myList);
		
		//did not work
		//tryLoop(myList);
		
		
		manualCopyWorked(myList);
		
		List<Integer> copyOnArrayList= new CopyOnWriteArrayList<Integer>(myList);

		for(Integer element : copyOnArrayList) {
			System.out.println(element);
			copyOnArrayList.add(50);
		}
		
		System.out.println(copyOnArrayList.size());
		
		new LinkedList<Integer>();
		
		
		
		
	}

	private static void manualCopyWorked(List<Integer> myList) {
		List<Integer> iteratorList = new ArrayList<Integer>();
		iteratorList.addAll(myList);
		
		for(Integer element : iteratorList) {
			if(element == 20) {
				myList.remove(element);
			}
		}
		System.out.println(myList.size());
	}

	private static void tryLoop(List<Integer> myList) {
		for(Integer element : myList) {
			System.out.println(element);
			myList.add(50);
		}
	}

	private static void tryIteration(List<Integer> myList) {
		Iterator<Integer> iterator = myList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			myList.add(50);
			
		}
	}

}
