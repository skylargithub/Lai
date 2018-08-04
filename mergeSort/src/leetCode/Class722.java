package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import leetCode.Class212.Pair;

public class Class722 {
	
	public List<String> removeComments(String[] source) {   
        List<String> result = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        String start = "";
       for(String str : source) {
            for(int i = 0; i < str.length(); i++) {
               if(i == str.length() - 1) {
            	   if(start != "/*") temp.append(str.charAt(i));
            	   continue;
            	   
               }
               if(start == "/*") {
                   if(str.charAt(i) == '*' && str.charAt(i + 1) == '/') {
                       start = "";
                       i++;
                   }
                   continue;
               }
               
               if(str.charAt(i) == '/' && str.charAt(i + 1) == '/') {
                   break;
               } 
               
               if(str.charAt(i) == '/' && str.charAt(i + 1) == '*') {
                   start = "/*";
                   i++;
               } else {
                   temp.append(str.charAt(i));
               }
           }
           
           if(start == "/*") continue;
           if(temp.length() != 0 ) {
               result.add(new String(temp));
               temp = new StringBuilder();
           }
       }
       return result;
      
  }
	
	public static void main(String[] args) {
		String[] words = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
			
				Class722 class722 = new Class722();
				List<String> rs =  class722.removeComments(words);
				
					System.out.println(rs);
					
		
		}

}
