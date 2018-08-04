package exercise;

import java.util.Stack;

public class AddNumberII {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int temp = 0;
        ListNode cur = new ListNode(0);
        
        while(!stack1.empty() || !stack2.empty() ) {
            if(!stack1.empty()) temp = temp + stack1.pop();
            if(!stack2.empty()) temp = temp + stack2.pop();
            cur.val = temp % 10;
            ListNode head = new ListNode(temp / 10);
            head.next = cur;
            temp = temp / 10;
            cur = head;
        }
        
        if(cur.val == 0) return cur.next;
        else return cur;
        
    }
    

}


/*public int helper(ListNode l1, ListNode l2, int level1, int level2) {
    if(l1 == null|| l2 == null) {
        return (l1 == null ? 0 £º l1.val) + (l2 == null ? 0  : l2.val)£»
    }
    if(level1 == 1 && level2 == 1) {
        return l1.val + l2.val;
    }
    
    if(level1 > level2) {
        helper(l1.next, l2, level1 - 1, level2);
    } else if (level2 > level1) {
        helper(l1, l2.next, level1, level2 - 1);
    } else {
        helper(l1.next, l2.next, level1 - 1, level2 - 1);
    }
    
    
}*/
