package leetCode;

import java.util.Stack;

public class Class394 {

	public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();) {
            if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                sb.append(s.charAt(i++));
            } else {
                int temp = 0;
                while(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    temp = temp * 10 + s.charAt(i++) - '0';
                }
                
                Stack<Character> stack = new Stack<>();
                stack.push(s.charAt(i++));
                StringBuilder s1 = new StringBuilder();
                while(stack.size() > 0) {
                    if(s.charAt(i) == '[') stack.push('[');
                    else if(s.charAt(i) == ']') stack.pop();
                    s1.append(s.charAt(i++));
                }
                s1.deleteCharAt(s1.length() - 1);  //remove last ]
                for(int j = 0; j < temp; j++) {
                    sb.append(decodeString(s1.toString()));
                }
            }
        }
        return sb.toString();
    }
	
	 public static void main(String[] args) {
		   
	    	Class394 class394 = new Class394();
	    	System.out.println(class394.decodeString("3[a]2[b4[F]c]"));
	    	
	    	}
	
	
}
