package exercise;

public class PopulateRightPointer {
	
public void connect(TreeLinkNode root) {
        
        TreeLinkNode cur = root;
        while(cur != null) {
            TreeLinkNode levelHead = cur;
            while(cur != null) {
                if(cur.left != null) {
                    cur.left.next = cur.right;
                } else {
                    return;
                }
  
                if(cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                 cur = cur.next;
            }
            cur = levelHead.left;
        }
    }

}
