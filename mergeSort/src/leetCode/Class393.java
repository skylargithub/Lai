package leetCode;

public class Class393 {
	
	public boolean validUtf8(int[] data) {
		int i = 0;
        while(i < data.length) {
        	int count = 0;
        	if(data[i] > 255) return false;
        	if((data[i] & 0b10000000) == 0) {i++; continue;}
        	else if((data[i] & 0b11100000) == 0b1100_0000)  count = 1;
        	else if((data[i] & 0b11110000) == 0b1110_0000)  count = 2;
        	else if((data[i] & 0b11111000) == 0b1111_0000)  count = 3;
        	else return false;
        	int j = i + 1;
        	for(j = i + 1; j < data.length && j <= i + count; j++) {
        		if(!helper(data[j])) return false;
        	}
        	if(j != i + count + 1) return false;
            i = j;
        }
        return true;
    }

	public boolean helper(int data) {
		return (data & 0b11_000_000)  == 0b10_000_000;
    }
	
	public static void main(String[] args) {
		   
    	Class393 class393= new Class393();
    	System.out.println(class393.validUtf8(new int[]{197, 130, 1}));
    	
    	}

}
