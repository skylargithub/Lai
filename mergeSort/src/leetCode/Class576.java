package leetCode;

public class Class576 {
	
	public int findPaths(int m, int n, int N, int i, int j) {
        if(N == 0) return 0;
        int divide = 1000000007;
        int[][][] dp = new int[N + 1][m][n];
        dp[0][i][j] = 1;
        
        for(int r = 1; r < N; r++) {
            for(int p = 0; p < m; p++) {
                for(int q = 0; q < n; q++) { 
                        dp[r][p][q] = ((p > 0 ? dp[r - 1][p - 1][q] % divide  : 0)
                                    + (q > 0 ? dp[r - 1][p][q - 1] % divide: 0)
                                    + (p < m - 1 ? dp[r - 1][p + 1][q] % divide: 0)
                                    + (q < n - 1 ? dp[r - 1][p][q + 1] % divide: 0)
                                    ) % divide;
                       
                     }
                }
        }
        
        for(int p = 0; p < m; p++) {
        	for(int q = 0; q < n; q++) {
        		int temp = 0;
        		for(int r = 0; r <= N; r++) {
        			if(r == N) dp[r][p][q] = temp;
        			else temp = temp + dp[r][p][q];
        		}
        	}
        }
        
        int result = 0;
        
        for(int p = 0; p < m; p++) {
            for(int q = 0; q < n; q++) {
                if(p - 1 < 0) result = (result + dp[N][p][q]) % divide;
                if(p + 1 > m - 1) result = (result + dp[N][p][q]) % divide;
                if(q - 1 < 0) result = (result + dp[N][p][q]) % divide;
                if(q + 1 > n - 1) result = (result + dp[N][p][q]) % divide;
            }
        }
        
        return result;   
    }
}
