package mainRun.advancedV;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LargestProduct {
	public int largestProduct(String[] dict) {
	    // Write your solution here.
		HashSet<StringPair> hashSet = new HashSet<StringPair>();
		HashMap<String, Integer> bitMasks = getBitMasks(dict);
		//sort desending order
		Arrays.sort(dict, new Comparator<String>(){

			public int compare(String s0, String s1) {
				if(s0.length() == s1.length()) return 0;
				return s0.length() < s1.length() ? 1 : -1;
			}
			
		});
		
		
		
		PriorityQueue<StringPair> pq = new PriorityQueue<StringPair>(5, new Comparator<StringPair>(){
			public int compare(StringPair o1, StringPair o2) {
				// TODO Auto-generated method stub
				if(o1.strLength() == o2.strLength()) return 0;
				return o1.strLength() < o2.strLength() ? 1 : -1;
			}
			
		});
		

		//initial s0, s1
		//generate <s0, s2>, <s1, s1>
		//when return break
		int i = 0;
		int j = 1;
		pq.add(new StringPair(dict[0], dict[1]));
		while(pq.isEmpty()) {
			//expand
			
			StringPair temp = pq.poll();
			
			//if node not in map
			if(!hashSet.contains(temp)) {
					
				hashSet.add(temp);
				//only if b[i] & b[j] == 0, they don't share same
				if((bitMasks.get(temp.str1) & bitMasks.get(temp.str2)) == 1) {
					return temp.strLength();
				}
				
				//generate <s0, s2>, <s1, s1>
				pq.add(new StringPair(dict[i], dict[j++]));
				pq.add(new StringPair(dict[i++], dict[j]));
			}
			
		}
		
	    return 0;
	  }

	private HashMap<String, Integer> getBitMasks(String[] dict) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String str: dict) {
			int bitMask = 0;
			for(int i = 0; i < str.length(); i++) {
				bitMask = bitMask | (1 << str.charAt(i) - 'a');
			}
			map.put(str, bitMask);
		}
		return map;
	}

	class StringPair {
		public String str1;
		public String str2;
		
		public StringPair(String str1, String str2) {
			this.str1 = str1;
			this.str2 = str2;
		}
		
		private Integer strLength() {
			return str1.length() * str2.length();
		}
		
	}
}
