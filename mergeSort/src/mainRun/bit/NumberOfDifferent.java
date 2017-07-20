package mainRun.bit;

public class NumberOfDifferent {
	
	public static int diffBits(int a, int b) {
	    // Write your solution here.
	     int c = a ^ b;
	     int count = 0;
	     while( c != 0) {
	        if((c & 1) == 1  ) {
	          count++;
	        }
	        c >>>= 1;
	     }
	    return count;
	  }

}
