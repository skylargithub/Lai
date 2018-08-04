package leetCode;

import java.util.Stack;

public class Class150 {

	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer> ();
        for(String str : tokens) {
            if(!(str == "*" || str == "/" || str.equals("+") || str == "-")) {
                stack.push(Integer.parseInt(str));
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int result = 0;
                switch (str) {
                    case "*":  result = val2 * val1;
                             break;
                    case "/":  result = val2 / val1;
                             break;
                    case "+":  result = val2 + val1;
                             break;
                    case "-":  result = val2 - val1;
                             break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
	
	public static void main(String[] args) {
		evalRPN(new String[]{"2", "5", "+"});
	}
}
