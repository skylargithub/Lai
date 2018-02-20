package mainRun.advancedVIIII;
//LongestPalidrome test = new LongestPalidrome();
//System.out.print(test.longestPalindrome("abcbcbd"));
public class LongestPalidrome {
	
	 public String longestPalindrome(String s) {
		    if(s.length() == 0) return "";
		    int indexLeft = -1;
		    int indexRight = -1;
		    int globalMax = -1;
		    boolean[][] dp = new boolean[s.length()][s.length()];
		    
		    for(int i = s.length() - 1; i >= 0; i--) {
		      for(int j = i; j <= s.length() - 1; j++) {
		        if(j - i > 1) {
		          if(s.charAt(i) == s.charAt(j)) {
		          dp[i][j] = dp[i + 1][j - 1];
		          } 
		        }else {
		          if(i == j) {
		          dp[i][j] = true;
		          }
		        
		          if(j - i == 1) {
		             if(s.charAt(i) == s.charAt(j)) {
		               dp[i][j] = true;
		             } 
		          }
		        }
		        
		        if(dp[i][j]) {
		          if(j - i + 1 > globalMax) {
		            globalMax = j - i + 1;
		            indexLeft = i;
		            indexRight = j;
		          }
		        }
		    }
		  }
		    return s.substring(indexLeft, indexRight + 1);
		  }
}
