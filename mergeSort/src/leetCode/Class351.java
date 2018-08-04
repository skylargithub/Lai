package leetCode;

public class Class351 {
	
	int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] directions = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1,2}, {-1, -2}, {-1, 2}, {1, -2}};
    int[][] jumpDirections = new int[][] {{0, -2}, {0, 2}, {2, 0}, {-2, 0}, {2, 2}, {-2, -2}, {-2, 2}, {2, -2}};
    
    public int numberOfPatterns(int m, int n) {
        int[] res = new int[1];
        boolean[] set = new boolean[10];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                DFS(matrix, i, j, m, n, set, 0, res);
            }
        }
        return res[0];
    }
    
    public void DFS(int[][] matrix, int i, int j, int m, int n, boolean[] set, int length, int[] res) {
        if(i >= 0 && i < 3 && j >= 0 && j < 3 && !set[matrix[i][j]]) {
            length++;
            if(length > n) return;
            if(length >= m) res[0]++;
            set[matrix[i][j]] = true;
            for(int[] direction : directions) {
                DFS(matrix, i + direction[0], j + direction[1], m, n, set, length, res);
            }

            for(int[] direction : jumpDirections) {
                int newX = i + direction[0] / 2;
                int newY = j + direction[1] / 2;
                if(newX >= 0 && newX < 3 && newY >= 0 && newY < 3 && set[matrix[newX][newY]]) {
                    DFS(matrix, i + direction[0], j + direction[1], m, n, set, length, res);
                }
            }
            set[matrix[i][j]] = false;
        }
    }
    
    public static void main(String[] args) {
    	Class351 class351 = new Class351();
    	System.out.println(class351.numberOfPatterns(2, 2));
    	}

}
