package exercise;

public class ColorSort {

public void sortColors(int[] nums) {
        
        // Write your solution here.
    if(nums.length == 0) return;
    int leftBorder = 0;
    int rightBorder = nums.length - 1;
    int currentIndex = 0;
    
    while(currentIndex <= rightBorder) {
      // 0 move left Index
      if(nums[currentIndex] == 0) {
        swap(nums,leftBorder, currentIndex);
        leftBorder++;
        currentIndex++;
        continue;
      }
      
      if(nums[currentIndex] == 1 ) {
        currentIndex++;
        continue;
      }
      
      if(nums[currentIndex] == 2) {
        swap(nums,currentIndex, rightBorder);
        rightBorder--;
        continue;
      }
    }
    
        
    }
    
     public void swap(int[] array, int left, int right) {
		    int temp = array[left];
		    array[left] = array[right];
		    array[right] = temp;
		  }
}
