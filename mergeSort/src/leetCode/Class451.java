package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Class451 {
	
	public String frequencySort(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        int maxFre = 0;
        for(Character letter: s.toCharArray()) {
            if(hashmap.containsKey(letter)) {
                hashmap.put(letter, hashmap.get(letter) + 1);
            } else {
                hashmap.put(letter, 1);
            }
            maxFre = Math.max(maxFre, hashmap.get(letter));
        }
        
        List<Character> [] freArray = new List[maxFre + 1];
        for(Map.Entry<Character, Integer> entry: hashmap.entrySet()) {
            for(int i = entry.getValue(); i > 0; i--) {
                if(freArray[entry.getValue()] == null) {
                    freArray[entry.getValue()] = new LinkedList<Character>();
                } 
                    freArray[entry.getValue()].add(entry.getKey());
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = freArray.length - 1; i > 0; i--) {
            if(freArray[i] != null) {
            	Character[] test = freArray[i].toArray(new Character[0]);
            	for(Character letter: test) {
            		sb.append(letter);
            	}
            }
        }
        
        return sb.toString();
    }

}
