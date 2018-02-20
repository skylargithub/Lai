package mainRun.advancedVIIII;

import mainRun.util.Point;

public class LargestPointsPositive {
	
	 public int largest(Point[] points) {
		    // Write your solution here.
		    //sort array
		    if(points.length == 0) return 0;
		    int[] array = new int[points.length];
		    for(int i = 0; i < points.length; i++) {
		       int temp = i;
		       for(int j = i; j < points.length; j++) {
		         if(points[j].x < points[temp].x) {
		            temp = j;
		         }
		       }
		       
		       swap(points, i, temp);
		       array[i] = points[i].y;
		    }
		    
		    if(longest(array) == 1) return 0;
		    return longest(array);
		  }
		  
	 public int longest(int[] array) {
		    
		    // Write your solution here.
		    int length = array.length;
		    
		    if(length == 0) return 0;
		    int[] dp = new int[length];
		    dp[0] = 1;
		    int globalMax = 1;
		    
		    for(int i = 1; i < length; i++) {
		       int j = i - 1;
		       dp[i] = 1;
		       while(j >= 0) {
		         int subGlobal = 0;
		         if(array[i] > array[j] && (dp[j] + 1) > dp[i]) {
		           dp[i] = dp[j] + 1 > subGlobal ? dp[j] + 1 : subGlobal;
		         }
		         j--;
		       }
		       
		       if(dp[i] > globalMax) {
		         globalMax = dp[i];
		       }
		    }
		    
		    return globalMax;
		  }
		  
		  public void swap(Point[] points, int i, int j) {
		    Point temp = points[i];
		    points[i] = points[j];
		    points[j] = temp;
		  }
		  
		

}
