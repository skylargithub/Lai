package mainRun.advancedVII;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleHistogram {
	
	public int largest(int[] array) {
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int globalMax = -1;
		for(int i = 0; i < array.length; i++) {
			if(stack.isEmpty() || array[i] >= array[stack.peekFirst()]) {
				stack.offerFirst(i);
			} else {
				while(!stack.isEmpty() && array[i] < array[stack.peekFirst()]) {
					int temp = stack.pollFirst();
					int leftBorder = -5;
					if(stack.isEmpty()) {
						leftBorder = 0;
					} else {
						leftBorder = stack.peekFirst() + 1;
					}
					int rightBorder = i - 1;
					int size = (rightBorder - leftBorder + 1) * array[temp];
					globalMax = size > globalMax ? size : globalMax;
					
				}
				stack.offerFirst(i);
			}
		}
		int rightBoarder = stack.peekFirst();
		//post processing
		while(!stack.isEmpty()) {
			int temp = stack.pollFirst();
			int leftBoarder = -5;
			if(stack.isEmpty()) {
				leftBoarder = 0;
			} else {
				leftBoarder = stack.peekFirst() + 1;
			}
			
			int size = (rightBoarder - leftBoarder + 1) * array[temp];
			globalMax = size > globalMax ? size : globalMax;
		}
	    return globalMax;
	  }

}
