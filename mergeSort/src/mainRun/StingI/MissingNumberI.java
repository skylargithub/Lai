package mainRun.StingI;

public class MissingNumberI {

	public int missing(int[] array) {
	    // Write your solution here.
	    int result = 0;
	    int i = 0;
	    for(i = 0; i < array.length; i++) {
	       result = result ^ array[i] ^ (i+1);
	    }
	    result = result ^ (i+1);
	    return result;
	  }
}
