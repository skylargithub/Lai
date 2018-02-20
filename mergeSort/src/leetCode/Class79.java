package leetCode;

public class Class79 {
	
	boolean flag = false;;
    public boolean exist(char[][] board, String word) {
        flag = false;
        
        if(word == null || word.length() == 0) return false;
        
   
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                	boolean[][] visited = new boolean[board.length][board[0].length];
                    singlePointDFS(i, j, board, word, 1, visited);
                }
            }
        }
        return flag;
    }
    
    public void singlePointDFS(int x, int y, char[][] board, String word, int level, 
                               boolean[][] visited) {
        if(level == word.length() + 1) {
            flag = true;
            return;
        }
        //don't miss X >= 0 && Y >= 0
        if(x >= 0 && y >= 0 && x <= board.length - 1 && y <= board[0].length - 1 && board[x][y] == word.charAt(level - 1) && !visited[x][y]) {
            visited[x][y] = true;
            singlePointDFS(x, y + 1, board, word, level + 1, visited);
            singlePointDFS(x, y - 1, board, word, level + 1, visited);
            singlePointDFS(x + 1, y, board, word, level + 1, visited);
            singlePointDFS(x - 1, y, board, word, level + 1, visited);
            visited[x][y] = false;
        } 
    }

}
