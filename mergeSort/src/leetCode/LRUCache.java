package leetCode;

import java.util.HashMap;

public class LRUCache {
	
	 ListNode head;
	    ListNode tail;
	    int size;
	    int capacity;
	    HashMap<Integer, ListNode> map;

	    public LRUCache(int capacity) {
	        head = null;
	        tail = null;
	        size = 0;
	        this.capacity = capacity;
	        map = new HashMap<>();
	        
	    }
	    
	    public int get(int key) {
	        if(!map.containsKey(key)) return -1;
	        ListNode temp = map.get(key);
	        if(size == 1) return temp.value;
	        if(temp == head) {
	            head = head.next;
	            head.pre = null;
	        } else if(temp == tail){
	        	return  temp.value;
	        } else {
	            temp.pre.next = temp.next;
	            temp.next.pre = temp.pre;
	        }
	        tail.next = temp;
	        temp.next = null;
	        temp.pre = tail;
	        tail = tail.next;
	        return temp.value;
	    }
	    
	    public void put(int key, int value) {
	        if(capacity == 0) return;
	        if(map.containsKey(key)) {
	        	get(key);
	        	tail.value = value;
	        	return;
	        }
	        ListNode newNode = new ListNode(key, value);
	        
	        if(size == 0) {
	            head = newNode;
	            tail = newNode;
	            size++;
	            map.put(key, newNode);
	            return;
	        }
	        
	        size++;
	        tail.next = newNode;
	        newNode.pre = tail;
	        tail = tail.next;
	        if(size > capacity) {
	            map.remove(head.key);
	            head = head.next;
	            head.pre = null;
	            size--;
	        }

	        map.put(key, newNode);
	    }
	    

	    public static void main(String[] args) {
	    	LRUCache lrucache = new LRUCache(2);
	    	System.out.println(lrucache.get(2));
	    	lrucache.put(2, 6);
	    	System.out.println(lrucache.get(1));
	    	lrucache.put(1, 5);
	    	lrucache.put(1, 2);
	    	System.out.println(lrucache.get(1));
	    	
	    	System.out.println(lrucache.get(2));
	    	
	    	}
	}

	class ListNode {
	    ListNode pre;
	    ListNode next;
	    int value;
	    int key;
	    public ListNode(int key, int value) {
	        this.value = value;
	        this.key = key;
	    }

	    

}
