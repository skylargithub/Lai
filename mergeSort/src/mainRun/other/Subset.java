package mainRun.other;

import java.util.ArrayList;
import java.util.List;

/*	List<String> result = Subset.subSets("abc");
for(String str: result) {
	System.out.println(str);
}
*/
//	String[] strArray = new String[]{"a","a","a","b","b"};
	//	System.out.print(Arrays.toString(TopFrequency.topKFrequent(strArray, 2)));
public class Subset {
	
	  public static List<String> subSets(String set) {
		    List<String> finalSolution = new ArrayList<String>();
		    if (set == null) {
		      return finalSolution;
		    }
		    
		    if (set.equals("")) {
		      finalSolution.add("");
		      return finalSolution;
		    }
		    
		    StringBuilder sb = new StringBuilder(set);
		    StringBuilder solution = new StringBuilder();
		    FindSubset(sb, solution, 0, finalSolution);
		    
		    return finalSolution;
		  }
		  
		  public static void  FindSubset(StringBuilder sb, StringBuilder solution, int level, List<String> finalSolution) {
		    
		    // base case, level maxinum is 3, starting from level 0
		    if (level == sb.length()) {
		      finalSolution.add(new String(solution.toString()));
		      return;
		    }
		    
		    //recursive rule
		    //case 1 add
		    solution.append(sb.charAt(level));
		    FindSubset(sb, solution, level + 1, finalSolution );
		    solution.deleteCharAt(solution.length() - 1);
		    
		    //case 2 no add
		    FindSubset(sb, solution, level + 1, finalSolution);
		  }

}
