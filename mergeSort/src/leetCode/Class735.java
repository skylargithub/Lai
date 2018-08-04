package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Class735 {
	
	public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(asteroids[0]);
        for(int i = 1; i < asteroids.length; i++) {
            if(stack.size() == 0 || stack.peekFirst() < 0 ) {
                stack.addFirst(asteroids[i]);
            } else {
                if(asteroids[i] > 0) {
                    stack.addFirst(asteroids[i]);
                } else { // peek > 0, asteroids < 0;
                    while(stack.size() > 0 && stack.peekFirst() > 0 && stack.peekFirst() + asteroids[i] < 0 ) {
                        stack.removeFirst();
                    }
                    if(stack.size() > 0 && stack.peekFirst() + asteroids[i] == 0) stack.removeFirst();
                    else if(stack.size() == 0 || stack.peekFirst() < 0) stack.addFirst(asteroids[i]); 
                }
            }
        }
        int[] result = new int[stack.size()];
        int i = result.length - 1;
        for(Integer number : stack) {
        	result[i] = number;
        	i--;
        }
       
        return result;
        
    }

}
