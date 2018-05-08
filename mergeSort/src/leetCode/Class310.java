package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

	     0  1  2
	      \ | /
	        3
	        |
	        4
	        |
	        5
	return [3, 4]*/

public class Class310 {
	
	    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    	LinkedList<HashSet<Integer>> graph = new LinkedList<HashSet<Integer>> ();
	    	for(int i = 0; i < n; i++)  graph.add(new HashSet<Integer>());
	    	for(int i = 0; i < edges.length; i++) {
	    		graph.get(edges[i][0]).add(edges[i][1]);
	    		graph.get(edges[i][1]).add(edges[i][0]);
	    	}
	    	//add start point
	    	Deque<Integer> queue = new ArrayDeque<Integer> ();
	    	for(int i = 0; i < graph.size(); i++) {
	    		if(graph.get(i).size() <= 1) {
	    			queue.addLast(i);
	    		}
	    	}
	    	//eat up all the leaves on the same level
	    	while(n > 2) {
	    		int size = queue.size();
	    		for(int i = 0; i < size; i++) {
	    			Integer node = queue.removeFirst();
		    		//remove node
		    		HashSet<Integer> neighbour = graph.get(node);
		    		for(Integer neighbourNode : neighbour) {
		    			graph.get(neighbourNode).remove(node);
		    			n--;
		    			if(graph.get(neighbourNode).size() == 1) {
		    				queue.addLast(neighbourNode);
		    			}
		    		}
	    		}
	    	}
	    	return new ArrayList(queue);
	    }
}


/*
for(int i = 0; i < edges.length; i++) {
	if(graph.get(edges[i][0]) == null) {
		graph.set(edges[i][0], new HashSet<Integer>());
	}
	
	graph.get(edges[i][0]).add(edges[i][1]);
	
	if(graph.get(edges[i][1]) == null) {
		graph.set(edges[i][1], new HashSet<Integer>());
	}
	graph.get(edges[i][1]).add(edges[i][0]);
}

*/
