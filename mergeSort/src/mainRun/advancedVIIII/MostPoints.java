package mainRun.advancedVIIII;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;

import mainRun.util.Point;

//<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3
//(<0, 0>, <1, 1>, <3, 3> are on the same line)
// contains & containsKey
// HashMap implement equals and hashcode

public class MostPoints {
	
	public int most(Point[] points) {
	    // Write your solution here.
		// y = ax + b
		// a = (y1 - y2) / (x1 - x2)
		// b = (x1y2 - x2y1) / (x1- x2)
		//any points calculate a & b
		//hashtable <key = (a,b), value = number of points> Cn2  * 2 = X
		
		//pre processing
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
		int globalMax = 0;
		
		Hashtable<Coordinate, HashSet<PointWrapper>> hashTable =  new Hashtable<Coordinate, HashSet<PointWrapper>>();
		Hashtable<Integer, HashSet<PointWrapper>> xhashTable =  new Hashtable<Integer, HashSet<PointWrapper>>();
		
		Point[] newPoint = new Point[hashTablePre.size()];
		
		int k = 0;
		for(Entry<PointWrapper, Integer> temp: hashTablePre.entrySet()) {
			newPoint[k] = temp.getKey();
			k++;
		}
		
		points = newPoint;
		

		for(int i = 0; i < points.length; i++) {
			for(int j = i + 1; j < points.length; j++) {
				PointWrapper wa = new PointWrapper(points[i].x, points[i].y);
				PointWrapper wb = new PointWrapper(points[j].x, points[j].y);
				
				if(points[i].x == points[j].x && points[i].y == points[j].y){
					continue;
				} else if (points[i].x == points[j].x ) {
					if(!xhashTable.containsKey(points[i].x)) {
						xhashTable.put(points[i].x, new HashSet<PointWrapper>());
					}
					xhashTable.get(points[i].x).add(wa);
					xhashTable.get(points[i].x).add(wb);
				}else{
					float a = helperA(points[i], points[j]);
					float b = helperB(points[i], points[j]);
					Coordinate temp = new Coordinate(a, b);
					
					if(!hashTable.containsKey(temp)) {
						hashTable.put(temp, new HashSet<PointWrapper>());				
					}
					hashTable.get(temp).add(wa);
					hashTable.get(temp).add(wb);				
				}
			}
		}
		
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
			result = prime * result + getOuterType().hashCode();
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
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
				return false;
			if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
				return false;
			return true;
		}
		
		private MostPoints getOuterType() {
			return MostPoints.this;
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
			result = prime * result + getOuterType().hashCode();
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
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		private MostPoints getOuterType() {
			return MostPoints.this;
		}
		
		
		
	}

}

/*	Coordinate c = new Coordinate((float)1.0, (float)0.0);
Coordinate d = new Coordinate((float)1.0, (float)0.0);
System.out.println(c.hashCode());
System.out.println(d.hashCode());
System.out.println(c.equals(d)); */