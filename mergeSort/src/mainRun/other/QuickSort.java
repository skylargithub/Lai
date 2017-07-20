package mainRun.other;

public class QuickSort {
	 public int[] quickSort(int[] array) {
		    // Write your solution here
		    
		    if(array == null  || array.length == 0 || array.length == 1) return array;
		    return sortRecursion(array, 0, array.length - 1);
		  }
		  
		  //right is right most index
		  //left is left most index
		  public int[] sortRecursion(int[] array, int left, int right) {
		    //1. select right most number as pivot
		    
		    if(right - left == 1 || right == left)  {
		      if(array[right] < array[left]) swap(array,left,right);
		      return array;
		    }
		    
		    if(left > right) return array;
		    
		    int pivot = array[right];
		    int leftIndex = left;
		    int rightIndex = right-1;
		    int pivotIndex = 0;
		    while(rightIndex - leftIndex >= 0) {
		      if(array[leftIndex] < pivot) {
		        leftIndex++;
		      } else {
		        swap(array,leftIndex,rightIndex);
		        rightIndex--;
		      }
		    }
		    
		    if(leftIndex > rightIndex) {swap(array,leftIndex,right); pivotIndex = leftIndex;}
		    else {swap(array, rightIndex, right); pivotIndex = rightIndex; }
		    

		    sortRecursion(array, left, pivotIndex-1);
		    sortRecursion(array, pivotIndex+1, right);
		    return array;
		    
		  }
		  
		  public void swap(int[] array, int left, int right) {
		    int temp = array[left];
		    array[left] = array[right];
		    array[right] = temp;
		  }
}
