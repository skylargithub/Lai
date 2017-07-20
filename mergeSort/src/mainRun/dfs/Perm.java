package mainRun.dfs;

import java.util.List;

public class Perm {

	public static void permutation(String set, int level, List<String> finalResult) {
		char[] stringArray = set.toCharArray();
		
		if(level == stringArray.length-1) {
			finalResult.add(stringArray.toString());
		}
		
		for(int i = 0; i < stringArray.length - level; i++) {
			swap(stringArray, level, i);
			permutation(set, level+1, finalResult);
			swap(stringArray, level, i);
		}
	}

	private static void swap(char[] stringArray, int level, int i) {
		// TODO Auto-generated method stub
		
	}
}
