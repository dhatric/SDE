package com.dhatric.queues;

import java.util.LinkedList;

public class QueueImpl {

	public static void main(String[] args) {
	
		LinkedList<Integer> elements = new LinkedList<>();
		
		elements.add(20);
		elements.add(30);
		elements.add(40);
		
		System.out.println(elements.peek());
		
		Integer value;
		while( (value=elements.poll()) != null) {
			System.out.println(value);
		}
	}

}
