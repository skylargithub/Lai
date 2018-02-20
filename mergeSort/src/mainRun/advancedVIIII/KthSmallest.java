package mainRun.advancedVIIII;
//KthSmallest test = new KthSmallest();
//	System.out.print(test.kth(new int[]{1,2,3,4}, new int[]{5}, 5));
public class KthSmallest {
	
	public int kth(int[] a, int[] b, int k) {
	    // Write your solution here.
	    int aLeft = 0;
	    int bLeft = 0;
	    
	    if(a.length == 0) return b[k - 1];
	    if(b.length == 0) return a[k - 1];

	    return kthHelper(a, aLeft, b, bLeft, k);
	  }
	  
	  public int kthHelper(int[] a, int aLeft, int[] b, int bLeft, int k) {
	   
		 if(k == 1) {
			  if(aLeft > a.length - 1) return b[bLeft];
			  if(bLeft > b.length - 1) return a[aLeft];
			  
		      if(a[aLeft] > b[bLeft] ) return b[bLeft];
		      else return a[aLeft];
		 }
	    
	    int aTempIndex = aLeft + k/2 - 1;
	    int bTempIndex = bLeft + k - k/2 - 1;
	    
	    if(aTempIndex > a.length - 1){
	      int count = a.length - aLeft;
	      if(count == 0) {
	    		return b[bLeft + k - 1];
	    	}
	      aTempIndex = a.length - 1;
	      
	      if(a[aTempIndex] < b[bTempIndex]) {
		      aLeft = aTempIndex + 1;
		      k = k - k/2;
		  } else {
		      aTempIndex = aLeft + k - count - 1;
		      return a[aTempIndex];
		  }
	  
	      return kthHelper(a, aLeft, b, bLeft, k);
	    }
	    
	    if(bTempIndex > b.length - 1){
	    	int count = b.length - bLeft;
	    	if(count == 0) {
	    		return a[aLeft + k - 1];
	    	}
		    bTempIndex = b.length - 1;
		      
		      if(a[aTempIndex] < b[bTempIndex]) {
			      aLeft = aTempIndex + 1;
			      k = k - k/2;
			    } else {
			      aTempIndex = aLeft + k - count - 1;
			      return a[aTempIndex];
			    }
		  
		      return kthHelper(a, aLeft, b, bLeft, k);
	    }
	    
	    
	    if(a[aTempIndex] < b[bTempIndex]) {
	      aLeft = aTempIndex + 1;
	      k = k - k/2;
	    } else {
	      bLeft = bTempIndex + 1;
	      k = k/2;
	    }
	    
	    return kthHelper(a, aLeft, b, bLeft, k);
	    
	  }

}
