package mainRun.recursionII;

public class StringAbbMatch {

	public boolean match(String input, String pattern) {
	    // Write your solution here.
		char[] inputArray = input.toCharArray();
		char[] patternArray = pattern.toCharArray();
		
		return matchHelper(inputArray, patternArray, 0, 0);
	  }

	private boolean matchHelper(char[] inputArray, char[] patternArray, int up, int down) {
		//book
		//b2k
		
		if(up == inputArray.length && down == patternArray.length) {
			return true;
		} else if (up > inputArray.length - 1 || down > patternArray.length - 1 ) {
			return false;
		}
		
		String temp = "";
		
		if(isDigit(patternArray[down])) {
			while(down <= patternArray.length - 1 && isDigit(patternArray[down])  ) {
				temp = temp + patternArray[down];
				down++;
			}
		
			int number = Integer.parseInt(temp);
			return matchHelper(inputArray, patternArray, up + number, down);
		} else {
			if(inputArray[up] == patternArray[down]) {
				return matchHelper(inputArray, patternArray, up+1, down+1);
			} else {
				return false;
			}
		}
		
	}

	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
}
