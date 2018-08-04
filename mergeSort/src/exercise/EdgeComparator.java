package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class EdgeComparator implements Comparator<String>{

	@Override
	public int compare(String e1, String e2) {
		// TODO Auto-generated method stub
		if(e1.length() < e2.length()) return -1;
		else if (e1.length() > e2.length()) return 1;
		else return 0;
	}
	
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>(10, new EdgeComparator());
		PriorityQueue<String> pq1 = new PriorityQueue<String>(10, new Comparator<String>() {
			@Override
			public int compare(String e1, String e2) {
				// TODO Auto-generated method stub
				if(e1.length() < e2.length()) return -1;
				else if (e1.length() > e2.length()) return 1;
				else return 0;
			}
		});
	}

}
