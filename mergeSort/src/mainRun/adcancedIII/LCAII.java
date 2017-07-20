package mainRun.adcancedIII;

import mainRun.util.TreeNodeP;
//LCAII lcaII = new LCAII();
//System.out.print(lcaII.lowestCommonAncestor(N5, N6).key);

public class LCAII {
	
	 public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		    
		    if(one == null || two == null) return null;
		    // find root
		    TreeNodeP rootOne = one;
		    while(rootOne.parent != null) {
		      rootOne = rootOne.parent;
		    }
		    
		    TreeNodeP rootTwo = two;
		    while(rootTwo.parent != null) {
		      rootTwo = rootTwo.parent;
		    }
		    
		    if(rootOne != rootTwo) {
		      return null;
		    } else {
		      return helper(rootOne, one, two);
		    }
		   
		  }
		  
		  public TreeNodeP helper(TreeNodeP root, TreeNodeP one, TreeNodeP two) {
		    if(root == null) return null;
		    if(root == one || root == two) return root;
		    
		    TreeNodeP left = helper(root.left, one, two);
		    TreeNodeP right = helper(root.right, one, two);
		    
		    if(left != null && right != null) {
		      return root;
		    } else {
		      return left == null ? right : left;
		    }
		  }

}
