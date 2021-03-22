package com.dhatric.dp;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class FibDP {
	public static void main(String[] args) {
		Long[] memory = new Long[5];
		System.out.println(fib(3, memory));
		HashMap<Character,Integer> tcMap = new HashMap<>();
		Set<Entry<Character,Integer>> tSet = tcMap.entrySet();
	}

	static Long fib(int n, Long[] memory) {
		if (memory[n-1] != null) {
			return memory[n-1];
		}

		Long value = 0l;
		if(n==0) {
			return 0L;
		}
		if (n == 1 || n == 2) {
			value = 1l;
		} else {
			value = fib(n - 1, memory) + fib(n - 2, memory);
		}
		memory[n-1] = value;
		return value;
	}
}
