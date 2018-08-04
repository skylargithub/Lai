package leetCode;

import mainRun.util.TreeNode;

public class Class461 {
	
	public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int sum = 0;
        for(int i = 0; i < 32; i++) {
            sum += (z >> i) & 1;
        }
        return sum; 
    }
	
	public static void main(String[] args) {
    	Class461 class461 = new Class461();
    	class461.hammingDistance(3, 1);
    	}

}
