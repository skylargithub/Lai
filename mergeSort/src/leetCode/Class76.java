 package leetCode;

import java.util.HashMap;

public class Class76 {

	public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(Character c : t.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        
        int start = 0;
        int end = 0;
        int minStart = -1;
        int minEnd = -1;
        int minLength = s.length() + 1;
        int count = 0;
        while(end < s.length()) {
            char c = s.charAt(end);
          
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0) {
                    count++;
                }
            }
            //move left
            while(count == t.length()) {
                c = s.charAt(start);
                if(end - start + 1 < minLength) {
                    minStart = start;
                    minEnd = end;
                    minLength = end - start + 1;
                }
                
                if(map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if(map.get(c) > 0) {
                        count--;
                    }
                }
                start++;
            }
            end++;  
        }
        if(minStart >= 0) {
            return t.substring(minStart, minEnd + 1);
        } else {
            return "";
        }
    }
}
