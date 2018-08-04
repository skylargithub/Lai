package leetCode;

public class Class766 {
	
	 public boolean isToeplitzMatrix(int[][] matrix) {
	        int[] base = new int[matrix[0].length];
	        for(int row = 0; row < matrix.length; row++) {
	            for(int col = matrix[0].length - 1; col > 0; col--) {
	                if(row == 0) {
	                    base[col] = matrix[0][col];
	                    continue;
	                }
	                
	                if(col > 0) {
	                    if(matrix[row][col] == base[col - 1]) {
	                    	base[col] = base[col - 1];
	                    } else {
	                    	return false;
	                    }
	                }
	            }
	            base[0] = matrix[row][0];
	        }
	        return true;
	    }
	 
	 public static void main(String[] args) {
	    	Class766 class766 = new Class766();
	    	System.out.println(class766.isToeplitzMatrix(new int[][]{{1,2,3},{0,1,2}}));
	    	}

}
