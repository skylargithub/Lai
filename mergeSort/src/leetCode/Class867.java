package leetCode;

public class Class867 {
	
	 public int primePalindrome(int N) {
	        while(true) {
	            if(isPrime(N) && isPali(N)) {
	                return N;
	            }
	            N++;
	            if(N >= 10000000) N = 100000000;
	        }
	    }
	    
	    public boolean isPrime(int N) {
	        for(int i = 2; i <= (int) Math.sqrt(N); i++) {
	            if(N % i == 0) return false;
	        }
	        return true;
	    }
	    
	    public boolean isPali(int N) {
	        int res = 0;
	        int M = N;
	        while(N > 0) {
	            res = res * 10 + N % 10;
	            N = N / 10;
	        }
	        
	        return res == M;
	    }
	    
	    public static void main(String[] args) {
			   
	    	Class867 class867= new Class867();
	    	class867.primePalindrome(6);
	    	
	    	}

}
