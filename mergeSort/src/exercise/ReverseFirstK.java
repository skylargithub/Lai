package exercise;

public class ReverseFirstK {

	public ListNode reverseList(ListNode head, int K) {
	if(K == 0) return head;
	   ListNode cur = head;
       while(K > 1) {
    	   cur = head.next;
    	   K--;
       }
       ListNode newHead = cur.next;
       cur.next = null;
       
       ListNode firstHead = reverse(head);
       cur = firstHead;
       while(cur.next != null) {
    	   cur = cur.next;
       }
       cur.next = newHead;
       return firstHead;
       
   }

}
