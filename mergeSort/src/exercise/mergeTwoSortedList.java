package exercise;

public class mergeTwoSortedList {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;
        ListNode cur = dummyHead;
        while(l1Cur != null || l2Cur != null) {
            if(l1Cur == null) {
                cur.next = l2Cur;
                l2Cur = l2Cur.next;
                cur = cur.next;
                continue;
            }
            
            if(l2Cur == null) {
                cur.next = l1Cur;
                l1Cur = l1Cur.next;
                cur = cur.next;
                continue;
            }
            
            if(l1Cur.val < l2Cur.val) {
                cur.next = l1Cur;
                l1Cur = l1Cur.next;
            } else {
                cur.next= l2Cur;
                l2Cur = l2Cur.next;
            }
            cur = cur.next;
        }
        
        
        cur.next = null;
        return dummyHead.next;
        
    }
}
