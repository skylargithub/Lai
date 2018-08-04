package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class Class734 {
	
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        HashMap<String, HashSet<String>> map = null;
        map = build(pairs);
        
        if(words1.length != words2.length) return false;
        for(int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if(!word1.equals(word2)) {
                String key = word1.compareTo(word2) == -1 ? word1 : word2;
                String value = word1.compareTo(word2) == -1 ? word2 : word1;
                if(!map.containsKey(key) || !map.get(key).contains(value)) return false;
            }
        }
        return true;
    }
    
    public HashMap<String, HashSet<String>> build(String[][] pairs) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(String[] pair : pairs) {
            String str1 = pair[0];
            String str2 = pair[1];
            String key = str1.compareTo(str2) == -1 ? str1 : str2;
            String value = str1.compareTo(str2) == -1 ? str2 : str1;
            if(!map.containsKey(key)) map.put(key, new HashSet<String>());
            map.get(key).add(value);
        }
        return map;
    }
    
    public static void main(String[] args) {
    	Class734 class734 = new Class734();
    	String[] words1 = {"great","acting","skills"};
    	String[] words2 = {"fine","drama","talent"};
    	String[][] pairs = {{"great","fine"},{"drama","acting"},{"skills","talent"}};
    	class734.areSentencesSimilar(words1, words2, pairs);
    	
    	}

}
