package leetCode;

import java.util.ArrayList;
import java.util.HashSet;

public class Class207 {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < graph.length; i++) {
            if(!dfs(graph, i, set, visited)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(ArrayList[] graph, int node, HashSet<Integer> set, boolean[] visited) {
    	if(set.contains(node)) {
    		return false;
    	} else {
    		if(!visited[node]) {
    			visited[node] = true;
                set.add(node);
                for(int i = 0; i < graph[node].size(); i++) {
                    if(!dfs(graph, (int) graph[node].get(i), set, visited)) {
                    	return false;
                    }
                }
                set.remove(node);
    		}
    		return true;
    	}
    }

}
