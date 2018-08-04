package leetCode;

import java.util.Comparator;
import java.util.Stack;

public class Class383 {

	 public int lengthLongestPath(String input) {
	        String[] strs = input.split("\n");
	        Stack<String> stack = new Stack<>();
	        int globalMax = 0;
	        stack.push("dir");
	        for(int i = 1; i < strs.length; i++) {
	            String str = strs[i];
	            int count = 1;
	            int j = 0;
	            count += str.lastIndexOf("\t")+1;
	         /*   while(j < str.length()) {
	                if(("" + str.charAt(j)).equals("\t")) {
	                    count++;
	                    j++;
	                } else {
                     break;
	                }
	            } */
	            String temp = "/"+str.substring(str.lastIndexOf("\t")+1, str.length());
	            while(count <= stack.size()) {
	                stack.pop();
	            }
	            stack.push((stack.size() > 0 ? stack.peek() : "") + temp);
	            
	            if(temp.contains(".")) {
	                globalMax = Math.max(globalMax, stack.peek().length());
	            }
	            
	        }
	         return globalMax;
	    }
	 
	 public static void main(String[] args) {
		   
	    	Class383 class383= new Class383();
	    	System.out.println(class383.lengthLongestPath("dir\n    file.txt"));
	    	
	    	}

	

}
