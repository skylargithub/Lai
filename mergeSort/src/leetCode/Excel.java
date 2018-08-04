package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel {
	
	 List<List<List<String>>>flag;
	    int[][] content;

	    public Excel(int H, char W) {
	        content = new int[H][W - 'A' + 1];
	        flag = new ArrayList<List<List<String>>>();
	        for(int i = 0; i < H; i++) {
	            flag.add(new ArrayList<List<String>>());
	            for(int j = 0; j < W - 'A' + 1; j++) {
	                flag.get(i).add(new ArrayList<String>());
	            }
	        }
	        
	    }
	    
	    public void set(int r, char c, int v) {
	        if(flag.get(r - 1).get(c - 'A').size() != 0) {
	        	
	            flag.get(r - 1).set((c - 'A'), new ArrayList<String>());
	        }
	        content[r - 1][c - 'A'] = v;
	        //any fomular refer to this cell needs to be updated;
	        for(int i = 0; i < flag.size(); i++) {
	            for(int j = 0; j < flag.get(0).size(); j++) {
	                if(helper(flag.get(i).get(j), r, c)) {
	                    sum(r, c, flag.get(i).get(j).toArray(new String[0]));
	                }
	            }
	        }
	        
	    }
	    
	    public int get(int r, char c) {
	        return content[r - 1][c - 'A'];
	        
	    }
	    
	    public int sum(int r, char c, String[] strs) {
	        int result = 0;
	        flag.get(r - 1).set((c - 'A'), Arrays.asList(strs));
	        for(String str : strs) {
	            if(!str.contains(":")) {
	                result += get(str.charAt(1) - '0', str.charAt(0));
	            } else {
	                result += calculate(str);
	                
	            }
	        }
	        return result;
	    }
	    
	    public boolean helper(List<String> strs, int r, char c) {
	        for(String str: strs) {
	            if(!str.contains(":") && str.charAt(0) == c && str.charAt(1) + "" == r + "") {
	                return true;
	            } else {
	                if(c <= str.charAt(3) && c >= str.charAt(0) && r <= str.charAt(4) - '0' && r >= str.charAt(1) - '0')
	                    return true;
	            }

	        }
	        return false;
	    }
	                   
	    public int calculate(String str) {
	        int sum = 0;
	        for(char c = str.charAt(0); c <= str.charAt(3); c++) {
	            for(int i = str.charAt(1) - '0'; i <= str.charAt(4) - '0'; i++) {
	                sum += get(i, c);
	            }
	        }
	        return sum;
	    }

}
