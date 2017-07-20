package mainRun.dp1;

public class ArrayHopper {
	
	public static boolean arryHop(int[] A) {
		boolean[] dp = new boolean[A.length];
		dp[A.length - 1] = A[A.length - 1] > 0 ? true:false;
		
		for(int i = A.length -2; i >= 0; i--) {
			for(int j = i+1; j <= Math.min(A.length - 1, i + A[i]); j++) {
				if(dp[j] || j == A.length -1) {
					dp[i] = true;
					break;
				} 
			}
		}
		return dp[0];
	}

	
}
