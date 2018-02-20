package mainRun.adcancedVI;

public class CuttingWood {

	public int minCost(int[] cuts, int length) {
	    // Write your solution here.
	    if(length == 1) return 0;
	    int size = cuts.length + 2;
	    int[] newcuts = new int[size];
	    for(int i = 0; i < size; i++) {
	      if(i == 0) {
	        newcuts[i] = 0;
	        continue;
	      }
	      if(i == size - 1) {
	        newcuts[i] = length;
	        continue;
	      }
	      newcuts[i] = cuts[i - 1];
	    }
	    int[][] M = new int[size][size];
	    
	    for(int i = size - 2; i >= 0; i--) {
	      for(int j = i + 1; j <= size - 1; j++) {
	        if(j - i == 1) {
	          M[i][j] = 0;
	        } else {
	          int globalMin = Integer.MAX_VALUE;
	          for(int k = i + 1; k < j; k++) {
	            int temp = M[i][k] + M[k][j] + newcuts[j] - newcuts[i];
	            globalMin = globalMin < temp ? globalMin : temp;
	          }
	          M[i][j] = globalMin;
	        }
	      }
	    }
	    return M[0][size - 1];
	  }
}
