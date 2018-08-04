package leetCode;

import java.util.ArrayList;
import java.util.List;

public class SplitUtil {
	
	public static void split(String str) {
		
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while(i < str.length()) {
			if(str.charAt(i) == '/') {
				System.out.println(sb.toString());
				sb = new StringBuilder();
			} else {
				sb.append(str.charAt(i));
			}
			i++;
		}
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		split("d///c");
	}
	
}
