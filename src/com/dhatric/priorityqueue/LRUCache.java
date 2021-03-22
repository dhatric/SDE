package com.dhatric.priorityqueue;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class LRUCache {
	private int capacity;
	HashMap<Integer, Integer> valueMap = new HashMap<>();
	PriorityQueue<Entry<Integer, Integer>> minQueue = new PriorityQueue<>(Comparator.comparing(Entry::getValue));
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (valueMap.containsKey(key)) {
			Entry<Integer, Integer> entry = minQueue.stream().filter(element -> element.getKey().equals(key))
					.findFirst().get();
			int newFrequency = entry.getValue() + 1;
			minQueue.remove(entry);
			minQueue.add(new SimpleEntry<>(key, newFrequency));
			return valueMap.get(key);
		} else {
			return -1;
		}

	}

	public void put(int key, int value) {

         if(valueMap.containsKey(key)){
              valueMap.put(key,value);
         }else if(valueMap.size() < capacity ){
               valueMap.put(key,value); 
                minQueue.add(new SimpleEntry<>(key,1));
         }else{
             //capacity is reached (Evict)
               valueMap.remove(minQueue.poll().getKey());
               valueMap.put(key,value);
               minQueue.add(new SimpleEntry<>(key,1));
         }

    }
	
	public static void main(String[] args) {
		
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1));    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2));    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1));    // return -1 (not found)
		System.out.println(lRUCache.get(3));    // return 3
		System.out.println(lRUCache.get(4));    // return 4
	}
}
