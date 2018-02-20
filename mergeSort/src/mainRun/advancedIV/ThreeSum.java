	//	ThreeSum treeSum = new ThreeSum();
		//System.out.print(treeSum.allTriples(new int[]{-1, 0 , 1}, 0));

package mainRun.advancedIV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

	public List<List<Integer>> allTriples(int[] array, int target) {
	    HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
	      for(int i = 0; i < array.length; i++) {
	        if(!hashmap.containsKey(array[i])) {
	          hashmap.put(array[i], 0);
	        }
	        hashmap.put(array[i], hashmap.get(array[i]) + 1);
	      }
	    
	    
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    
	    if(target % 3 == 0 && hashmap.containsKey(target / 3)) {
	      if(hashmap.get(target/3) >= 3) {
	        List<Integer> temp = new ArrayList<Integer>();
	        temp.add(target/3);
	        temp.add(target/3);
	        temp.add(target/3);
	        result.add(temp);
	      }
	    }
	    
	    for(Map.Entry<Integer, Integer> entry: hashmap.entrySet()) {
	         Integer key = entry.getKey();
	         Integer frequency = entry.getValue();
	         int newTarget = target - key;
	         entry.setValue(frequency - 1);
	         List<List<Integer>> twoPairs = allPairs(hashmap, newTarget);
	         if(twoPairs.size() > 0) {
	           for(List<Integer> temp : twoPairs) {
	              if(key > temp.get(0)) {
	                temp.add(key);
	                result.add(new ArrayList<Integer>(temp));
	              }
	           }
	         }
	         entry.setValue(frequency);
	    }
	    return result;
	  }
	  
	  public List<List<Integer>> allPairs(HashMap<Integer, Integer> hashmap, int target) {
	  
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
	       if(hashmap.containsKey(target - key) && key > target - key ) {
	         if(hashmap.get(target - key) > 0) {
	           List<Integer> temp = new ArrayList<Integer>();
	           temp.add(key);
	           temp.add(target - key);
	           result.add(temp);
	         }
	       }
	    }
	    return result;
	  }
}
