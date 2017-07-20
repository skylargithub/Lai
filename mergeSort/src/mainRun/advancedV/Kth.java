package mainRun.advancedV;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth {
	  public long kth(int k) {
		    Comparator<Point> pqCom = new PointComparator();
		    PriorityQueue<Point> pq = new PriorityQueue<Point>(5, pqCom); 
		    
		    pq.add(new Point(0,0,0));
		    Point p = new Point(0,0,0);
		    int count = 0;
		    while(count < k) {
		      p = pq.poll();
		      pq.add(new Point(p.x+1, p.y, p.z));
		      pq.add(new Point(p.x, p.y+1, p.z));
		      pq.add(new Point(p.x, p.y, p.z+1));
		      count++;
		    }
		    return p.product();
		  }
		  
		  class Point {
		    public int x;
		    public int y;
		    public int z;
		    
		    public Point(int x, int y, int z) {
		      this.x = x;
		      this.y = y;
		      this.z = z;
		    }
		    
		    public int product() {
		      return (int) (Math.pow(3, x) * Math.pow(5, y) * Math.pow(7, z));
		    }
		  }
		  
		  class PointComparator implements Comparator<Point> {
		    

			public int compare(Point e1, Point e2) {
				 if(e1.product() == e2.product()) {
			         return 0;
			       }
			       
			       return e1.product() > e2.product() ? 1 : -1;
			}
		  }
}
