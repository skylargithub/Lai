package mainRun.advancedVIIII;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//MaxWindow test = new MaxWindow();
//System.out.print(test.maxWindows(new int[]{2,1,3,6,2,3,2,4,1,5,2,7,6,8,1,4}, 3));
public class MaxWindow {

	public List<Integer> maxWindows(int[] array, int k) {
	    // Write your solution here.
	    List<Integer> result = new ArrayList<Integer>();
	    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(11);
	    for(int i = 0; i < k; i++) {
	      pq.offer(new Pair(array[i], i));
	    }
	    
	    
	    for(int i = k - 1; i < array.length; i++) {
	      Pair temp = pq.peek();
	      if(temp.index >= i - k + 1) {
	         result.add(temp.value);
	         
	      } else {
	         while(temp.index < i - k + 1) {
	            temp = pq.poll();
	         }
	         result.add(temp.value);
	      }
	      
	      if(i + 1 < array.length){
	           pq.offer(new Pair(array[i + 1], i + 1));
	       }else {
	           break;
	      }
	    }
	    return result;
	  }
	  
	  class Pair implements Comparable<Pair> {
	    public int value;
	    public int index;
	    
	    public Pair(int value, int index) {
	      this.value = value;
	      this.index = index;
	    }
	    
	    public int compareTo(Pair pr){  
	        if(this.value < pr.value) {
	          return 1;
	        }
	        
	        if(this.value > pr.value) {
	          return -1;
	        } else {
	          return 0;
	        }
	    }  
	  }
}
