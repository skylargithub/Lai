package exercise;

import java.util.ArrayList;

/*一组电话号码格式是 123-456-7890 和 1234567890 这两种，让转换成456-123-7890， 电
话号很多要求用尽量小的空间，输入是str[] phoneNumbers
我想的是用如果第一种格式直接swap，第二种需要用额外空间构建新的str */
public class PhoneNumber {

	public static String[] phoneNumberReformat(String[] nums) {
		ArrayList<String> temp = new ArrayList<>();
		for(String str : nums) {
			String phoneNumber = null;
			if(str.charAt(3) == '-') {
				phoneNumber = str.substring(4, 7) + "-" 
						+ str.substring(0, 3) + "-"
						+ str.substring(8, 12);			
			} else {
				phoneNumber = str.substring(3, 6) + "-"
						+ str.substring(0, 3) + "-"
						+ str.substring(6, 10);
			}
			temp.add(phoneNumber);
		}
		return temp.toArray(new String[temp.size()]);
		
	}
	
	public static void main(String[] args) {
		String[] test = {"1234567890", "123-456-7890"};
		phoneNumberReformat(test);
	}
	
}
