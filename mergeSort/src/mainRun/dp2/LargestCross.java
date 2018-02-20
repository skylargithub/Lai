package mainRun.dp2;

public class LargestCross {
	
	public int largest(int[][] matrix) {
	    // Write your solution here.
	    int N = matrix.length;
	    int M = matrix[0].length;
	    
	    int[][] leftToRight = new int[N][M];
	    int[][] rightToLeft = new int[N][M];
	    int[][] upToDown = new int[N][M];
	    int[][] downToUp = new int[N][M];
	    
	    for(int i = 0; i < N; i++) {
	      consecutiveOne(matrix[i], leftToRight[i], true);
	      consecutiveOne(matrix[i], rightToLeft[i], false);
	    }
	    
	    //top to down
	    for(int j = 0; j < M; j++) {
	      upToDown[0][j] = matrix[0][j];
	      for(int i = 1; i < N; i++) {
	        if(matrix[i][j] == 0) {
	          upToDown[i][j] = 0;
	        }else {
	          upToDown[i][j] = upToDown[i - 1][j] + 1;
	        }
	      }
	    }
	    
	    //bottom up
	    for(int j = 0; j < M; j++) {
	      downToUp[N - 1][j] = matrix[N - 1][j];
	      for(int i = N - 2; i >= 0; i--) {
	        if(matrix[i][j] == 0) {
	          downToUp[i][j] = 0;
	        }else {
	          downToUp[i][j] = downToUp[i + 1][j] + 1;
	        }
	      }
	    }
	    int globalMax = 0;
	    for(int i = 0; i < N; i++) {
	      for(int j = 0; j < M; j++) {
	        int temp1 = Math.min(upToDown[i][j], downToUp[i][j]);
	        int temp2 = Math.min(leftToRight[i][j], rightToLeft[i][j]);
	        if(Math.min(temp1, temp2) > globalMax) {
	          globalMax = Math.min(temp1, temp2);
	        }
	      }
	    }
	    
	    return globalMax;
	  }
	  
	  public void consecutiveOne(int[] A, int[] B, boolean direction) {
	    //B[i] = B[i - 1] + 1 if B[i] == 1;
	    //     = 0           if B[i] == 0;
	    //boolean true
	    if(direction) {
	        B[0] = A[0];
	        for(int i = 1; i < A.length; i++) {
	          if(A[i] == 0) {
	            B[i] = 0;
	          } else {
	            B[i] = B[i - 1] + 1;
	          }
	        }
	    } else {
	        //boolean false
	        B[A.length - 1] = A[A.length - 1];
	        for(int i = A.length - 2; i >= 0 ; i--) {
	          if(A[i] == 0) {
	            B[i] = 0;
	          } else {
	            B[i] = B[i + 1] + 1;
	          }
	        }
	    }
	  }

}
