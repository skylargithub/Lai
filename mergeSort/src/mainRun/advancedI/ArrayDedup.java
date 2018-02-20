package mainRun.advancedI;


//ArrayDedup stringReplace = new ArrayDedup();
//System.out.println(Arrays.toString(stringReplace.dedup(new int[]{1, 1, 2, 2, 2, 3 })));
import java.util.Arrays;
import java.util.Stack;

public class ArrayDedup {
	
	public int[] dedup(int[] array) {
	    // Write your solution here.
	    if(array.length <= 1) return array;
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(array[0]);
	    int i = 1;
	    while(i < array.length) {
 	      if(stack.size() == 0 || array[i] != stack.peek()) {
	        stack.push(array[i]);
	        i++;
	      } else {
	        while(i < array.length && array[i] == stack.peek()) {
	           i++;
	        }
	        stack.pop();
	      }
	    }
	    
	    int[] result = new int[stack.size()];
	    
	    
	    for(i = 0; i < result.length; i++) {
	       result[result.length - i - 1] = stack.pop();
	    }
	    return result;
	  }

}
