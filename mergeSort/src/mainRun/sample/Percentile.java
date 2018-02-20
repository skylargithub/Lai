package mainRun.sample;

//List<Integer> temp = new ArrayList<Integer>();
//for(int i = 1; i <= 100; i++) {
//	 temp.add(i);
//}
//System.out.println(stringReplace.percentile95(temp));
import java.util.ArrayList;
import java.util.List;

public class Percentile {
	
	/* public int percentile95(List<Integer> lengths) {
		    // Write your solution here.
		    int[] bucket = new int[4096];
		    int count = 0;
		    for(int temp: lengths) {
		      bucket[temp]++;
		    }
		    
		    int i = 0;
		    while( count <= 0.95 * lengths.size()) {
		    	i++;
		       count += bucket[i];
		       
		    }
		    return i - 1;
		  } */
	 
	 
	 public int percentile95(List<Integer> lengths) {
		    // Write your solution here.
		    int[] bucket = new int[4097];
		    int count = 0;
		    for(int temp: lengths) {
		      bucket[temp]++;
		    }
		    
		    int i = 4097;
		    while( count <= 0.05 * lengths.size()) {
		    	  i--;
		       count += bucket[i];
		       
		    }
		    return i;
		  } 

}
