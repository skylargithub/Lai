package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// input List<Edges>
public class Network {

	public HashMap<Character, List<Character>> buildGraph(List<Edge> edges) {
		HashMap<Character, List<Character>> graph = new HashMap<>();
		for(Edge edge : edges) {
			if(!graph.containsKey(edge.a)) graph.put(edge.a, new ArrayList<Character>());
			if(!graph.containsKey(edge.b)) graph.put(edge.b, new ArrayList<Character>());
			
			graph.get(edge.a).add(edge.b);
			graph.get(edge.b).add(edge.a);
		}
		return graph;
	}
	
	public boolean findFriend(List<Edge> edges, Character a, Character b) {
		HashMap<Character, List<Character>> graph = buildGraph(edges);
		boolean[] flag = new boolean[1];
		HashSet<Character> visited = new HashSet<>();
	
		transverse(graph, flag, a, visited, b);
		return flag[0];
		
	}
	
	public void transverse(HashMap<Character, List<Character>> graph, boolean[] flag, Character startPoint, HashSet<Character> visited,
			Character target) {
		visited.add(startPoint);
		if(flag[0]) return;
		
		for(Character c : graph.get(startPoint)) {
			if(!visited.contains(c) && !flag[0]) {
				flag[0] = c.equals(target);
				transverse(graph, flag, c, visited,target);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge('A','B'));
		edges.add(new Edge('B','C'));
		edges.add(new Edge('C','D'));
		edges.add(new Edge('E','F'));
		edges.add(new Edge('C','G'));
		edges.add(new Edge('D','X'));
		Network network = new Network();
		System.out.print(network.findFriend(edges, 'A', 'X'));
		
	}
}

class Edge {
	public Character a;
	public Character b;
	
	public Edge (Character a, Character b) {
		this.a = a;
		this.b = b;
	}
}
