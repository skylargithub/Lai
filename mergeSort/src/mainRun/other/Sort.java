package mainRun.other;

public class Sort {

		  public int[] mergeSort(int[] array) {
		    
		    if (null == array || array.length == 0) return array;
		    // Write your solution here.
		    return mergeSortRecursion(array,0, array.length - 1);
		  }
		  
		  
		  public int[] mergeSortRecursion(int[] array_input, int left, int right) {
		    if(left == right) {
		        int[] singleArray = new int[1];
		        singleArray[0] = array_input[left];
		        return singleArray;
		    }
		    
		    
   		    int[] temp = new int[right - left + 1];
		    int mid = (right - left)/2 + left;
		    
		    int[] left_array = mergeSortRecursion(array_input,left,mid);
		    int[] right_array = mergeSortRecursion(array_input, mid+1, right);
		    temp = combine(left_array,right_array);
		    return temp;
		  }
		  
		  
		  
		  public int[] combine(int[] leftArray, int[] rightArray){
		    int leftSize = leftArray.length;
		    int rightSize = rightArray.length;
		    int[] finalArray = new int[leftSize + rightSize];
		    
		    int leftIndex = 0;
		    int rightIndex = 0;
		    
		    while(leftIndex < leftSize && rightIndex < rightSize){
		      if(leftArray[leftIndex] < rightArray[rightIndex]) {
		        finalArray[leftIndex+rightIndex] = leftArray[leftIndex];
		        leftIndex++;
		      } else {
		        finalArray[leftIndex+rightIndex] = rightArray[rightIndex];
		        rightIndex++;
		      }
		    }
		      
		      if(leftIndex == leftSize){
		        while(rightIndex < rightSize){
		          finalArray[leftIndex+rightIndex] = rightArray[rightIndex];
		          rightIndex++;
		        }
		      }else{
		        while(leftIndex < leftSize) {
		          finalArray[leftIndex+rightIndex] = leftArray[leftIndex];
		          leftIndex++;
		        }
		      }
		      return finalArray;
		    }
		    
		  
}
