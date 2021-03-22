package com.dhatric.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EmployeeInform {
	public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

		for (int eIndex = 0; eIndex < manager.length; eIndex++) {
			if (manager[eIndex] == -1)
				continue;
			if (graph.containsKey(manager[eIndex])) {
				List<Integer> subOrdinates = graph.get(manager[eIndex]);
				subOrdinates.add(eIndex);
				graph.put(manager[eIndex], subOrdinates);
			} else {
				List<Integer> subOrdinates = new ArrayList<>();
				subOrdinates.add(eIndex);
				graph.put(manager[eIndex], subOrdinates);
			}
		}
		return dfs(graph, headID, n, informTime);
	}

	public static int dfs(Map<Integer, List<Integer>> graph, int currentEmp, int n, int[] informTime) {
		if (!graph.containsKey(currentEmp) || graph.get(currentEmp).isEmpty()) {
			return 0;
		}
		int max = 0;
		List<Integer> subOrdinates = graph.get(currentEmp);
		for (Integer subOrdinate : subOrdinates) {
			max = Math.max(max, dfs(graph, subOrdinate, n, informTime));
		}
		return max + informTime[currentEmp];
	}

	public static void main(String args[]) {

		int n = 6;
		int headID = 2;
		int[] manager = { 2, 2, -1, 0, 1, 1 };
		int[] informTime = { 3, 2, 5, 0, 0, 0 };

		System.out.println(numOfMinutes(n, headID, manager, informTime));

	}
}