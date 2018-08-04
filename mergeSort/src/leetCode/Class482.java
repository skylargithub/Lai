package leetCode;

public class Class482 {

	public String licenseKeyFormatting(String S, int K) {
	       int fast = S.length() - 1;
	       StringBuilder sb = new StringBuilder();
	       while(fast >= 0) {
	           int count = 0;
	           while(fast >= 0 && count < K) {
	               if(S.charAt(fast) != '-') {
	                   sb.insert(0, S.charAt(fast));
	                   count++;
	               }
	               fast--;
	           }
	           if(count > 0) sb.insert(0, '-');
	       }
	       return sb.substring(1, sb.length()).toUpperCase();
	}
	
	 public static void main(String[] args) {
	    	Class482 class482 = new Class482();
	    	class482.licenseKeyFormatting("--a-a-a-a--", 2);
	    	
	    	}
}
