package mainRun.advancedIV;

import java.util.HashSet;

//System.out.print(TwoSum.existSum(new int[]{3,2,4}, 4));

public class TwoSum {
	
	  public static boolean existSum(int[] array, int target) {
		    // Write your solution here.
		    HashSet<Integer> hashset = new HashSet<Integer>();
		    
		    for(int i: array) {
		      hashset.add(i);
		    }
		    
		    for(Integer i: hashset) {
		      if(hashset.contains(target - i)) return true;
		    }
		    return false;
		  }

}
