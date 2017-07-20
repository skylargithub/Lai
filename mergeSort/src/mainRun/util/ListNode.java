package mainRun.util;

public class ListNode {

	 public int value;
	 public ListNode next;
	 public ListNode(int value) {
	 this.value = value;
	 next = null;
	 }
	public static ListNode fromArray(int[] is) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(is[0]);
		ListNode curr = head;
		for(int i=1; i< is.length; i++) {
			ListNode listNode = new ListNode(is[i]);
			curr.next = listNode;
			curr = curr.next;
			
		}
		return head;
	}
}
