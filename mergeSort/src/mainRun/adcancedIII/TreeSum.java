package mainRun.adcancedIII;

/*TreeNode root = new TreeNode(5);
root.left = new TreeNode(3);
root.right = new TreeNode(8);

root.right.right = new TreeNode(11);
root.left.left = new TreeNode(1);
root.left.right = new TreeNode(4);

TreeSum treeSum = new TreeSum();
System.out.print(treeSum.exist(root, 11)); */

import java.util.HashSet;

import mainRun.util.TreeNode;

public class TreeSum {
	
	private int dp = 0;
	  private HashSet<Integer> hashset  = new HashSet<Integer>();
	  private boolean flag = false;
	  public boolean exist(TreeNode root, int target) {
	    targetHelper(root, target);
	    return flag;
	  }
	  
	  private void targetHelper(TreeNode root, int target) {
	    if(root == null || flag) return;
	    
	    dp += root.key;
	    hashset.add(dp);
	    if(hashset.contains(dp - target) || dp == target) {
	      flag = true;
	      return;
	    }
	    
	    targetHelper(root.left, target);
	    targetHelper(root.right, target);
	    
	    
	    hashset.remove(dp);
	    dp -= root.key;
	  }

}
