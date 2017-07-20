package mainRun.other;

//ListNode head = ListNode.fromArray(new int[]{1,2,3});
//  reOrderList.reorder( ListNode.fromArray(new int[]{1,2,3}) );
//	  System.out.println(Arrays.toString(Kcloest.kClosest(array, 15, 3)));
public class Kcloest {
	
	 public static int[] kClosest(int[] array, int target, int k) {
		    // Write your solution here
		    
		   // if(array == null || array.length == 0) return -1;
		    
		    int leftIndex = 0;
		    int rightIndex = array.length - 1;
		    int mid = 0;
		    int targetIndex = 0;
		    int[] closetArray = new int[k];
		    
		    while(leftIndex < rightIndex - 1){
		      mid = leftIndex +(rightIndex - leftIndex)/2;
		      if(array[mid] == target) {
		        targetIndex = mid;
		        break;
		      } else if (array[mid] > target) {
		        rightIndex = mid;
		      } else {
		        leftIndex = mid;
		      }
		    }
		    
		    //post processing, determine cloest index of value
		    if(leftIndex >= rightIndex - 1){
		       if(Math.abs(array[leftIndex] - target) < Math.abs(array[rightIndex] - target)) targetIndex = leftIndex;
		       else targetIndex = rightIndex;
		    }
		    
		    int i = targetIndex;
		    int j = targetIndex;
		    closetArray[0] = array[targetIndex];
		    int m = 1;
		    
		    while(j-i < k-1 && i>=1 && j<=array.length - 2){
		      if(Math.abs(array[i-1] - target) < Math.abs(array[j+1] - target)) {
		        closetArray[m] = array[i-1];
		        i--;
		      } else {
		        closetArray[m] = array[j+1];
		        j++;
		      }
		      m++;
		    }
		    
		    if(j>array.length - 2){
		      while(j-i<k-1) {
		    	  closetArray[m] = array[i-1];
		    	  i--;
		    	  m++;
		      }
		    } 
		    
		    if(i<1) {
		    	 while(j-i<k-1) {
		    		 closetArray[m] = array[j+1];
			    	  j++;
			    	  m++;
			      }
		    }
		    
		    return closetArray;
		  }
}
