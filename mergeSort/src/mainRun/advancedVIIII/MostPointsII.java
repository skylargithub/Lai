package mainRun.advancedVIIII;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;

import mainRun.util.Point;

//	Point[] point = new Point[]{new Point(0,0), new Point(1,1), new Point(2,2), new Point(2,3), new Point(2,2), new Point(2,2),new Point(2,2)};
//	Point[] point = new Point[]{new Point(1,1), new Point(1,1), new Point(1,1),new Point(2,2),new Point(2,2), new Point(2,3), new Point(3,3), new Point(3,4)};
//MostPointsII mostPoints = new MostPointsII();
//	System.out.print(mostPoints.most(point));

public class MostPointsII {
	
	public int most(Point[] points) {
	  
		int globalMax = 0;
		//pre-processing
		Hashtable<PointWrapper, Integer> hashTablePre =  new Hashtable<PointWrapper, Integer>();
		for(int i = 0; i < points.length; i++) {
			PointWrapper wa = new PointWrapper(points[i].x, points[i].y);
			if(hashTablePre.containsKey(wa)) {
				hashTablePre.put(wa, hashTablePre.get(wa) + 1);
			} else {
				hashTablePre.put(wa, 1);
			}
		}
		
		if(hashTablePre.size() == 1) return hashTablePre.get(new PointWrapper(points[0].x, points[0].y));
		
		Hashtable<Coordinate, HashSet<PointWrapper>> hashTable =  new Hashtable<Coordinate, HashSet<PointWrapper>>();
		Hashtable<Integer, HashSet<PointWrapper>> xhashTable =  new Hashtable<Integer, HashSet<PointWrapper>>();
		
		Point[] newPoint = new Point[hashTablePre.size()];
		int k = 0;
		for(Entry<PointWrapper, Integer> temp: hashTablePre.entrySet()) {
			newPoint[k] = temp.getKey();
			k++;
		}
		
		for(int i = 0; i < newPoint.length; i++) {
			for(int j = i + 1; j < newPoint.length; j++) {
				PointWrapper wa = new PointWrapper(newPoint[i].x, newPoint[i].y);
				PointWrapper wb = new PointWrapper(newPoint[j].x, newPoint[j].y);
				
				if(newPoint[i].x == newPoint[j].x && newPoint[i].y == newPoint[j].y){
					continue;
				} else if (newPoint[i].x == newPoint[j].x ) {
					if(!xhashTable.containsKey(newPoint[i].x)) {
						xhashTable.put(newPoint[i].x, new HashSet<PointWrapper>());
					}
					xhashTable.get(newPoint[i].x).add(wa);
					xhashTable.get(newPoint[i].x).add(wb);
				}else{
					float a = helperA(newPoint[i], newPoint[j]);
					float b = helperB(newPoint[i], newPoint[j]);
					Coordinate temp = new Coordinate(a, b);
					
					if(!hashTable.containsKey(temp)) {
						hashTable.put(temp, new HashSet<PointWrapper>());				
					}
					hashTable.get(temp).add(wa);
					hashTable.get(temp).add(wb);				
				}
			}
		}
		
		//post-processing
		for(Entry<Coordinate, HashSet<PointWrapper>> temp: hashTable.entrySet()) {
			int size = temp.getValue().size();
			for(Point point: temp.getValue()) {
				if(hashTablePre.containsKey(point)) {
					int value = hashTablePre.get(point);
					size = size + value - 1;
				}
			}
			globalMax = size > globalMax ? size : globalMax;
		}
		
		
		for(Entry<Integer, HashSet<PointWrapper>> temp: xhashTable.entrySet()) {
			int size = temp.getValue().size();
			for(Point point: temp.getValue()) {
				if(hashTablePre.containsKey(point)) {
					int value = hashTablePre.get(point);
					size = size + value - 1;
				}
			}
			globalMax = size > globalMax ? size : globalMax;
		}
	    return globalMax;
	  }
	
	public float helperA(Point a, Point b) {
		return (float)(a.y - b.y) / (float)(a.x - b.x);
	}
	
	public float helperB(Point a, Point b) {
		return (float)(a.x * b.y - b.x * a.y) / (float)(a.x - b.x);
	}
	
	
	class Coordinate {
		public float x;
		public float y;
		public Coordinate(float x, float y) {
		this.x = x;
		this.y = y;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Float.floatToIntBits(x);
			result = prime * result + Float.floatToIntBits(y);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordinate other = (Coordinate) obj;
			
			if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
				return false;
			if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
				return false;
			return true;
		}
		
		
	}
	
	class PointWrapper extends Point {
		
		public int x;
		public int y;
		
		public PointWrapper(int x, int y) {
			super(x, y);
			this.x = x;
			this.y = y;
			// TODO Auto-generated constructor stub
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
		
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PointWrapper other = (PointWrapper) obj;
		
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}

}

