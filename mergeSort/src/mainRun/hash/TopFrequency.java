package mainRun.hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopFrequency {
	  public static String[] topKFrequent(String[] combo, int k) {
		    // Write your solution here.
		    if(combo.length == 0 ) {
		      return new String[0];
		    }
		    
		    HashMap<String, Integer> frequency = new HashMap<String, Integer>();
		    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(k, new Comparator<Map.Entry<String, Integer>>(){
		    	
				public int compare(Map.Entry<String, Integer> e1,
						Map.Entry<String, Integer> e2) {
					// TODO Auto-generated method stub
					return e1.getValue().compareTo(e2.getValue());
				}
		    	
		    });
		   
		    
		    for(int i=0; i < combo.length; i++){
		      if(frequency.containsKey(combo[i])) {
		        frequency.put(combo[i], frequency.get(combo[i])+1);
		      } else {
		        frequency.put(combo[i], 1);
		      }
		    }
		    
	
		    
		    //Min heap is needed, if count 
		    //heapify first K element
		    for(Map.Entry<String, Integer> entry: frequency.entrySet()) {
		       if(minHeap.size()<k) {
		         minHeap.offer(entry);
		       } else if (entry.getValue() > minHeap.peek().getValue() ) {
		         minHeap.poll();
		         minHeap.offer(entry);
		       }
		    }
			

		    return frequencyArray(minHeap);
		  }
		  
		  private static String[] frequencyArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
		     String[] result = new String[minHeap.size()];
		    for(int i=minHeap.size(); i > 0; i--) {
		       result[i-1] = minHeap.poll().getKey();
		    }
		    return result;
		  }

}
