package mainRun.advancedI;

import mainRun.util.TreeNode;

public class AnyNodeToAny {
	
//	TreeNode treeNode = new TreeNode(-100);
//	TreeNode treeNode1 = new TreeNode(2);
//	treeNode.left = treeNode1;
	
//	AnyNodeToAny anyNodeToAny = new AnyNodeToAny();
//	System.out.print(anyNodeToAny.maxPathSum(treeNode));
	  int maxValue;
	    
	    public int maxPathSum(TreeNode root) {
	        maxValue = Integer.MIN_VALUE;
	        maxPathDown(root);
	        return maxValue;
	    }
	    
	    private int maxPathDown(TreeNode node) {
	        if (node == null) return 0;
	        int left = Math.max(0, maxPathDown(node.left));
	        int right = Math.max(0, maxPathDown(node.right));
	        maxValue = Math.max(maxValue, left + right + node.key);
	        return Math.max(left, right) + node.key;
	    }

}
