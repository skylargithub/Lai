package leetCode;

public class Class151 {
	
	public static String reverseWords(String s) {     
        String temp = reverse(s);      
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < temp.length()) {
			if(temp.charAt(i) == ' ') {
                if(sb.length() > 0) {
                    String sbTemp = reverse(sb.toString());
                    result.append(sbTemp);
                    result.append(" ");
                }
				sb = new StringBuilder();
			} else {
				sb.append(temp.charAt(i));
			}
			i++;
		}
        if(temp.charAt(temp.length() - 1) == ' ') {
        	if(result.length() == 0) return "";
        	return result.substring(0, result.length() - 1);
           
        } else {
            result.append(reverse(sb.toString()));
        }
        
        
        if(result.length() == 0) return "";
       
		return result.substring(0, result.length());
        
    }
    
    
    
    public static String reverse(String s) {
        char[] sArray = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        char c = ' ';
        while(i < j) {
            c = sArray[i];
            sArray[i] = sArray[j];
            sArray[j] = c;
            i++;
            j--;
        }
        return new String(sArray);
    }
    
    public static void main(String[] args) {
    	System.out.print(reverseWords(" 1"));
	}

}
