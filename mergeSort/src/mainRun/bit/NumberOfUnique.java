package mainRun.bit;

public class NumberOfUnique {
	
	  public static boolean allUnique(String word) {
		    // write your solution here
		    char[] input = word.toCharArray();
		    boolean[] test = new boolean[256];
		    for(int i = 0; i < input.length; i++) {
		       if(test[input[i]] == true) {
		         return false;
		       }
		       test[input[i]] = true;
		    }
		    return true;
		  }

}
