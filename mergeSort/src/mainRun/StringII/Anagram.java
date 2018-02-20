package mainRun.StringII;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//Anagram stringReplace = new Anagram();
//System.out.println(stringReplace.allAnagrams("ab", "abcba"));
public class Anagram {

	public List<Integer> allAnagrams(String s, String l) {
  		List<Integer> result = new ArrayList<Integer>();
		
		if(l.length() < s.length() || l.length() == 0) {
			return result;
		}
	    char[] sA = s.toCharArray();
	    char[] lA = l.toCharArray();
	    //put short string into hashmap
	    Hashtable<Character, Integer> hashtable = new Hashtable<Character, Integer>();
	    for(char temp: sA) {
	    	if(hashtable.containsKey(temp)) {
	    		hashtable.put(temp, hashtable.get(temp) + 1);
	    	} else {
	    		hashtable.put(temp, 1);
	    	}
	    }
	    
	    int typesToMatch = hashtable.size();
	    
	    for(int i = 0; i < lA.length; i++) {
	    	//add the right most
	    	if(hashtable.containsKey(lA[i])) {
	    		hashtable.put(lA[i], hashtable.get(lA[i]) - 1);
	    		if(hashtable.get(lA[i]) == 0) {
		    		typesToMatch--;
		    	} 
	    	}
	    	
	    	//remove left most
	    	if(i > s.length() - 1) {
	    		if(hashtable.containsKey(lA[i - s.length() ])) {
	    			int count = hashtable.get(lA[i - s.length()]);
	    			if(count == 0) {
	    				typesToMatch++;
	    			}
		    		hashtable.put(lA[i - s.length()], hashtable.get(lA[i - s.length()]) + 1);
		    //		if(hashtable.get(lA[i - s.length()]) == 0) {
			  //  		typesToMatch++;
			    //	}
		    	}    			
	    	}
	    	
	    	if(typesToMatch == 0) {
	    		result.add(i - s.length() + 1);
	    	}
	    }	  
	    return result;
	  }
}
