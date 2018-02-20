package mainRun.StringII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//PermutationII per = new PermutationII();
//per.permutations("abb");

public class PermutationII {

	public List<String> permutations(String set) {
	    // Write your solution here.
	    //sanity check
	    if(set == null) return new ArrayList<String>();
	    List<String> result = new ArrayList<String>();
	    if(set == "") {
	    	result.add(set);
	    	return result;
	    }
	    
	    //1, covert string into sorted array
	    char[] setArray = set.toCharArray();
	    
	    Arrays.sort(setArray);
	    //2, DFS using hashset
	    DFSHelper(setArray, 0, result);
	    return result;
	  }
	  
	  public void DFSHelper(char[] setArray, int level, List<String> result) {
	    if(level == setArray.length - 1) {
	      result.add(new String(setArray));
	      return;
	    }
	    
	    HashSet<Character> hashset = new HashSet<Character>();
	    for(int i = level; i < setArray.length; i++) {
	       if(!hashset.contains(setArray[i])) {
	    	   hashset.add(setArray[i]);
	           swap(setArray, level, i);
	           DFSHelper(setArray, level + 1, result);
	           swap(setArray, level, i);
	       }
	    }
	  }
	  
	  public void swap(char[] setArray, int a, int b) {
	      char temp = setArray[a];
	      setArray[a] = setArray[b];
	      setArray[b] = temp;
	  }
}
