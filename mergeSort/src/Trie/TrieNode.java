package Trie;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetCode.Class231;

public class TrieNode {
	
	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		root.insert("abc", root);
		//root.insert("abd", root);
		//root.insert("cbd", root);
		//root.print(root);
		System.out.print(root.searchWord("ab", root));
		
	}
	
	private static final int N = 26;
	public boolean flag = false;
	public TrieNode[] children = new TrieNode[N];
	
	public void insert(String str, TrieNode node) {
		for(Character c : str.toCharArray()) {
			if(node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			} 
			node = node.children[c - 'a'];
		}
		node.flag = true;
	}
	
	public boolean searchByPrefix(String prefix, TrieNode node) {
		for(Character c : prefix.toCharArray()) {
			if(node.children[c - 'a'] != null) {
				node = node.children[c - 'a'];
			} else {
				return false;
			}
			
		}
		return true;
	}
	
	public boolean searchWord(String word, TrieNode node) {
		for(Character c : word.toCharArray()) {
			if(node.children[c - 'a'] != null) {
				node = node.children[c - 'a'];
			} else {
				return false;
			}
		}
		return node.flag == true;
	}
	
	public void print(TrieNode root) {
		Deque<TrieNode> queue = new ArrayDeque<TrieNode>();
		queue.offerLast(root);
		while(queue.size() > 0) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TrieNode node = queue.pollFirst();
				for(int j = 0; j < 26; j++) {
					if(node.children[j] != null) {
						System.out.print((char) ('a' + j) + "     flag is  " + node.children[j].flag + "   ");
						queue.offerLast(node.children[j]);
					}
				}
			}
			System.out.println();
		}
		
	}
	
	

}

