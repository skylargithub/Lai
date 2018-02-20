package mainRun.StringII;

//StringDecomII stringReplace = new StringDecomII();
//System.out.println(stringReplace.decompress("a0b0"));
public class StringDecomII {
	
	public String decompress(String input) {
	    // Write your solution here.
	  
	    
	    
	    char[] shortInput = input.toCharArray();
	    int slow = 0;
	    int sum = 0;
	    int count = 0;
	    for(int i = 0; i < input.length(); i++) {
		      if( i % 2 == 1) {
		    	  switch(shortInput[i]) {
		    		  case '0' : break;
		    		  case '1' : shortInput[slow] = shortInput[i - 1];
		    		  			 slow++;
		    		  			 break;
		    		  case '2' : shortInput[slow] = shortInput[i - 1];
		    		  			 slow++;
		    		  			 shortInput[slow] = shortInput[i - 1];
		    		  			 slow++;
		    		  			 break;
		    		  default:   shortInput[slow] = shortInput[i - 1];
		    		  			 slow++;
		    		  			 shortInput[slow] = shortInput[i];
		    		  			 slow++;
		    		  			 sum += shortInput[i] - '0';
		    		  			 count++;
		    		  			 break;
		    	  }
		      }
		 }	
	    
	    if(slow == 0) return "";
	    
	    char[] newInput = new char[slow + sum - count * 2];
	    
	    for(int i = 0; i < slow; i++) {
	      newInput[i] = shortInput[i];
	    }
	    
	    int fast = slow - 1;
	    slow = newInput.length - 1;
	   
	    while(fast >= 0) {
	    	if(newInput[fast] >= 'a' && newInput[fast] <= 'z') {
	    		newInput[slow] = newInput[fast];
	    		slow--;
	    		fast--;
	    		continue;
	    	}
	    	
	    	if(newInput[fast] >= '0' && newInput[fast] <= '9') {
	    		int countA = newInput[fast] - '0';
		         while(countA > 0) {
		           newInput[slow] = newInput[fast - 1];
		           countA--;
		           slow--;
		         }
		         fast = fast - 2;
		         continue;
	    	}
	    }
	    return new String(newInput);
	  }
	  
	

}
