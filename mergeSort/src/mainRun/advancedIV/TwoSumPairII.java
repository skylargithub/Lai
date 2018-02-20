package mainRun.advancedIV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSumPairII {
	
	public List<List<Integer>> allPairs(int[] array, int target) {
	    // Write your solution here.
	    HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
	    for(int i = 0; i < array.length; i++) {
	      if(!hashmap.containsKey(array[i])) {
	        hashmap.put(array[i], 0);
	      }
	      hashmap.put(array[i], hashmap.get(array[i]) + 1);
	    }
	    
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    //edge case
	    if(target % 2 == 0 && hashmap.containsKey(target / 2)) {
	      if(hashmap.get(target/2) >= 2) {
	        List<Integer> temp = new ArrayList<Integer>();
	        temp.add(target/2);
	        temp.add(target/2);
	        result.add(temp);
	      }
	    }
	    
	    for(Integer key: hashmap.keySet()) {
	       if(hashmap.containsKey(target - key) && key > target - key) {
	         List<Integer> temp = new ArrayList<Integer>();
	         temp.add(key);
	         temp.add(target - key);
	         result.add(temp);
	       }
	    }
	    return result;
	  }

}
