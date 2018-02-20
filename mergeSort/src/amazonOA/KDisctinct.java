package amazonOA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Input: aba, k = 2
//Output: 3
// Possible substrings are {"ab", "ba", "aba"}
public class KDisctinct {
	
	public List<String> kDistinct(String S, int K) {
		List<String> res = new ArrayList<String>();
		HashSet<String> temp = new HashSet<String>();
		for(int i = 0; i < S.length(); i++) {
			int[] array = new int[26];
			for(int j = i; j < S.length(); j++) {
				int count = 0;
				if(array[S.charAt(j)] == 0) {
					count++;
				}
				array[S.charAt(j)]++;
				
				if(count == K) {
					temp.add(S.substring(i, j + 1));
				}
			}
		}
		
		return res;
	}
	
	//abacdefgefg
	public List<String> k1Distinct(String S, int K) {
		List<String> res = new ArrayList<String>();
		HashSet<String> hashset = new HashSet<String>();
		int[] cnt = new int[26];
		int distinctCount = 0;
	//	if(K > S.length()) {
	//		return res;
	//	} 
		
		int start = 0;
		int end = 0;
		while(end < S.length()) {
			cnt[S.charAt(end) - 'a']++;
			if(cnt[S.charAt(end) - 'a'] == 1) {
				distinctCount++;
			}
			
			if(end >= K) {
				cnt[S.charAt(start) - 'a']--;
				if(cnt[S.charAt(start) - 'a'] == 0) {
					distinctCount--;
				}
				start++;
			} 
			
			if(distinctCount == K && !hashset.contains(S.substring(start, end + 1))) {
				hashset.add(S.substring(start, end + 1));
				res.add(S.substring(start, end + 1));
			}

			end++;
		}
		
		return res;
	}
	

}
