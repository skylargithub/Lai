package mainRun.adcancedIII;

import java.util.Arrays;

import mainRun.util.TreeNode;

public class ReconstructPost {
	
	public TreeNode reconstruct(int[] post) {
	    // Write your solution here.
	    if (post == null || post.length == 0) return null;
	    int[] inorder = post.clone();
	    Arrays.sort(inorder);
	    return helper(post, 0, post.length - 1, inorder, 0, inorder.length - 1);
	  }
	  
	  public TreeNode helper(int[] post, int pleft, int pright, int[] inorder, int ileft, int iright) {
	    if(pleft == pright) {
	      return new TreeNode(post[pleft]);
	    }
	    
	    if(pleft > pright || ileft > iright) {
	      return null;
	    }
	    
	    TreeNode root = new TreeNode(post[pright]);
	    int rootIndex = findIndex(inorder, post[pright]);
	    int size = rootIndex - ileft;
	    
	    root.left = helper(post, pleft, pleft + size - 1, inorder, ileft, ileft + size - 1);
	    root.right = helper(post, pleft + size, pright - 1, inorder, ileft + size + 1, iright);
	    
	    return root;
	  }
	  
	  public int findIndex(int[] inorder, int target) {
	    for(int i = 0; i < inorder.length; i++) {
	    	if(inorder[i] == target) {
	    		return i;
	    	}
	    }
	    return -1;
	  }

}
