package mainRun.StringII;
//	RemoveSpace removeSpace = new RemoveSpace();
//	System.out.print(removeSpace.removeSpaces("abc          def"));
	
public class RemoveSpace {
	
	public String removeSpaces(String input) {
	    // Write your solution here.
	    if(input == null || input.length() <= 1) return input;
	    char[] str = input.toCharArray();
	    int slow = 0;
	    int fast = 1;
	    while(fast < str.length) {
	      if(str[fast] != str[slow]) {
	         slow++;
	         str[slow] = str[fast];
	         fast++;
	      } else if(str[fast] == str[slow] && str[fast] != ' ') {
	         slow++;
	         str[slow] = str[fast];
	         fast++;
	      } else {
	         fast++;
	      }
	      
	    }
	    
	    if(str[0] == ' ') {
	      fast = 1;
	    } else {
	      fast = 0;
	    }
	    if(slow == 0) return "";
	    if(str[slow] == ' ') slow--;
	    
	    return new String(str, fast, slow - fast + 1);
	  }

}
