package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Class212 {
	
	public List<String> findWords(char[][] board, String[] words) {
        //build Trie
        TrieNode root = new TrieNode();
        for(String word : words) {
            insert(root, word);
        }
        
        HashSet<String> result = new HashSet<String>();
        HashSet<Pair> visited = new HashSet<Pair>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                DFS(board, i, j, result, visited, root, "");
            }
        }
        
        ArrayList<String> rs = new ArrayList<String>();
        for(String str : result) {
        	rs.add(str);
        }
        return rs;
    }
    
    public void DFS(char[][] board, int x, int y, HashSet<String> result, HashSet<Pair> visited, TrieNode root, String path) {
        if(root == null) {
            return;
        }
        if(root.flag) {
            result.add(new String(path));
        }
        
        int[][] directions = new int[][] {{-1,0}, {0, 1}, {1, 0}, {0, -1}}; 
        
        if(!(x  >= 0 && x <= board.length - 1&& 
                y  >= 0 && y  <= board[0].length - 1)) return;
        if(visited.contains(new Pair(x, y))) return;
                 
        if(root.neighbours[board[x][y] - 'a'] != null) {
            visited.add(new Pair(x, y));
            path += board[x][y];
            //for each direction
            for(int[] direction : directions) {
                    DFS(board, x + direction[0], y + direction[1], result, visited, root.neighbours[board[x][y] - 'a'], path);
            }
            visited.remove(new Pair(x, y));
        }
    }
    
    public class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

		
		public int hashCode() {
			
			int result = 31;
			
			result = 31 * result + x;
			result = 31 * result + y;
			return result;
		}

		
		public boolean equals(Object obj) {
			
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private Class212 getOuterType() {
			return Class212.this;
		}
        
        
    }
    class TrieNode {
        TrieNode[] neighbours = new TrieNode[26];
        boolean flag;
    }
    
    public void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            if(cur.neighbours[word.charAt(i) - 'a'] == null) {
                cur.neighbours[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.neighbours[word.charAt(i) - 'a'];
        }
        cur.flag = true;
    }

    public static void main(String[] args) {
	/*	String[] words = new String[]{"oath","pea","eat","rain"};
		char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},
    	{'i','h','k','r'},
		{'i','f','l','v'}}; */
    	String[] words = new String[]{"ba"};
    			char[][] board = new char[][]{{'a','b'}};
		
			Class212 class212 = new Class212();
			List<String> rs = class212.findWords(board, words);
			
				System.out.println(rs);
				
				HashSet<Pair> test = new HashSet<Pair>();
				
			
		//System.out.println(5);
		//System.out.println('B' - 'A');
	}
}
