package mainRun.dp2;

public class LargestSum {

	 public int largest(int[][] matrix) {
		    // Write your solution here.
		    //pre-processing
		    int N = matrix.length;
		    int M = matrix[0].length;
		    
		    int[][] pre = new int[N][M];
		    
		    for(int j = 0; j < M; j++) {
		      for(int i = 0; i < N; i++) {
		          pre[i][j] = i > 0 ? pre[i - 1][j] + matrix[i][j] : matrix[i][j];
		      }
		    }
		    
		    int globalMax = Integer.MIN_VALUE;
		       
		    for(int i = 0; i < N; i++) {
		      for(int j = i; j < N; j++) {
		        int[] dp = new int[M];
		        for(int k = 0; k < M; k++) {
		           if(k == 0) {
		        	  if(i == 0) {
		        		  dp[k] = pre[j][0];
		        	  } else {
		        		  dp[k] = pre[j][0] - pre[i - 1][0];
		        	  }
		             
		           } else {
		        	   if(i == 0) {
		        		   dp[k] = dp[k - 1] + pre[j][k] > 0 ? dp[k - 1] + pre[j][k] : pre[j][k];
			        	} else {
			        	   dp[k] = dp[k - 1] + pre[j][k] - pre[i - 1][k] > 0 ? dp[k - 1] + pre[j][k] - pre[i - 1][k] :
				  		   pre[j][k] - pre[i - 1][k];
			        	}
		             
		           }
		           globalMax = dp[k] > globalMax ? dp[k] : globalMax;
		        }
		      }
		    }
		    return globalMax;
		  }
}
