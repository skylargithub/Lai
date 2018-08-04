package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Class616 {
	
	public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();
        for(String word : dict) {
            int start = s.indexOf(word);
            int end = start + word.length() - 1;
            intervals.add(new Interval(start, end));
        }
        intervals = merge(intervals);
        StringBuilder sb = new StringBuilder();
        int i = 0; int j = 0;
        if(intervals.size() == 0) return s;
        Interval temp = intervals.get(0);
        while(i < s.length()) {
            if(temp == null || i != temp.start) {
                sb.append(s.charAt(i));
                i++;
            } else {
                sb.append("<b>");
                sb.append(s.substring(temp.start, temp.end + 1));
                sb.append("</b>");
                i = temp.end + 1;
                temp = ++j < intervals.size() ? intervals.get(j) : null;   
            }
        }
        
        return sb.toString();
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
            
        List<Interval> result = new ArrayList<>();
        Interval temp = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start <= temp.end + 1) {
                temp.end = Math.max(intervals.get(i).end, temp.end);
            } else {
                result.add(new Interval(temp.start, temp.end));
                temp = new Interval(intervals.get(i).start, intervals.get(i).end);
            }
        }
        //add the last interval is very important!!
        result.add(new Interval(temp.start, temp.end));
        return result;
    }
    
    class Interval{
        int start;
        int end;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static void main(String[] args) {
		   
    	Class616 class616= new Class616();
    	System.out.println(class616.addBoldTag("abcxyz123", new String[]{"abc", "123"}));
    	
    	}

}
