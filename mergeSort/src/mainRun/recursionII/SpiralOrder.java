package mainRun.recursionII;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
	
	private List<Integer> result = new ArrayList<Integer>();
	  
	  public List<Integer> spiral(int[][] matrix) {
	    sprialRecursion(matrix, matrix.length);
	    return result;
	  }
	  
	  public void sprialRecursion(int[][] matrix, int size) {
	    int dimension = matrix.length;
	    List<Integer> temp = new ArrayList<Integer>();
	    int shift = (dimension - size)/2;
	    
	    if(size <= 0) return;
	    
	    if(size == 1) {
	      result.add(matrix[dimension/2][dimension/2]);
	      return;
	    }

	    for(int j=0; j < size - 1; j++){
	      temp.add(matrix[shift][j+shift]);
	    }
	    
	    for(int j=0; j < size - 1; j++) {
	      temp.add(matrix[j+shift][dimension-1-shift]);
	    }
	    
	    for(int j=0; j < size - 1; j++) {
	      temp.add(matrix[dimension-shift-1][dimension-1-j-shift]);
	    }
	    
	    for(int j=0; j < size - 1; j++) {
	      temp.add(matrix[dimension-1-j-shift][shift]);
	    }
	    
	    result.addAll(temp);
	    sprialRecursion(matrix, size - 2);
	  }

}
