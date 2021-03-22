package com.dhatric.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanFinish {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		if(numCourses ==1 )return true;
		
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		int[] inwardDegrees = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new ArrayList<Integer>());
		}

		for (int p = 0; p < prerequisites.length; p++) {
			List<Integer> dependentnodes = graph.get(prerequisites[p][1]);
			dependentnodes.add(prerequisites[p][0]);
			graph.put(prerequisites[p][1], dependentnodes);
		}

		// Calculate inward degrees
		for (Integer key : graph.keySet()) {
			for (Integer dependent : graph.get(key)) {
				inwardDegrees[dependent] += 1;
			}
		}

		// Identify the vertices with zero inward degrees
		ArrayDeque<Integer> path = new ArrayDeque<Integer>();
		for (int i = 0; i < inwardDegrees.length; i++) {
			if (inwardDegrees[i] == 0) {
				path.add(i);
			}
		}
		
		while(!path.isEmpty()) {
			Integer zeroInward = path.remove();
			for (Integer depend : graph.get(zeroInward)) {
				inwardDegrees[depend] -= 1;
				if (inwardDegrees[depend] == 0) {
					path.add(depend);
				}
			}
		}
		
		for (int i = 0; i < inwardDegrees.length; i++) {
			if(inwardDegrees[i] !=0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) {

		int numCourses = 5;
		int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 2, 4 } };
		System.out.println(canFinish(numCourses, prerequisites));

	}

}