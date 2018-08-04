package exercise;

import java.util.ArrayList;
import java.util.List;

public class PrintOneAndZero {
	
	public static void print(char str[], int index, List<String> result)
    {
        if (index == str.length)
        {
            result.add(new String(str));
            return;
        }
 
        if (str[index] == '?')
        {
            // replace '?' by '0' and recurse
            str[index] = '0';
            print(str, index + 1, result);
             
            // replace '?' by '1' and recurse
            str[index] = '1';
            print(str, index + 1, result);
             
            // NOTE: Need to backtrack as string
            // is passed by reference to the
            // function
            str[index] = '?';
        }
        else
            print(str, index + 1, result);
    }
	
	public static void main (String[] args)
    {
        String input = "??00?101";
        char[] str = input.toCharArray();
        ArrayList<String> result = new ArrayList<String>();
        print(str, 0, result);
        for(String str1 : result) {
        	System.out.println(str1);
        }
    }

}
