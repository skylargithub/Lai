package mainRun.StringII;

import java.util.HashSet;

public class LongestString {

	  public int longest(String input) {
		    // Write your solution here.
		   if(input.length() == 0 || input.length() == 1) return input.length();
		    HashSet<Character> hashset = new HashSet<Character>();
		    hashset.add(input.charAt(0));
		    int[] M = new int[input.length()];
		    M[0] = 1;
		    int start = 0;
		    int global = 0;
		    
		    for(int i = 1; i < input.length(); i++) {
		       if(!hashset.contains(input.charAt(i))) {
		         M[i] = M[i - 1] + 1;
		         hashset.add(input.charAt(i));
		       } else {
		    	   
		         while(start < i) {
		           hashset.remove(input.charAt(start));
		           if(input.charAt(start) == input.charAt(i)) {
		        	 start++;
		        	 hashset.add(input.charAt(i));
		             break;
		           }
		           start++;
		         }
		         M[i] = i - start + 1;
		       }
		       if (M[i] > global) {
		         global = M[i];
		       }
		       
		    }
		    return global;
		  }
}
