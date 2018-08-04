package reservation;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Table {
	
	private int size;
	private int id;
	private List<Map.Entry<Integer, Integer>> reservationTime;
	
	public boolean reserve(Request request) {
		//check if there is open slot
		for(int i = 0; i < reservationTime.size(); i++) {
			Map.Entry<Integer, Integer> reservation = reservationTime.get(i);
			if(startTime > reservation.getValue()) {
				if(i < reservationTime.size() - 1) {
					if(startTime + 2 < reservationTime.get(i + 1).getValue()) {
						reservationTime.add(i + 1, new AbstractMap.SimpleEntry<Integer, Integer>(startTime, startTime + 2));
						return true;
					} else {
						return false;
					}
				} else {
					reservationTime.add(new AbstractMap.SimpleEntry<Integer, Integer>(startTime, startTime + 2));
					return true;
				}
			}
		}
		return true;
	}

	public void cleanUp(int currentTime) {
		for(Map.Entry<Integer, Integer> entry : new ArrayList<Map.Entry<Integer, Integer>>(reservationTime)) {
			 if(entry.getValue() < currentTime) {
				 reservationTime.remove(0);
			 }
		}
	}
}
