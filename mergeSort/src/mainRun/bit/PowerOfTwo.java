package mainRun.bit;

public class PowerOfTwo {
	
	public static boolean isPowerOfTwo(int number) {
	    // Write your solution here.
		if( number < 0) {
	    return (number*(-1) & (number*(-1) - 1)) == 0;
	  	} else {
		 return ((number & (number - 1)) == 0 && (number != 0));
	  	}
	}

}
