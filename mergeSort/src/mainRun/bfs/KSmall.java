package mainRun.bfs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmall {

	public int[] kSmallest(int[] array, int k) {
	    // Write your solution here
	     PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(16, new ReverseComparator());
	    int[] result = new int[k];
	    
	    if(array.length == 0 || k == 0) {
	      return result;
	    }
	    
	    for(int i=0; i < k; i++) {
	      maxHeap.offer(array[i]);
	    }
	    
	    for(int i=k; i < array.length; i++) {
	      if(array[i] < maxHeap.peek()) {
	        maxHeap.poll();
	        maxHeap.offer(array[i]);
	      }
	    }
	    
	    for(int i=0; i < k; i++) {
	      result[i] = maxHeap.poll();
	    }
	    return result;
	  }
	  
	  class ReverseComparator implements Comparator<Integer> {
	    
		
		public int compare(Integer i1, Integer i2) {
			// TODO Auto-generated method stub
			 if(i1.equals(i2)) {
			        return 0;
			      }
			      
			      return i1<i2?1:-1;
		}
	  }
	  
	  

}
