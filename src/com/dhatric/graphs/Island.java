package com.dhatric.graphs;

import java.util.HashSet;

public class Island {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1',
				'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
				'1', '1', '1', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
				'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
				'1', '1', '1' } };
		System.out.println(numIslands(grid));

	}

	public static int numIslands(char[][] grid) {
		
		int count = 0;
		int rows = grid.length;
		int columns = grid[0].length;
		boolean[][] visited = new boolean[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == '1' && visited[i][j] == false) {
					dfs(grid, i, j, visited, rows, columns);
					count++;
				}

			}
		}

		return count;
	}

	public static void dfs(char[][] grid, int i, int j, boolean[][] visited, int rows, int columns) {

		visited[i][j] = true;

		if (visitNeighbour(i - 1, j, grid, visited, rows, columns)) {
			dfs(grid, i - 1, j, visited, rows, columns);
		}

		if (visitNeighbour(i + 1, j, grid, visited, rows, columns)) {
			dfs(grid, i + 1, j, visited, rows, columns);
		}

		if (visitNeighbour(i, j - 1, grid, visited, rows, columns)) {
			dfs(grid, i, j - 1, visited, rows, columns);
		}
		if (visitNeighbour(i, j + 1, grid, visited, rows, columns)) {
			dfs(grid, i, j + 1, visited, rows, columns);
		}

	}

	static boolean visitNeighbour(int i, int j, char[][] grid, boolean[][] visited, int rows, int columns) {
		if (i >= 0 && i < rows && j >= 0 && j < columns && grid[i][j] == '1' && visited[i][j] == false) {
			return true;
		} else {
			return false;
		}
	}
}
