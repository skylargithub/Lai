package mainRun.dp2;

public class ArrayHopperII {

	public static int minJump(int[] array) {
	    if(array.length == 1) return 0;
	    int l = array.length;
	    int[] dp = new int[l];
	    
	    dp[l - 1] = 0;
	    for(int i = l - 2; i >= 0; i--){
	      if (array[i] >= l - i -1) {
	        dp[i] = 1;
	      } else {
	        dp[i] = array[i] > 0 ? minumum(dp, i, array) : -1;
	      }
	    }
	    return dp[0];
	  }
	  
	  public static int minumum(int[] dp, int i, int[] array){
	    int globalMin = Integer.MAX_VALUE;
	    for(int j = i+1; j <= i + array[i]; j++) {
	         if(dp[j] > 0 && dp[j] < globalMin) {
	            globalMin = dp[j];
	         }
	    }
	    return globalMin == Integer.MAX_VALUE ? -1 : globalMin + 1;
	  }
}
