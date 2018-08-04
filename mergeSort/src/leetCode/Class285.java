package leetCode;

import mainRun.util.TreeNode;

public class Class285 {

	 TreeNode pre = null;
     TreeNode res = null;
   	 public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		   // TreeNode[] pre = new TreeNode[1];
		   // TreeNode[] res = new TreeNode[1];
	        helper(root, p);
	        return res;
	      
	    }
	    
	    public void helper(TreeNode cur, TreeNode target) {
	        if(cur == null) return;
	        
	        helper(cur.left, target);
	        if(pre == target) {
	            res = cur;
	        }
	        pre = cur;
	        helper(cur.right, target);
	    }
	    public static void main(String[] args) {
	    	Class285 class285 = new Class285();
	    	TreeNode root = new TreeNode(5);
	    	TreeNode left = new TreeNode(3);
	    	root.left = left;
	    	root.left.left = new TreeNode(2);
	    	root.left.right = new TreeNode(4);
	    	TreeNode temp = new TreeNode(1);
	    	root.left.left.left = temp;
	    	
	    	System.out.println(class285.inorderSuccessor(root, temp));
	    	}
}
