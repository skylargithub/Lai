package mainRun.other;

public class ClosetValue {

	  public static int closest(int[] array, int target) {
		    // Write your solution here
		    if(array == null || array.length == 0) return -1;
		    
		    int leftIndex = 0;
		    int rightIndex = array.length - 1;
		    int mid = 0;
		    
		    while(leftIndex < rightIndex - 1) {
		    	mid = leftIndex + (rightIndex - leftIndex)/2;
		      if(array[mid] == target) {
		        return mid;
		      } else if (array[mid] > target) {
		        rightIndex = mid;
		      } else {
		        leftIndex = mid;
		      }
		    }
		    
		    //post processing
		    if(Math.abs(array[leftIndex] - target) < Math.abs(array[rightIndex] - target)) return leftIndex;
		    else return rightIndex;
		  
		  }
}
