package mainRun.advancedVIIII;
//InterleaveString test = new InterleaveString();
//System.out.print(test.canMerge("axx", "be", "abcde"));
public class InterleaveString {

	public boolean canMerge(String a, String b, String c) {
	    // Write your solution here.
	    if(c.length() != a.length() + b.length()) return false;
	    if(c.length() == 0) return true;
	    
	    boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
	    for(int i = 0; i <= a.length(); i++) {
	      for(int j = 0; j <= b.length(); j++){
	        
	        if(i == 0 && j == 0) {
	          dp[0][0] = true;
	          continue;
	        }
	        
	        if(i == 0) {
	          if(c.charAt(i + j - 1) == b.charAt(j - 1)) {
	            dp[i][j] = dp[i][j - 1];
	          }
	          continue;
	        }
	        
	        if(j == 0) {
	          if(c.charAt(i + j - 1) == a.charAt(i - 1)) {
	            dp[i][j] = dp[i - 1][j];
	          }
	          continue;
	        }
	        
	        if(c.charAt(i + j - 1) == a.charAt(i - 1) && c.charAt(i + j - 1) != b.charAt(j - 1) ) {
	          dp[i][j] = dp[i - 1][j];
	        }
	        
	        if(c.charAt(i + j - 1) == b.charAt(j - 1) && c.charAt(i + j - 1) != a.charAt(i - 1) ) {
	          dp[i][j] = dp[i][j - 1];
	        }
	        
	        if(c.charAt(i + j - 1) == b.charAt(j - 1) && c.charAt(i + j - 1) == a.charAt(i - 1) ) {
	          dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
	        }
	      }
	    }
	    return dp[a.length()][b.length()];
	}
}
