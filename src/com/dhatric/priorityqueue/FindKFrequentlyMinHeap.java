package com.dhatric.priorityqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class FindKFrequentlyMinHeap {

	public static int[] topKFrequent(int[] nums, int k) {
		int[] topK = new int[k];


		HashMap<Integer, Integer> frequencyMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
		}

		PriorityQueue<Entry<Integer, Integer>> minQueue = new PriorityQueue<>(Comparator.comparing(Entry::getValue));
		int i = 0;
		Iterator<Entry<Integer, Integer>> iterator = frequencyMap.entrySet().iterator();
		while (i < k && iterator.hasNext()) {
			minQueue.add(iterator.next());
			i++;
		}
		
		
		while (iterator.hasNext()) {
			Entry<Integer, Integer> nextElement = iterator.next();
			if (nextElement.getValue() > minQueue.peek().getValue()) {
				minQueue.poll();
				minQueue.add(nextElement);
			}
		}
		
		int index=0;
		while(!minQueue.isEmpty()) {
			topK[index++]=minQueue.poll().getKey();
		}

		return topK;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1, 2, 2, 3,9,9,9,9,9,9 };
		System.out.println(topKFrequent(nums, 2));

	}

}
