package leetCode;

//Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//Output: 4
public class Class474 {

	public int findMaxForm(String[] strs, int m, int n) {
		int length = strs.length;
		int[][][] dp = new int[length][m + 1][n + 1];
		int result = 0;
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < m + 1; j++) {
				for(int k = 0; k < n + 1; k++) {
					int[] nums = findNum(strs[i]);
					int zero = nums[0];
					int one = nums[1];
					
					if(i == 0) {
						dp[i][j][k] = j == zero && k == one ? 1 : 0;
					} else {
						if(j - zero == 0 && k - one == 0) {
							dp[i][j][k] = Math.max(1, dp[i - 1][j][k]);
							continue;
						}
						if(j - zero < 0 || k - one < 0 || dp[i - 1][j - zero][k - one] == 0) {
							dp[i][j][k] = dp[i - 1][j][k];
						} else {
							dp[i][j][k] = Math.max(dp[i - 1][j - zero][k - one] + 1, dp[i - 1][j][k]);
						}
						
					}
					
					if(i == strs.length - 1) result = Math.max(dp[i][j][k], result);
				}
			}
		}
		return result;
	}
	
	public int[] findNum(String str) {
		int[] result = new int[2];
		result[0] = 0;
		result[1] = 0;
		for(Character c : str.toCharArray()) {
			if(c == '0') result[0]++;
			else result[1]++;
		}
		return result;
	}

}
