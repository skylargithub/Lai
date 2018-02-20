package amazonOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LabelPartition {

	public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, i);
            } else {
                if(i > map.get(c)) {
                    map.put(c, i);
                }
            }
        }
        
        int start = 0;
        int end = 0;
        int max = -1;
        while(end < S.length()) {
            Character c = S.charAt(end);
            max = Math.max(max, map.get(c));
            if(end == max) {
                int length = end - start + 1;
                start = end + 1;
                res.add(length);
            }
            end++;
        }
        return res;
    }
}
