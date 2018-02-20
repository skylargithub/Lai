package mainRun.adcancedVI;

import mainRun.util.TreeNode;

public class ClosestBinary {
	
	public int closest(TreeNode root, int target) {
	    // Write your solution here.
	    int[] nodeValue = new int[1];
	    helper(root, target, Integer.MAX_VALUE, nodeValue );
	    return nodeValue[0];
	  }
	  
	  public void helper(TreeNode root, int target, int closest, int[] nodeValue) {
	    if(root == null) {
	      return;
	    }
	    if(target == root.key) {
	      nodeValue[0] = root.key;
	      closest = 0;
	      return;
	    }
	    
	    if(target < root.key) {
	       if(root.key - target < closest) {
	         nodeValue[0] = root.key;
	         closest = root.key - target;
	       }
	        helper(root.left, target, closest, nodeValue);
	    } else {
	       if(target - root.key < closest) {
	         nodeValue[0] = root.key;
	         closest = target - root.key;
	       }
	        helper(root.right, target, closest, nodeValue);
	    }
	  } 

}
