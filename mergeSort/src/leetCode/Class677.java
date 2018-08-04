package leetCode;

import java.util.HashMap;
import java.util.Map;

//Input: insert("apple", 3), Output: Null
//Input: sum("ap"), Output: 3
//Input: insert("app", 2), Output: Null
//Input: sum("ap"), Output: 5

public class Class677 {
	
	private TrieNode root;

	
	 /** Initialize your data structure here. */
    public Class677() {
    	this.root = new TrieNode();
    
        
    }
    
    public void insert(String key, int val) {
    	TrieNode currentNode = root;
        for(Character c : key.toCharArray()) {
        	if(currentNode.children.get(c) == null) {
        		currentNode.children.put(c, new TrieNode());
        	}
        	currentNode = currentNode.children.get(c);
        }
        currentNode.flag = true;
        currentNode.val = val;
    }
    
    public int sum(String prefix) {
    	int[] result = new int[0];
        for(Character c : prefix.toCharArray()) {
        	if()
        }
    }
    
    public void sumHelper(String prefix, int[] result, TrieNode node, int level) {
    	
    	if(node.flag) {
    		result[0] += node.val;
    	}
    	
		if(node.children.get(prefix.charAt(level)) != null) {
			sumHelper(prefix, result, node.children.get(prefix.charAt(level)), level++);
		}
    	
    } 

}

class TrieNode {
	public Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	public boolean flag = false;
	public int val;
}
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */