package leetCode;

public class Class44 {
	
public boolean isMatch(String s, String p) {
	int row = p.length() + 1;
	int col = s.length() + 1;
	boolean[][] dp = new boolean[row][col];
	for(int j = 0; j < col; j++) {
		dp[0][j] = j == 0 ? true : false;
	}
	
	for(int i = 0; i < row; i++) {
		if()
	}
	
	
	return dp[p.length()][s.length()];
        
    }

}
