package com.dhatric.twod;


public class MineSweeper {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] bombs1 = {{0, 2}, {2, 0}};
        // mineSweeper(bombs1, 3, 3) should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        // mineSweeper(bombs2, 3, 4) should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        // mineSweeper(bombs3, 5, 5) should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
        
        int[][] field=mineSweeper(bombs3, 5, 5);
		for(int i=0; i< field.length; i++) {
			for(int j=0; j<field[i].length;j++) {
				System.out.print(field[i][j]+ " ");
			}
			System.out.println();
		}
				
    }

    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];
		
		for(int i=0; i< bombs.length; i++){
			int bombRow=bombs[i][0];
			int bombColumn=bombs[i][1];
			field[bombRow][bombColumn]=-1;
			incrementCounter(field,bombRow-1,bombColumn-1);
			incrementCounter(field,bombRow-1,bombColumn);
			incrementCounter(field,bombRow-1,bombColumn+1);
			incrementCounter(field,bombRow+1,bombColumn-1);
			incrementCounter(field,bombRow+1,bombColumn);
			incrementCounter(field,bombRow+1,bombColumn+1);
			incrementCounter(field,bombRow,bombColumn-1);
			incrementCounter(field,bombRow,bombColumn+1);
		}
        return field;
    }
	
	static void incrementCounter(int[][] field, int bombRow, int bombColumn)
	{
		if(bombRow >=0 && bombColumn>=0 && bombRow <field.length && bombColumn< field[bombRow].length){
			if(field[bombRow][bombColumn]!=-1){
				field[bombRow][bombColumn]= field[bombRow][bombColumn]+1;
			}
		}
		
	}
 }
