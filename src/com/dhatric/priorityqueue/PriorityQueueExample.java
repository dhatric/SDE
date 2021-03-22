package com.dhatric.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());
		minQueue.add(50);
		minQueue.add(40);
		minQueue.add(30);
		minQueue.add(20);
		minQueue.add(10);

		while(!minQueue.isEmpty()) {
			System.out.println(minQueue.poll());
		}
		
		
	}

}
