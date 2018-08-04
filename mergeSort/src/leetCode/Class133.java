package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import leetCode.Class212.Pair;

public class Class133 {
	
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if(node == null) return null;
	        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
	        HashMap<UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode>();
	        visited.put(node, root);
	        DFSHelper(node, root, visited);
	        return root;
	    }
	    
	    public void DFSHelper(UndirectedGraphNode node1, UndirectedGraphNode node2, HashMap<UndirectedGraphNode, UndirectedGraphNode> visited) {
	        if(node1 == null) return;
         
         if(visited.containsKey(node1)) {
             return visited.get(node1);
         }
	        
	        for(UndirectedGraphNode nhr : node1.neighbors) {
	            if(!visited.containsKey(nhr)) {
	                UndirectedGraphNode temp = new UndirectedGraphNode(nhr.label);
                 visited.put(nhr, temp);
	                node2.neighbors.add(temp);
	                DFSHelper(nhr, temp, visited);
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	    	Class133 class133 = new Class133();
	    	UndirectedGraphNode root = new UndirectedGraphNode(0);
	    	root.neighbors.add(new UndirectedGraphNode(0));
	    	root.neighbors.add(new UndirectedGraphNode(0));
	    	class133.cloneGraph(root);
	    	}
	    
	 
	    	  

}
