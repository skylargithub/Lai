package mainRun.StingI;

public class StringOfAnother {
	
	 public static int strstr(String large, String small) {
		    // write your solution here
		    if(small.length() == 0) return 0;
		    if(large.length() == 0) return -1;
		    
		    char[] largeArray = large.toCharArray();
		    char[] smallArray = small.toCharArray();
		    
		    
		    
		    int slow = 0;
		    int fast = 0;
		    
		    while(fast < largeArray.length && slow < smallArray.length) {
		      if(largeArray[fast] == smallArray[slow]) {
		          slow++;
		      } else {
		          slow = 0;
		      }
		      fast++;
		    }
		    
		    return slow < smallArray.length ? -1 :fast - smallArray.length;
		  }

}
