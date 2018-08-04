package leetCode;
//one edit distance
public class Class161 {

	public boolean oneEdit(String s1, String s2) {
		int i = 0;
		int j = 0;
		int dis = 0;
		while(i < s1.length() && j < s2.length() && dis <= 1) {
			if(s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {
				dis++;
				if(s1.length() > s2.length()) {
					i++;
					continue;
				} else if (s1.length() < s2.length()) {
					j++;
					continue;
				} else {
					i++;
					j++;
				}
			}
		}
		
		return dis == 2 ? false : true;
	}
	
}
