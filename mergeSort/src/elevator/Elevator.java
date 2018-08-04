package elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
	
	private final int CAPACITY;
	private int floorNum;
	private List<Requests> requests;
	
	public Elevator(int capacity) {
		this.CAPACITY = capacity;
	}
	
	public void moveUp() {}
	
	public void moveDown() {}
	
	public boolean load(List<Requests> requests) {
		if(requests.size() + this.requests.size() <= this.CAPACITY) {
			this.requests.addAll(requests);
			return true;
		} else {
			return false;
		}
	}
	
	public List<Requests> unload() {
		return new ArrayList<Requests>();
	}

}
