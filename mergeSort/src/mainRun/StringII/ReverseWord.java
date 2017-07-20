package mainRun.StringII;

public class ReverseWord {
	
	public static String reverseWords(String input) {
		   
	    if(input == null || input.length() == 0) return input;
	    char[] A = input.toCharArray();
	    
	    reverseSentence(A, 0, A.length - 1);
	    int slow = 0;
	    for(int i = 0; i < A.length; i++) {
	       if(A[i] == ' ') {
	         reverseSentence(A, slow, i - 1);
	         slow = i + 1;
	       }
	       
	       if(i == A.length - 1) {
	    	   reverseSentence(A, slow, i);
	       }
	    }
	  
	    return new String(A);
	  }
	  
	  public static void reverseSentence(char[] A, int start, int end) {
	     while(end > start) {
	       char temp = A[start];
	       A[start] = A[end];
	       A[end] = temp;
	       start++;
	       end--;
	     }
	  }

}
