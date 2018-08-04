package exercise;

import java.util.ArrayList;

public class CountingSort {

	public static void count(int[] nums, int K) {
		int[] count = new int[K + 1];
		for(int num : nums) {
			count[num]++;
		}
		
		int index = 0;
		for(int i = 1; i < count.length; i++) {
			for(int j = 0; j < count[i]; j++) {
				nums[index] = i;
				index++;
			}
		}
		
	}
	
	public static void main (String[] args)
    {
        int[] nums = new int[] {1, 1, 1, 1, 2, 5, 4, 10};
        count(nums, 10);
        for(int num : nums) {
        	System.out.println(num);
        }
    }
}
