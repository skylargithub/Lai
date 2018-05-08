package tictactoe;

import java.util.Random;

public class Board {
	
	String[][] cells;
	
	//N is the size of board
	public Board(int N) {
		this.cells = new String[N][N];
	}
	
	public void printBoard() {
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells.length; j++) {
				if(cells[i][j] == null) {
					System.out.print("-");
				} else {
					System.out.print(cells[i][j]);
				}
				if(j == cells.length - 1) System.out.println("");
				else System.out.print("|");
			}
			
		}
	}
	
	public boolean addToken(String token, int i, int j) {
		if(token.equals("X") || token.equals("O")) {
			if(cells[i][j] == null) {
				cells[i][j] = token;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean isFull() {
		boolean result = true;
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells.length; j++) {
				if(cells[i][j] == null) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	public boolean computerMove () throws Exception {
		Random rand = new Random();
		int  i = rand.nextInt(cells.length - 1);
		int j  = rand.nextInt(cells.length - 1);
		if(i < 0 || i > cells.length || j < 0 || j > cells.length) {
			throw new Exception("illeage Move");
		}
		
		if(cells[i][j] == null) {
			cells[i][j] = "O";
			return true;
		} else {
			throw new Exception("illeage Move");
		}
	}

}
