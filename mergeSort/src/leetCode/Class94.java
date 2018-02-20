package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import mainRun.util.TreeNode;

public class Class94 {

	public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode cur = root;
        while(cur != null) {
            stack.addFirst(cur);
            cur = root.left;
        }
        
        List<Integer> res = new ArrayList<Integer>();
        while(stack.size() > 0) {
            cur = stack.removeFirst();
            res.add(cur.key);
            
            if(cur.right != null) {
                cur = cur.right;
                while(cur != null) {
                    stack.addFirst(cur);
                    cur = cur.left;
                }
            }
              
        }
        return res;
    }
}
