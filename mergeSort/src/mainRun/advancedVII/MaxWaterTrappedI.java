package mainRun.advancedVII;
//{2, 1, 3, 2, 4}
public class MaxWaterTrappedI {
	public int maxTrapped(int[] array) {
	    // Write your solution here.
		int[] dpLeftToRight = new int[array.length];
		int[] dpRightToLeft = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			if(i == 0) {
				dpLeftToRight[i] = array[i];
			} else {
				if(array[i] > dpLeftToRight[i - 1]) {
					dpLeftToRight[i] = array[i];
				} else {
					dpLeftToRight[i] = dpLeftToRight[i - 1];
				}
			}
		}
		
		for(int i = array.length - 1; i >= 0; i--) {
			if(i == array.length - 1) {
				dpRightToLeft[i] = array[i];
			} else {
				if(array[i] > dpRightToLeft[i + 1]) {
					dpRightToLeft[i] = array[i];
				} else {
					dpRightToLeft[i] = dpRightToLeft[i + 1];
				}
			}
		}
		
		int globalMax = 0;
	    for(int i = 1; i < array.length - 1; i++){
	    
	    	int height = 0;
	    	
	    	
	    		height = Math.min(dpLeftToRight[i - 1], dpRightToLeft[i + 1]) - array[i];
	
	    	if(height > 0) {
	    		globalMax = height  + globalMax;
	    	}
	    }
	    
	    return globalMax;
	  }
}
