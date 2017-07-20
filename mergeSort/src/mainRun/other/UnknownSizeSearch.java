package mainRun.other;

public class UnknownSizeSearch {
	
	/*class Dictionary {
		
	long get(long a) {
			return a;
		}
	}
	
	public int search(Dictionary dict, int target) {
	    // Write your solution here
	    
	    if(dict.get(0) == target) return 0;
	    
	    long i = 1;
	    while(dict.get(i) != null) {
	      if(dict.get(i) > target) break;
	      else i = i*2;
	    }
	    
	    long rightIndex = i;
	    long leftIndex = 0;
	    long mid = 0;
	    
	    while(leftIndex <= rightIndex) {
	      mid = leftIndex + (rightIndex - leftIndex)/2;
	      if(dict.get(mid) == null) {
	        rightIndex = mid - 1;
	        continue;
	      }
	      if(dict.get(mid) == target) {
	        return (int) mid;
	      } else if(dict.get(mid) > target) {
	        rightIndex = mid - 1;
	      } else {
	        leftIndex = mid + 1;
	      }
	    }
	    
	    return -1;
	  } */

}
