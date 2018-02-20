package amazonOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 
 * ***TEST CASE 3***
Target list:        [hello ]
Available list:        [hello ]
[0, 0]
Expected [0]
. 1point3acres.com/bbs
***TEST CASE 4***
Target list:        [hello ]. From 1point 3acres bbs
Available list:        [hello hello hello ]
[0, 0]
Expected [0]

***TEST CASE 5***
Target list:        [hello ]
Available list:        [foo bar ]
[0, 2]
Expected [0]

***TEST CASE 6***
Target list:        [hello ]. From 1point 3acres bbs
Available list:        [foo bar yo hello ]
[3, 3]
Expected [3]
 * 
 * 
 */

public class TargetTag {
	public List<Integer> subSequenceTags(List<String> source, List<String> target) {
		 List<Integer> res = new ArrayList<Integer>();
		 HashMap<String, Integer> map = new HashMap<String, Integer>();
	        for(String s : target) {
	            if(!map.containsKey(s.toLowerCase())) {
	                map.put(s.toLowerCase(), 1);
	            } else {
	                map.put(s.toLowerCase(), map.get(s.toLowerCase()) + 1);
	            } 
	        	
	     }
	     
	     int start = 0;
	     int end = 0;
	     int minStart = -1;
	     int minEnd = -1;
	     int minLength = source.size() + 1;
	     int count = 0;
	     while(end < source.size()) {
	    	 String s = source.get(end).toLowerCase();
	    	 if(map.containsKey(s)) {
	                map.put(s, map.get(s) - 1);
	                if(map.get(s) >= 0) {
	                    count++;
	                }
	         }
	    	 
	    	 //move left
	    	 while(count == target.size()) {
	                s = source.get(start);
	                if(end - start + 1 < minLength) {
	                    minStart = start;
	                    minEnd = end;
	                    minLength = end - start + 1;
	                }
	                
	                if(map.containsKey(s)) {
	                    map.put(s, map.get(s) + 1);
	                    if(map.get(s) > 0) {
	                        count--;
	                    }
	                }
	                start++;
	            }
	            end++;  
	     }
	     
	     if(minStart >= 0) {
	            res.add(minStart);
	            res.add(minEnd);
	     } 
	        
	     return res;
	}
}
