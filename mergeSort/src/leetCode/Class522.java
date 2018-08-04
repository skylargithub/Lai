package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Class522 {
	
	public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str2.length() - str1.length();
            }
        });
        
        HashMap<String, Integer> duplicate = new HashMap<>();
        for(String str : strs) {
            if(!duplicate.containsKey(str)) duplicate.put(str, 0);
            duplicate.put(str, duplicate.get(str) + 1);
        }
        
        for(int i = 0; i < strs.length; i++) {
            if(duplicate.get(strs[i]) == 1) {
                //what if the first one is the answer?
                if(i == 0) return strs[i].length();
                for(int j = 0; j < i; j++) {
                    if(!isSub(strs[i], strs[j])) {
                        return strs[i].length();
                    } else {
                    	break;
                    }
                }
            }
        }
        
        return -1;
    }
    
    //false if not subString, garantee str1 <= str2
    public boolean isSub(String str1, String str2) {
        int i = 0;
        int j = 0;
        while(i < str2.length() && j < str1.length()) {
            if(str1.charAt(j) == str2.charAt(i)) j++;
            i++;
        }
        return j == str1.length() ? true: false;
    }

}
