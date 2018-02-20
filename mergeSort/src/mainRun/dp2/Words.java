package mainRun.dp2;

import java.util.HashSet;

public class Words {

	public boolean canBreak(String input, String[] dict) {
	    // Write your solution here.
	    boolean[] dp = new boolean[input.length()];
	    char[] A = input.toCharArray();
	    HashSet<String> hashset = new HashSet<String>();
	    for(String temp: dict) {
	      hashset.add(temp);
	    }
	    
	    dp[0] = hashset.contains(input.substring(0, 1)) ? true : false;
	    for(int i = 1; i < A.length; i++) {
	       boolean temp = false;
	       for(int j = i ; j >= 0; j--) {
	         boolean step = false;
	         if(j == 0) {
	            step = hashset.contains(input.substring(j, i + 1)) ? true : false;
	         } else {
	            step = (hashset.contains(input.substring(j, i + 1)) ? true : false) && dp[j - 1];
	         }
	           temp = temp || step;
	       }
	       dp[i] = temp;
	    }
	    return dp[A.length - 1];
	  }
}
