package leetCode;

public class Class240 {

	public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }
    
    public boolean search(int[][] matrix, int x1, int x2, int y1, int y2, int target) {
        if(x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0 || x1 > x2 || y1 > y2) return false;
        if(x1 > matrix.length  || x2 > matrix.length || 
        		y1 > matrix[0].length || y2 > matrix[0].length) return false;
        int x = (x2 - x1) / 2 + x1;
        int y = (y2 - y1) / 2 + y1;
        
        if(x1 == x2 && y1 == y2) {
            return matrix[x1][y1] == target ? true : false;
        }
        
        if(y1 == y2) {
        	if(matrix[x][y1] == target) return true;
            return matrix[x][y1] > target ? search(matrix, x1, x - 1, y1, y1, target) : search(matrix, x + 1, x2, y1, y1, target);
        }
        
        if(x1 == x2) {
        	if(matrix[x1][y] == target) return true;
            return matrix[x1][y] > target ? search(matrix, x1, x1, y1, y - 1, target) : search(matrix, x1, x1, y + 1, y2, target);
        }
        
        
        
        if(matrix[x][y] == target) {
            return true;
        } else if (matrix[x][y] > target) {
            return search(matrix, x1, x2, y1, y - 1, target) 
                || search(matrix, x1, x - 1, y, y2, target);
        } else {
            return search(matrix, x + 1, x2, y1, y2, target)
                || search(matrix, x1 , x, y + 1, y2, target);
        }
    }
}
