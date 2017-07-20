package mainRun.util;

public class TreeCreation {

	public TreeNode treeNodeBuild() {
		
		TreeNode N1 = new TreeNode(1);
		
		TreeNode N2 = new TreeNode(9);
		
		TreeNode N3 = new TreeNode(12);
		TreeNode N4 = new TreeNode(2);
		TreeNode N5 = new TreeNode(3);
		TreeNode N6 = new TreeNode(14);
		
		
		N1.left = N2;
		N1.right = N3;
		
		N2.left = N4;
		N2.right = N5;
		
		N3.left = N6;
		
		return N1;
				
	}
	
	public TreeNodeP treeNodePbuild() {
TreeNodeP N1 = new TreeNodeP(1, null);
		
		TreeNodeP N2 = new TreeNodeP(9, N1);
		
		TreeNodeP N3 = new TreeNodeP(12, N1);
		TreeNodeP N4 = new TreeNodeP(2, N2);
		TreeNodeP N5 = new TreeNodeP(3, N2);
		TreeNodeP N6 = new TreeNodeP(14, N3);
		
		
		N1.left = N2;
		N1.right = N3;
		
		N2.left = N4;
		N2.right = N5;
		
		N3.left = N6;
				return N1;
	}
}
