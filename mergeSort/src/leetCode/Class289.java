package leetCode;

public class Class289 {

	public void gameOfLife(int[][] board) {
        //00 0 01 1 10 2 11 3
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = helper(board, i, j) == 0 ? 0 : 1;
                } else {
                    board[i][j] = helper(board, i, j) == 0 ? 2 : 3;
                }
            }
        }
        
         for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
              board[i][j] = board[i][j] % 2;
            }
        }
        
    }
    
    public int helper(int[][] board, int x, int y) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        if(board[x][y] == 0) {
            int count = 0;
            for(int[] dir : dirs) {
                if(x + dir[0] < board.length && y + dir[1] < board[0].length && x + dir[0] >= 0 && y + dir[1] >= 0 && board[x + dir[0]][y + dir[1]] / 2 == 1) {
                    count++;
                }
            }
            return count == 3 ? 1 : 0;
        } else {
            int count = 0;
            for(int[] dir : dirs) {
                if(x + dir[0] < board.length && y + dir[1] < board[0].length && x + dir[0] >= 0 && y + dir[1] >= 0 && board[x + dir[0]][y + dir[1]] / 2 == 1) {
                    count++;
                }
            }
            if(count < 2 || count > 3) return 0;
            else return 1;
        }
    }
    
    public static void main(String[] args) {
		   
    	Class289 class289= new Class289();
    	int[][] test = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    	class289.gameOfLife(test);
    	
    	}
}
