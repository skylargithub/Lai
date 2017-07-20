package mainRun.other;

import mainRun.util.ListNode;

public class ReOrderList {

	public ListNode reorder(ListNode head) {
	    
	    if(head == null) return null;
	    
	    if(head.next == null) return head;
	    
	    // 1. Find node just before middle Node
	    ListNode middle = findMiddle(head);
	    // 2. Reverse second half of linedlist
	    ListNode newMiddle = reverseList(middle.next);
	    middle.next = null;
	    // 3. Merge First Half and Second Half list into one
	    ListNode newHead = mergeTwoList(head, newMiddle);
	    return newHead;
	  }
	
	//if even number N, return N/2
	  public ListNode findMiddle(ListNode head) {
	    ListNode slow = head;
	    ListNode fast = head;
	    ListNode prev = null;
	    
	    while(fast.next != null  ) {
	      prev = slow;
	      slow = slow.next;
	      fast = fast.next.next;
	      if(fast == null) break;
	    }
	    return prev;
	  }
	  
	  public ListNode reverseList(ListNode head) {
		    
		    if(head == null || head.next == null) return head;
		    
		    ListNode newHead = reverseList(head.next);
		    head.next.next = head;
		    head.next = null;
		    
		    return newHead;
		  }
		  
	  
	  public ListNode mergeTwoList(ListNode headOne, ListNode headTwo) {
		    
		    ListNode dummyNode = new ListNode(0);
		    
		    ListNode currOne = headOne;
		    ListNode currTwo = headTwo;
		    ListNode dummyIndex = dummyNode;
		    
		    while(currOne != null && currTwo != null) {
		      dummyIndex.next = currOne;
		      currOne = currOne.next;
		      dummyIndex.next.next = currTwo;
		      currTwo = currTwo.next;
		      dummyIndex = dummyIndex.next.next;
		    }
		    
		    if(currTwo != null)  dummyIndex.next = currTwo;
		   
		    return dummyNode.next;
		  }
		  
	  
	  
	  
}
