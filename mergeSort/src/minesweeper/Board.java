package minesweeper;

import java.util.Random;

public class Board {
	
	public Cell[][] cells;;
	
	public Board(int size, int numberOfBombs) {
		//set all cells to 0;
		//initialize bombs, increase surrounding cells by 1;
	}
	
	public boolean click(Cell[][] cells, int x, int y) {
		if(cells[x][y].exposed || cells[x][y].flag) {
			return false;
		} else if {cells[x][y].isBomb()} {
			//set win flag;
		} else if(blank) {
			//expand blank, DFS
		} else {
			//number
		}
				
	}
	
	public boolean flag() {
		return true
	}
	
	private void initializeBombsAndNumbers(int numberOfBombs, Cell[][] cells) {
		//shuffle
		Random rand = new Random();
		for(int i = cells.length * cells[0].length - 1; i >= 0 ; i--) {
			int num = rand.nextInt(i);
			swap(cells, num, i);
			increase(cells, num, i);
		}
	}
	
	private void swap(Cell[][] cells, int i, int j) {
		int oldX = i;
		int oldY = j;
		int newX = j;
		int newY = j;
		Cell temp = cells[newX][newY];
		cells[newX][newY] = cells[oldX][oldY];
		cells[oldX][oldY] = temp;
	}
	
	private void increase(Cell[] cells, int num) {
		//if bomb, increase surrondings by 1;
		
	}
	
	private void expandBlank() {
		//DFS
	}
	



}
