package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Class71 {

	public String simplifyPath(String path) {
        if(path == "/") return "/";
        //wrong Deque<String> stack = new Deque<String>();
        Deque<String> stack = new ArrayDeque<String>();
        int fast = 1;
        while(fast < path.length()) {
            if(path.charAt(fast) == '/') {
                fast++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            // while(path.charAt(fast) != '/') {
            while(fast < path.length() && path.charAt(fast) != '/') {
                sb.append(path.charAt(fast));
                fast++;
            }
            String command = sb.toString();
            //if(command != "") 
            if(!command.equals("")) {
                if(command.equals(".")) {
                //clear stack
                stack = new ArrayDeque<String>();
                } else if (command.equals("..")){
                    stack.pollFirst();
                } else {
                    stack.offerFirst("/" + command);
                }
            }
            
        }
        
        String res = "";
        for (String dir : stack) res = dir + res;
        return res.isEmpty() ? "/" : res;
        
     /*   if(stack.size() == 0) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            while(stack.size() != 0) {
                sb.append(stack.pollLast());
            }
            return sb.toString();
        } */
        
    }
}
