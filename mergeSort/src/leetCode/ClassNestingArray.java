package leetCode;

import java.util.HashSet;

public class ClassNestingArray {
	
	public int arrayNesting(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        int maxCount = 0;
        for(int i = 0; i < flag.length && !flag[i]; i++) {
            HashSet<Integer> hashset = new HashSet<Integer>();
            int temp = i;
            int count = 0;
            while(!hashset.contains(nums[temp])) {
                hashset.add(nums[temp]);
                flag[temp] = true;
                temp = nums[temp];
                count++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

}
