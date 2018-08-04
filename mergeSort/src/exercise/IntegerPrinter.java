package exercise;

public class IntegerPrinter {
	
	public static void print(int n) throws Exception {
		while(n > 0) {
			int m = n % 10;
			n = n / 10;
			System.out.println(m);
			throw new Exception("invalid");
		} 
	/*	if(n < 0) n = -n;
		if(n >= 10) {
			print(n / 10);
		} 
		
		System.out.println(n % 10); */
	}
	
	public static void main(String[] args) {
		print(3034);
		//System.out.println(5);
		//System.out.println('B' - 'A');
	}

}
