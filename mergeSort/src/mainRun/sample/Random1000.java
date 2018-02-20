package mainRun.sample;

public class Random1000 {
	
	public static int random1000() {
		int temp = 0;
		int temp1 = 0;
		 for(int i = 0; i <= 4; i++) {
		       temp1 += 4 * (5 ^ i);
		      temp = temp * 5 + 4;
		     }
		return 0;
	}

}
