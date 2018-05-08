package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Class816 {
	
	 public List<String> ambiguousCoordinates(String S) {
	        ArrayList<String> rs = new ArrayList<String>();
	        List<String> sb = new ArrayList<String>();
	        dfs(S.substring(1, S.length() - 1), 0, sb, 0, rs);
	        return rs;
	    }
	    
	    public void dfs(String s, int level, List<String> sb, int start, ArrayList<String> rs) {
	        
	        if(level == 3) {
	        	sb.add(s.substring(start, s.length()));
	            rs.add(buildString(sb));
	            sb.remove(sb.size() - 1);
	            return;
	        }
	        
	        if(level == 0) {
	             for(int i = start; i < s.length() - 1; i++) {
	                 if(i == start || (i - start > 0 && s.charAt(start) != '0')) { // has to be a valid decimal
	                     sb.add(s.substring(start, i + 1));
	                     sb.add(".");
	                     dfs(s, level + 1, sb, i, rs);
	                     sb.remove(sb.size() - 1);
	                     sb.remove(sb.size() - 1);
	                 }
	             }
	        }
	        
	        if(level == 1) {
	            for(int i = start; i < s.length() - 1; i++) {
	                 if(i == start) {
	                     //remove decimal
	                	 sb.remove(sb.size() - 1);
	                 } else {
	                     //add string between decimal to comma;
	                	 sb.add(s.substring(start, i + 1));
	                 }
	                 sb.add(", ");
	                 dfs(s, level + 1, sb, i, rs);
	                 if(i == start) {
	                	//add decimal
	                	 sb.add(".");
	                 } else {
	                     sb.remove(sb.size() - 1);
	                 }
	             }
	        }
	        
	        if(level == 2) {
	        	for(int i = start; i < s.length() - 1; i++) {
	        		 if(i == start) dfs(s, level + 1, sb, i + 1, rs);
	                 if(i - start > 0 && s.charAt(start) != '0') { // has to be a valid decimal
	                     sb.add(s.substring(start + 1, i + 1));
	                     sb.add(".");
	                     dfs(s, level + 1, sb, i, rs);
	                     sb.remove(sb.size() - 1);
	                     sb.remove(sb.size() - 1);
	                 }
	             }
	        	
	        }
	       
	    }
	    
	    public String buildString(List<String> strs) {
	    	StringBuilder sb = new StringBuilder();
	    	for(String str : strs) {
	    		sb.append(str);
	    	}
	    	return sb.toString();
	    }

}
