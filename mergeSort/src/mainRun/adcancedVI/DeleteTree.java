package mainRun.adcancedVI;

//TreeCreation tree = new TreeCreation();
//TreeNode root = tree.treeNodeBuild();
//DeleteTree deletetree = new DeleteTree();
//deletetree.delete(root, 9);

import mainRun.util.TreeCreation;
import mainRun.util.TreeNode;

public class DeleteTree {
	public TreeNode delete(TreeNode root, int key) {
	    // Write your solution here.
	    if(root == null) {
	      return root;
	    }
	    if(root.key == key) {
	      //find the key
	      //case 1 node is leaf
	      if(root.left == null && root.right == null) {
	        return null;
	      }
	      
	      //case 2.1
	      if(root.left == null && root.right != null) {
	        return root.right;
	      }
	      
	      //case 2.2
	      if(root.right == null && root.left != null) {
	        return root.left;
	      }
	      
	      //case 3
	      if(root.right != null && root.left != null) {
	        //find smallest on right subtree 
	        TreeNode temp = findSmallest(root.right);
	        //delete smallest from right subtree
	        root.key = temp.key;
	        root.right = delete(root.right, temp.key);
	      }
	    }
	    
	    root.left = delete(root.left, key);
	    root.right = delete(root.right, key);
	    return root;
	  }
	  
	  public TreeNode findSmallest(TreeNode root) {
	    TreeNode cur = root;
	    while(cur.left != null) {
	       cur = cur.left;
	    }
	    return cur;
	  }

}
