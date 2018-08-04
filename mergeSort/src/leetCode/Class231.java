package leetCode;

public class Class231 {
	
	public static void main(String[] args) {
		Class231 class231 = new Class231();
		System.out.print(class231.isPowerOfTwo(-4));  
	}
	
	public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n < 0) n = -n;
        int count = 0;
        while( n != 0) {
        	count += n & 1;
        	n = n >> 1;
        }
        return count > 1 ? false: true;
    }

}
