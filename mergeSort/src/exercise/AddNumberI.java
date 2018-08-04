package exercise;

public class AddNumberI {
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode cur1 = l1;
	        ListNode cur2 = l2;
	        ListNode head = new ListNode(0);
	        ListNode cur = head;
	        int carry = 0;
	        while(cur1 != null || cur2 != null || carry > 0) {
	            int val1 = cur1 == null ? 0 : cur1.val;
	            int val2 = cur2 == null ? 0 : cur2.val;
	            int val = val1 + val2 + carry >= 10 ? val1 + val2 + carry - 10 : val1 + val2 + carry;
	            carry = (val1 + val2 + carry) / 10;
	            cur.next = new ListNode(val);
	            cur = cur.next;
	            if(cur1 != null) cur1 = cur1.next;
	            if(cur2 != null) cur2 = cur2.next;
	        }
	        return head.next;
	        
	    }

}

class ListNode {
	      int val;
	     ListNode next;
	      ListNode(int x) { val = x; }
	  }
