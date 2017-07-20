package mainRun.dfs;

import java.util.ArrayList;
import java.util.List;

public class Substring {
	
	
	//end start from length - 1; abc end = 2
	public static List<String> findSubstringPerm(char[] charArray, int end,List<String> finalResult) {
		
		
		if(end == 0) {
			finalResult.add(String.valueOf(charArray[0]));
			finalResult.add("");
			return finalResult;
		}
		
		findSubstringPerm(charArray, end - 1, finalResult);
		List<String> tempString = new ArrayList<String>();
		for(String str: finalResult) {
			String temp = new StringBuilder(str + String.valueOf(charArray[end])).toString();
			tempString.add(temp);
		}
		finalResult.addAll(tempString);
		
		return finalResult;
	}

}
