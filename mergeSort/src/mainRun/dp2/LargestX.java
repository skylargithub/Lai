package mainRun.dp2;

public class LargestX {

	 public int largest(int[][] matrix) {
		    // Write your solution here.
			    int N = matrix.length;  //4
			    if(N == 0) return 0;
			    int M = matrix[0].length; //5
			    if(M ==0) return 0;
			    
			    int[][] leftToRight = new int[N][M];
			    int[][] rightToLeft = new int[N][M];
			    int[][] upToDown = new int[N][M];
			    int[][] downToUp = new int[N][M];
			    
			    
			    //leftToRight
			    for(int i = 0; i < N; i++) {
			      for(int j = 0; j < M; j++) {
			        if(matrix[i][j] == 1) {
			          leftToRight[i][j] = getNumber(i - 1, j - 1, leftToRight) + 1;
			          rightToLeft[i][j] = getNumber(i - 1, j + 1, rightToLeft) + 1;
			        }
			      }
			    }
			    
			    for(int i = N - 1; i >= 0; i--) {
			      for(int j = 0; j < M; j++) {
			        if(matrix[i][j] == 1) {
			          upToDown[i][j] = getNumber(i + 1, j - 1, upToDown) + 1;
			          downToUp[i][j] = getNumber(i + 1, j + 1, downToUp) + 1;
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
			  
			  public int getNumber(int i, int j, int[][] matrix) {
			    int N = matrix.length;
			    int M = matrix[0].length;
			    if( i < 0 || i > N - 1 || j < 0 || j > M - 1) {
			      return 0;
			    }
			    
			    return matrix[i][j];
			  }

}
