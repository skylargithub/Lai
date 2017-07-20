package mainRun.advancedIV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIIp {

	public List<String> subSets(String set) {
	    // Write your solution here.
	    List<String> result = new ArrayList<String>();
		if(set == null) return result;
	
		char[] str = set.toCharArray();
		Arrays.sort(str);
		StringBuilder temp = new StringBuilder();
		helper(str, 0, temp, result);
	    return result;
	  }
	
	public void helper(char[] str, int level, StringBuilder temp, List<String> result) {
		if(level == str.length) {
			result.add(temp.toString());
			return;
		}
		
		temp.append(str[level]);
		helper(str, level+1, temp, result);
		
		temp.delete(temp.length() - 1 , temp.length());
		while(level < str.length - 1 && str[level+1] == str[level]) {
			level++;
		}
		helper(str, level+1, temp, result);
	} 
}
