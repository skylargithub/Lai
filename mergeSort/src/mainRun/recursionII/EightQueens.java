package mainRun.recursionII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EightQueens {
	
	  public List<List<Integer>> nqueens(int n) {
		    // Write your solution here.
		    List<List<Integer>> result = new LinkedList<List<Integer>>();
		    nqueenHelper(0, n, new LinkedList<Integer>(), result );
		    return result;
		  }
		  
		  public void nqueenHelper(int level, int N, List<Integer> temp, List<List<Integer>> result ) {
		    if(level == N) {
		       result.add(new LinkedList<Integer>(temp));
		       return;
		    }
		    
		    for(int i = 0; i < N; i++) {
		      if(passCheck(i, temp, level)) {
		         temp.add(i);
		         nqueenHelper(level + 1, N, temp, result);
		         temp.remove((Integer)i);
		      }
		    }
		  }
		  
		  public boolean passCheck(int i, List<Integer> temp, int level) {
		     for(Integer position: temp) {
		       if(i == position || Math.abs(level - temp.indexOf(position) ) == Math.abs(i - position))  {
		         return false;
		       }
		     }
		     return true;
		  }

}
