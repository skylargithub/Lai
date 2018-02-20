package mainRun.advancedI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SortInOrder {
	public int[] sortSpecial(int[] A1, int[] A2) {
	    // Write your solution here.
		if(A2.length == 0) {
			Arrays.sort(A1);
			return A1;
		}
		
		if(A1.length ==0) return A1;
	    
	    HashMap<Wrapper, Integer> hashmap = new HashMap<Wrapper, Integer>();
	    List<Integer> temp = new ArrayList<Integer>();
	    //constuct A2 hashmap
	    construct(hashmap, A2);
	    for(int i = 0; i < A1.length; i++) {
	      Wrapper wr = new Wrapper(A1[i]);
	      if(hashmap.containsKey(wr)) {
	         hashmap.put(wr,hashmap.get(wr) + 1);
	      } else {
	         temp.add(A1[i]);
	      }
	    }
	    
	    return construct(hashmap, temp, A1, A2);
	  }
	  
	  public void construct(HashMap<Wrapper, Integer> hashmap, int[] A2) {
	    for(int i = 0; i < A2.length; i++) {
	      hashmap.put(new Wrapper(A2[i]), 0);
	    }
	  }
	  
	  public int[] construct(HashMap<Wrapper, Integer> hashmap, List<Integer> temp, int[] A1, int[] A2) {
	      int[] result = new int[A1.length];
	      int j = 0;
	      for(int i = 0; i < A2.length; i++) {
	    	 while(hashmap.get(new Wrapper(A2[i])) > 0) {
	    		 result[j] = A2[i];
	    		 hashmap.put(new Wrapper(A2[i]),hashmap.get(new Wrapper(A2[i])) - 1);
	    		 j++;
	    	 }
	      }
	      
	      Collections.sort(temp);
	      for(Integer tempNumber: temp) {
	        result[j] = tempNumber;
	        j++;
	      }
	      
	      return result;
	  }
	  
	  
	  class Wrapper {
	    private int temp;
	    
	    public Wrapper(int temp) {
	      this.temp = temp;
	    }
	    
	  /*  public int compareTo(Wrapper wr){  
	      if(wr.temp==this.temp)  
	        return 0;  
	      else if(this.temp>wr.temp)  
	        return 1;  
	      else  
	       return -1;  
	    }  */
	    
	    @Override
	    public boolean equals(Object o) {
	    	Wrapper wr = (Wrapper) o;
	       return wr.temp == this.temp ? true : false;
	    }

	    @Override
	    public int hashCode() {
	       int result = 17;
	       return 31 * result + this.temp;
	    }
	    
	  }

}
