package exercise;

import java.util.ArrayList;

/*һ��绰�����ʽ�� 123-456-7890 �� 1234567890 �����֣���ת����456-123-7890�� ��
���źܶ�Ҫ���þ���С�Ŀռ䣬������str[] phoneNumbers
��������������һ�ָ�ʽֱ��swap���ڶ�����Ҫ�ö���ռ乹���µ�str */
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
