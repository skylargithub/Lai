package mainRun.advancedIV;
/*	String str = "abab";
SubsetsII set = new SubsetsII();
SubsetsIIp p = new SubsetsIIp();
List<String> r = new ArrayList<String>();
List<String> l = new ArrayList<String>();
r = set.subSets(str);
l = p.subSets(str);
System.out.println(r.size());
System.out.println(l.size());
System.out.println(Arrays.toString(r.toArray()));
System.out.println(Arrays.toString(l.toArray())); */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	
	public List<String> subSets(String set) {
		List<String> result = new ArrayList<String>();
		if(set == null) return result;
		
		char[] arraySet = set.toCharArray();
		Arrays.sort(arraySet);
		StringBuilder sb = new StringBuilder();
		helper(arraySet, sb, 0, result);
		return result;
	}
	
	public void helper(char[] set, StringBuilder sb, int index, List<String> result) {
		if(index== set.length){
			result.add(sb.toString());
			return;
	
		}
		
		helper(set, sb.append(set[index]), index+1, result);
		sb.deleteCharAt(sb.length() - 1);
		while(index < set.length - 1 && set[index] == set[index+1]) {
			index++;
		}
		helper(set, sb, index + 1, result);
		
	}
}
