package mainRun.advancedIV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSumPair {
	
	public List<List<Integer>> allPairs(int[] array, int target) {
	    // Write your solution here.
	    //key is number, value is index
	    HashMap<Integer, List<Integer>> hashmap = new HashMap<Integer, List<Integer>>();
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    for(int i = 0; i < array.length; i++) {
	      if(!hashmap.containsKey(array[i])) {
	        hashmap.put(array[i], new ArrayList<Integer>());
	      } 
	      hashmap.get(array[i]).add(i);
	    }
	    
	    
	    for(int i = 0; i < array.length; i++) {
	       if(hashmap.containsKey(target - array[i])) {
	          List<Integer> temp = hashmap.get(target - array[i]);
	          for(Integer largeIndex : temp) {
	            if(largeIndex > i) {
	              List<Integer> tempPair = new ArrayList<Integer>();
	              tempPair.add(i);
	              tempPair.add(largeIndex);
	              result.add(tempPair);
	            }
	          }
	       }
	    }
	    return result;
	  }

}
