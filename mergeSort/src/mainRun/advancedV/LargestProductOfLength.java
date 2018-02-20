package mainRun.advancedV;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LargestProductOfLength {

	public int largestProduct(String[] dict) {
	    // Write your solution here.
	    //sort string by length
	    Arrays.sort(dict, new java.util.Comparator<String>() {
	    public int compare(String s1, String s2) {
	        return s2.length() - s1.length();
	      }
	    });
	    
	    HashSet<Pair> hashset = new HashSet<Pair>();
	    
	    PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(11, new StringComparator());
	    
	    maxHeap.offer(new Pair(0, 1, dict[0], dict[1]));
	    
	    while(maxHeap.size() > 0) {
	      Pair root = maxHeap.poll();
	      if(shareCommon(root.xString, root.yString)) {
	        return root.xString.length() * root.yString.length();
	      } else {
	        //generate x+1, y
	        Pair newRoot = new Pair(root.x + 1, root.y, dict[root.x + 1], dict[root.y]);
	        maxHeap.offer(newRoot);
	        //generate x, y + 1
	        newRoot = new Pair(root.x, root.y + 1, dict[root.x], dict[root.y + 1]);
	        maxHeap.offer(newRoot);
	      }
	    }
	    return 0;
	  }
	  
	  
	  public boolean shareCommon(String s1, String s2) {
	    //return true if they share the common
	    
	    for(int i = 0; i < s1.length(); i++) {
	      char temp = s1.charAt(i);
	      for(int j = 0; j < s2.length(); j++) {
	        if(temp == s2.charAt(j)) {
	          return false;
	        }
	      }
	    }
	    return true;
	  }
	  
	  class Pair {
	    public int x;
	    public int y;
	    public String xString;
	    public String yString;
	    public Pair(int x, int y, String xString, String yString) {
	      this.x = x;
	      this.y = y;
	      this.xString = xString;
	      this.yString = yString;
	    }
	  }
	  
	  class StringComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return b.xString.length() * b.yString.length() - a.xString.length() * a.yString.length();
		}
	  }
}
