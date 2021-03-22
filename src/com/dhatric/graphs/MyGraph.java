package com.dhatric.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MyGraph {

	public static void main(String args[]) {

		int[][] graph = { { 1, 3 }, { 0 }, { 3, 8 }, { 0, 2, 4, 5 }, { 3, 6 }, { 3 }, { 4, 7 }, { 6 }, { 2 } };
		System.out.println("---------BFS----------------");
		List<Integer> values = breadthFirstSearch(graph);
		values.forEach(element -> System.out.print(element));
		
		System.out.println("\n---------DFS----------------");
		 values = depthFirstSearch(graph);
		values.forEach(element -> System.out.print(element));
	}

	public static List<Integer> depthFirstSearch(int[][] graph) {
		int[] seen = new int[graph.length];
		List<Integer> values = new ArrayList<Integer>();
		depthFirstSearchRec(graph, 0, seen, values);
		return values;
	}

	public static void depthFirstSearchRec(int[][] graph, int vertex, int[] seen, List<Integer> values) {
		values.add(vertex);
		seen[vertex] = 1;
		int[] connectedVertex = graph[vertex];
		for (int i = 0; i < connectedVertex.length; i++) {
			if (seen[connectedVertex[i]] != 1) {
				depthFirstSearchRec(graph, connectedVertex[i], seen, values);
			}
		}
	}

	public static List<Integer> breadthFirstSearch(int[][] graph) {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		int[] seen = new int[graph.length];
		List<Integer> values = new ArrayList<Integer>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int currentVertex = queue.remove();
			if (seen[currentVertex] != 1) {
				values.add(currentVertex);
				seen[currentVertex] = 1;
				int[] connections = graph[currentVertex];
				for (int i = 0; i < connections.length; i++) {
					queue.add(connections[i]);
				}
			}
		}
		return values;
	}
}