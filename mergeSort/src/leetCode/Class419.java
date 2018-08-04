package leetCode;

public class Class419 {

	 public static int countBattleships(char[][] board) {
	        int sum = 0;
	        for(int i = 0; i < board.length; i++) {
	            for(int j = 0; j < board.length; j++) {
	                if(board[i][j] == 'X') {
	                    if(i - 1 >= 0) {
	                        if(board[i - 1][j] == 'X') continue;
	                    }
	                    
	                    if(j - 1 >= 0) {
	                        if(board[i][j - 1] == 'X') continue;
	                    }
	                    sum++;
	                }
	            }
	        }
	        return sum;
	    }
	 
	 public static void main(String[] args) {
		 char[][] board = new char[][] {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
		 countBattleships(board);
	 }
}
