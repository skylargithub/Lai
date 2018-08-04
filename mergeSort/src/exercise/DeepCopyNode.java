package exercise;

public class DeepCopyNode {
	
	// Write your solution here.
    if(head == null) return null;
    RandomListNode newHead = new RandomListNode(head.value);
    HashMap<RandomListNode, RandomListNode> hashmap = 
    new HashMap<RandomListNode, RandomListNode>();
    
    hashmap.put(head, newHead);
    
    RandomListNode cur = head;
    RandomListNode newCur = newHead;
    while(cur != null) {
       if(cur.next != null) {
             if(!hashmap.containsKey(cur.next)) {
              RandomListNode temp = new RandomListNode(cur.next.value);
              newCur.next = temp;
              hashmap.put(cur.next, newCur.next);
             } else {
              newCur.next = hashmap.get(cur.next);
             }
       }
       
       if(cur.random != null) {
          if(!hashmap.containsKey(cur.random)) {
            RandomListNode temp = new RandomListNode(cur.random.value);
            newCur.random = temp;
            hashmap.put(cur.random, newCur.random);
          } else {
            newCur.random = hashmap.get(cur.random);
         }
       }
       
       cur = cur.next;
       newCur = newCur.next;
    }
    return newHead;
  }

}
