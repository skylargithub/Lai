package mainRun.other;

public class BinarySearch {
	
	public static int BinSearch(int[] array, int target) {
		
		int leftIndex = 0;
		int rightIndex = array.length;
		int mid = 0;
		
		while ( leftIndex < rightIndex - 1) {
			mid = leftIndex + (rightIndex - leftIndex)/2;
		}
		
		
		//post processing
		if(array[leftIndex] == target) return leftIndex;
		else if (array[rightIndex] == target) return rightIndex;
		else return -1;
		
	}

}
