package exercise;

import mainRun.util.ListNode;

public class ReverseString {

	public ListNode reverseList(ListNode head) {
        /*   if(head == null) return null;
           ListNode cur = head;
           ListNode pre = null;
           while(cur != null) {
               ListNode temp = cur.next;
               cur.next = pre;
               pre = cur;
               cur = temp;
           }
       
           return pre; */
       if(head == null) return null;
       if(head.next == null) return head;
       
       ListNode tempHead = reverseList(head.next);
       head.next.next = head;
       head.next = null;
       return tempHead;
       
   }
}
