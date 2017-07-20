package mainRun.recursionII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
 * 	//int[][] matrix =  new int[][]{{1,2,3,4,5},{4,5,6,7,8,9},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24}};
	//	int[][] matrix =  new int[][]{{1,2,3,4},{5,6,7,8},{9, 10, 11, 12},{13,14,15,16}};
		int[][] matrix = new int[][]{{1},{2},{3}};
		SpiralOrderII spiralOrder = new SpiralOrderII();
		System.out.print(Arrays.toString(spiralOrder.spiral(matrix).toArray()));
 * 
 * */

public class SpiralOrderII {

	private List<Integer> result = new ArrayList<Integer>();
	  
	  public List<Integer> spiral(int[][] matrix) {
	    sprialRecursion(matrix, 0);
	    return result;
	  }
	  
	  public void sprialRecursion(int[][] matrix, int offset) {
	    int M = matrix.length;
	    int N = matrix[0].length;
	    List<Integer> temp = new ArrayList<Integer>();
	    
	    if( M - offset*2 <= 0 || N - offset*2 <= 0) return;
	    
	    
	    if(M - offset*2 == 1) {
	      for(int j=0; j < N - offset*2; j++){
	      temp.add(matrix[offset][j+offset]);
	      }
	      result.addAll(temp);
	      return;
	    }
	    
	    if(N - offset*2 == 1) {
	      for(int j=0; j < M - offset*2; j++) {
	      temp.add(matrix[j + offset][N - 1 - offset]);
	      }
	      result.addAll(temp);
	      return;
	    }

	    for(int j=0; j < N - 1 - offset*2; j++){
	      temp.add(matrix[offset][j+offset]);
	    }
	    
	    for(int j=0; j < M - 1 - offset*2; j++) {
	      temp.add(matrix[j + offset][N - 1 - offset]);
	    }
	    
	    for(int j=0; j < N - 1 - offset*2; j++) {
	      temp.add(matrix[M - offset - 1][N - 1 - j - offset]);
	    }
	    
	    for(int j=0; j < M - 1 - offset*2; j++) {
	      temp.add(matrix[M - 1 - j - offset][offset]);
	    }
	    
	    result.addAll(temp);
	    sprialRecursion(matrix, offset + 1);
	  }

}
