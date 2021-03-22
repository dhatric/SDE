package com.dhatric.graphs;

import java.util.LinkedList;

public class IslandDFS {

	public static void main(String[] args) {
		char[][] grid = {{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','0','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
		System.out.println(numIslands(grid));

	}

	public static int numIslands(char[][] grid) {

		int count = 0;
		int rows = grid.length;
		int columns = grid[0].length;
		boolean[][] visited = new boolean[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				count = bfs(grid, i, j, visited, count, rows, columns);
			}
		}

		return count;
	}

	public static int bfs(char[][] grid, int i, int j, boolean[][] visited, int count, int rows, int columns) {
		if (grid[i][j] == '1' && visited[i][j] == false) {
			LinkedList<String> queue = new LinkedList<>();
			queue.add(i + "," + j);

			while (!queue.isEmpty()) {

				String rowColumn = queue.pop();
				int rowid = Integer.parseInt(String.valueOf(rowColumn.split(",")[0]));
				int columnId = Integer.parseInt(String.valueOf(rowColumn.split(",")[1]));
				visited[rowid][columnId] = true;

				addNeighbourToQueue(rowid - 1, columnId, grid, visited, queue, rows, columns);
				addNeighbourToQueue(rowid + 1, columnId, grid, visited, queue, rows, columns);
				addNeighbourToQueue(rowid, columnId + 1, grid, visited, queue, rows, columns);
				addNeighbourToQueue(rowid, columnId - 1, grid, visited, queue, rows, columns);
			}
			count++;
		}

		return count;
	}

	static void addNeighbourToQueue(int i, int j, char[][] grid, boolean[][] visited, LinkedList<String> queue, int rows,
			int columns) {
		if (i >= 0 && i < rows && j >= 0 && j < columns && grid[i][j] == '1' && visited[i][j] == false) {
			queue.add(i + "," + j);
		}
	}
}
