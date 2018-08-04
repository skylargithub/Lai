package leetCode;

public class Class490 {
	
	private int[][] maze;
    private int[] destination;
    private int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        this.dirs = dirs;
        this.maze = maze;
        this.destination = destination;
        boolean[] res = new boolean[1];
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        DFS(start[0], start[1], null, visited, res);
        return res[0];
    }
    
    public void DFS(int x, int y, int[] dir, boolean[][] visited, boolean[] res) {
        if(res[0]) return;
        if(x < 0 || x > maze.length - 1 || y < 0 || y > maze[0].length - 1 || visited[x][y] || maze[x][y] == 1) return;
        if(dir == null || (dir[0] == -1 && (x == 0 || maze[x - 1][y] == 1))
          ||(dir[0] == 1 && (x == maze.length - 1 || maze[x + 1][y] == 1))
          ||(dir[1] == -1 && (y == 0 || maze[x][y - 1] == 1))
          ||(dir[1] == 1 && (y == maze[0].length - 1 || maze[x][y + 1] == 1))) {
            if(x == destination[0] && y == destination[1]) {
                res[0] = true;
                return;
            }
            
            visited[x][y] = true;
            for(int[] dirTemp : dirs) {
                DFS(x + dirTemp[0], y + dirTemp[1], dirTemp, visited, res);
            }
            visited[x][y] = false;
        } else {
            DFS(x + dir[0], y + dir[1], dir, visited, res);
        }
    }
    
    public static void main(String[] args) {
		   
    	Class490 class490= new Class490();
    	System.out.println(class490.hasPath( new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[] {0,4}, new int[]{4,4}));
    	
    	}


}
