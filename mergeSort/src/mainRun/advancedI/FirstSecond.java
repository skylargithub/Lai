package mainRun.advancedI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//FirstSecond stringReplace = new FirstSecond();
//System.out.println(Arrays.toString(stringReplace.largestAndSecond(new int[]{4, 2, 3, 5, 7, 9})));
public class FirstSecond {

	 public int[] largestAndSecond(int[] array) {
		    // Write your solution here.
		    // The first element is the largest number,
		    // the second element is the second largest number.
		 List<List<Integer>> input = new ArrayList<List<Integer>>();
		   for(int i = 0; i < array.length; i++) {
			   List<Integer> temp = new ArrayList<Integer>();
			   temp.add(array[i]);
			   input.add(temp);
		   }
		    
		    return helper(input);
		  }
		  
		  public int[] helper(List<List<Integer>> input) {
		    //base case
		    if(input.size() == 1) {
		      List<Integer> temp = input.get(0);
		      int largest = temp.get(0);
		      Collections.sort(temp);
		      int secondLargest = temp.get(temp.size() - 2);
		      
		      return new int[]{largest, secondLargest};
		    }
		    
		    List<List<Integer>> tempInput = new ArrayList<List<Integer>>();
		    int size = input.size();
		    int right = size % 2 == 0? size - 1 : size - 2;
		    int left = 0;
		    
		    while(left < right) {
		    	if(input.get(left).get(0) <= input.get(right).get(0)) {
		    		List<Integer> tempList = new ArrayList<Integer>();
		    		tempList.addAll(new ArrayList<Integer>(input.get(right)));
		    		tempList.add(input.get(left).get(0));
		    		tempInput.add(tempList);
		    	} else {
		    		List<Integer> tempList = new ArrayList<Integer>();
		    		tempList.addAll(new ArrayList<Integer>(input.get(left)));
		    		tempList.add(input.get(right).get(0));
		    		tempInput.add(tempList);
		    	}
		    	left++;
		    	right--;
		    }
		    
		    if(size % 2 != 0) {
		    	tempInput.add(new ArrayList<Integer>(input.get(size - 1)));
		    }
		    
		    return helper(tempInput);
		    
		    
		  }
}
