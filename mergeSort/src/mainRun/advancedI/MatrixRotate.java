package mainRun.advancedI;

public class MatrixRotate {
	
	public void rotate(int[][] matrix) {
	    // Write your solution here.
	    if(matrix.length == 1) return;
	    rotateHelper(matrix, 0);
	  }
	  
	  public void rotateHelper(int[][] matrix, int level) {
	    if(level == matrix.length / 2) {
	       return;
	    }
	    int N = matrix.length;
	    
	    //level 0 size = 3
	    for(int i = level; i < N - level - 1; i++) {
	      int temp = matrix[level][i];
	      matrix[level][i] = matrix[N - i - 1][level];
	      matrix[N - i - 1][level] = matrix[N - level - 1][N - i - 1];
	      matrix[N - level - 1][N - i - 1] = matrix[i][N - level - 1];
	      matrix[i][N - level - 1] = temp;
	    }
	    
	    rotateHelper(matrix, level + 1);
	    
	  }

}
