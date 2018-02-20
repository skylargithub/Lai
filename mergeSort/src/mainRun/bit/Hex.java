package mainRun.bit;

public class Hex {
	
	/*public String hex(int number) {
	    
	    if(number == 0) return "0x0";
	    
	    int x = number;
	    // Write your solution here.
	    StringBuilder stringBuilder = new StringBuilder();
	    
	    while (x > 0) {
	      int reminder = x % 16;
	      x = x / 16;
	      
	      if(reminder < 10) {
	        stringBuilder.append((char)('0' + reminder));
	      } else {
	        stringBuilder.append((char)('A' + (reminder - 10)));
	      }
	    }
	     stringBuilder.append("X0");
	    return stringBuilder.reverse().substring(0);
	  } */
	
	public String hex(int number) {
		String prefix = "0x";
		if(number == 0) return prefix + "0";
		
		StringBuilder sb = new StringBuilder();
		while(number > 0) {
			int rem = number % 16;
			if(rem < 10) {
				sb.append((char) ('0' + rem));
			}else {
				sb.append((char) (rem - 10 + 'A'));
			}
			number >>>= 4;
		}
		
		return prefix + sb.reverse().toString();
	}

}
