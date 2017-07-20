package mainRun.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

import mainRun.util.GraphNode;

public class Biparity {
	 public boolean isBipartite(List<GraphNode> graph) {
		    // write your solution here
		    
		    HashSet<GraphNode> hashset = new HashSet<GraphNode>();
		    HashSet<GraphNode> b1 = new HashSet<GraphNode>();
		    HashSet<GraphNode> b2 = new HashSet<GraphNode>();
		    
		 for(GraphNode master: graph) {
		   if(!hashset.contains(master)){
		     Queue<GraphNode> q = new ArrayDeque<GraphNode>();
		     q.offer(master);
		     b1.add(master);
		     
		     while(q.size() != 0) {
		         GraphNode temp = q.poll();
		         hashset.add(temp);
		         boolean b1Flag = b1.contains(temp);
		         boolean b2Flag = b2.contains(temp);
		         for(GraphNode node: temp.neighbors) {
		           if(!hashset.contains(node) ){
		             if(b1Flag) {
		               if(b1.contains(node)) return false;
		               else b1.add(node);
		              } else {
		               if(b2.contains(node)) return false;
		               else b2.add(node);
		              }
		            q.offer(node);
		           }
		         }
		      }
		   }
		 }
		  return true;
		  }

}
