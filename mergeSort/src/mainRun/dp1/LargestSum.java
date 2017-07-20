package mainRun.dp1;

public class LargestSum {
	
	public static int[] largestSumArray(int[] input) {
		int[] result = new int[3];
		
		//base case
		if(input.length == 0) {
			return result;
		}
		
		if(input.length == 1) {
			return new int[]{1,1,input[0]};
		}
		
		//initilize DP array
	//	int[] dp = new int[input.length];
	//	dp[0] = input[0];
		int prev = input[0];
		int globalMax = Integer.MIN_VALUE;
		int left = 1;
		int right = 1;
		
		for(int i=1; i < input.length; i++) {
			if(prev > 0) {
				prev = prev + input[i];
				right++;
			} else {
				prev = 0;
				left = i;
				right = i;
			}
			
			if(prev > globalMax) {
				globalMax = prev;
			}
			
		}
		
		result[0] = left;
		result[1] = right;
		result[2] = globalMax;
		
		return result;
	}

}
