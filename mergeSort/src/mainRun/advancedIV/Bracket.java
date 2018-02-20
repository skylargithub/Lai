package mainRun.advancedIV;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Bracket {

	
		  public List<String> validParentheses(int l, int m, int n) {
		    // Write your solution here.
		    int small = l;
		    int medium = m;
		    int large = n;
		    List<String> result = new ArrayList<String>();
		    StringBuilder temp = new StringBuilder();
		    Deque<String> stack = new ArrayDeque<String>();
		    helper(small, medium, large, result, temp, stack, (l + m + n) * 2);
		    
		    return result;
		  }
		  
		  public void helper(int smallLeft, int mediumLeft, int largeLeft,List<String> result,
		      StringBuilder temp, Deque<String> stack, int level) {
		            if(level == 0) {
		                  String tempResult = temp.toString();
		                  result.add(tempResult);
		                  return;
		            }
		            
		            
		            //add small
		            if(smallLeft > 0) {
		              temp.append("(");
		              smallLeft--;
		              stack.offerFirst("(");
		              level--;
		              helper(smallLeft, mediumLeft, largeLeft, result, temp, stack, level);
		              level++;
		              stack.pollFirst();
		              smallLeft++;
		              temp.deleteCharAt(temp.length() - 1);
		            }
		            
		            if(mediumLeft > 0) {
		              temp.append("[");
		              mediumLeft--;
		              stack.offerFirst("[");
		              level--;
		              helper(smallLeft, mediumLeft, largeLeft, result, temp, stack, level);
		              level++;
		              stack.pollFirst();
		              mediumLeft++;
		              temp.deleteCharAt(temp.length() - 1);
		            }
		            
		            if(largeLeft > 0) {
		              temp.append("{");
		              largeLeft--;
		              stack.offerFirst("{");
		              level--;
		              helper(smallLeft, mediumLeft, largeLeft, result, temp, stack, level);
		              level++;
		              stack.pollFirst();
		              largeLeft++;
		              temp.deleteCharAt(temp.length() - 1);
		            }
		            
		            if(stack.size() > 0) {
		              String bracket = stack.pollFirst();
		              if(bracket == "(") {
		                 temp.append(")");
		                 level--;
		                 helper(smallLeft, mediumLeft, largeLeft, result, temp, stack, level);
		                 level++;
		                 temp.deleteCharAt(temp.length() - 1);
		                 stack.offerFirst("(");
		              } else if (bracket == "[") {
		                 temp.append("]");
		                 level--;
		                 helper(smallLeft, mediumLeft, largeLeft, result, temp, stack, level);
		                 level++;
		                 temp.deleteCharAt(temp.length() - 1);
		                 stack.offerFirst("[");
		              } else {
		                 temp.append("}");
		                 level--;
		                 helper(smallLeft, mediumLeft, largeLeft, result, temp, stack, level);
		                 level++;
		                 temp.deleteCharAt(temp.length() - 1);
		                 stack.offerFirst("{");
		              }
		            }
		            
		      }
		

}
