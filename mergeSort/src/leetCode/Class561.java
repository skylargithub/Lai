package leetCode;

public class Class561 {
	
	public int countArrangement(int N) {
        int[] res = new int[1];
        res[0] = 0;
        boolean[] visited = new boolean[N + 1];
        dfs(1, res, visited, N);
        return res[0];
    }
    
    public void dfs(int level, int[] count, boolean[] visited, int N) {
        if(level == N + 1) {
            count[0]++;
            return;
        }
        
        for(int i = 1; i <= N; i++) {
            if(!visited[i] && (i % level == 0 || level % i == 0)) {
                visited[i] = true;
                dfs(++level, count, visited, N);
                visited[i] = false;
            }
        }
    }

}
