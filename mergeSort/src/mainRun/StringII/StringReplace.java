package mainRun.StringII;

//LongestString stringReplace = new LongestString();
	//	System.out.println(stringReplace.longest("aaaa"));
//System.out.println(stringReplace.replace("aaa", "a", "bb"));
import java.util.ArrayList;

/* 
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "dodododo", S = "dod", T = "abcd", input becomes "aoao"
 * */
public class StringReplace {
	
	public String replace(String input, String s, String t) {
	    if(s.length() >= t.length()) {
	    	return replaceShort(input, s, t);
	    }else{
	    	return replaceLong(input, s, t);
	    }
	 }
	
	public String replaceShort(String input, String s, String t) {
		char[] inputArray = input.toCharArray();
		int slow = 0;
		int fast = 0;
		while(fast < inputArray.length) {
			if(fast + s.length() <= inputArray.length && match(inputArray, fast, s)) {
				copy(inputArray,slow, t);
				slow += t.length();
				fast += s.length();
			} else {
				inputArray[slow] = inputArray[fast];
				fast++;
				slow++;
			}
		}
		
		return new String(inputArray, 0, slow);
		
	}
	
	public String replaceLong(String input, String s, String t) {
		char[] inputArray = input.toCharArray();
		int slow = 0;
		int fast = 0;
		int count = 0;
		ArrayList<Integer> matches = new ArrayList<Integer>();
		while(fast < inputArray.length) {
			if(fast + s.length() <= inputArray.length && match(inputArray, fast, s)) {
				count++;
				
				fast += s.length();
				matches.add(fast - 1);
			} else {
				fast++;
				slow++;
			}
		}
		
		char[] newArray = new char[input.length() + (t.length() - s.length()) * count];
		for(int i = 0; i < inputArray.length; i++) {
			newArray[i] = inputArray[i];
		}
		slow = newArray.length - 1;
		fast = inputArray.length - 1;
		int lastIndex = matches.size() - 1;
		
		
		while(fast >= 0) {
			if(fast - s.length() + 1>= 0 && fast == matches.get(lastIndex)) {
				copy(newArray,slow - t.length() + 1 , t);
				slow -= t.length();
				fast -= s.length();
				lastIndex--;
			} else {
				newArray[slow] = newArray[fast];
				fast--;
				slow--;
			}
		}
		return new String(newArray);
	}
	
	//copy target to slow position including slow
	public void copy(char[] array, int slow, String t) {
		for(int i = 0; i < t.length(); i++) {
			array[slow] = t.charAt(i);
			slow++;
		}
	}
	
	//check if substring starting from index fast, including fast, mathches source string
	public boolean match(char[] array, int fast, String s) {
		for(int i = 0; i < s.length(); i++) {
			if(array[fast] == s.charAt(i)) {
				fast++;
			} else {
				return false;
			}
		}
		return true;
	}
	


}
