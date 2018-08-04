package exercise;

public class MeetingRoomII {


	 public int minMeetingRooms(Interval[] intervals) {
		 
		 if(intervals == null || intervals.length == 0) return 0;
		 Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval arg0, Interval arg1) {
				return arg0.start - arg1.start;
			}
		 });
		 
		 PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		 minHeap.offer(intervals[0].end);
		 
		 for(int i = 1; i < intervals.length; i++) {
			 if(intervals[i].start >= minHeap.peek()) {
				 minHeap.poll();
			 } 
				 minHeap.offer(intervals[i].end);
		 }
		 
	     return minHeap.size();
	  }
}


class Interval {
    int start;
   int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
