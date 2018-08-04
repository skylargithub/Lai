package elevator;

import java.util.ArrayList;
import java.util.List;

public class Simulater {
	//users queue is much better than List
	List<List<Requests>> requests;
	//Elevators;
	List<Elevator> elevators;
	Scheduler scheduler;
	//elevator capacity
	int capacity = 5;
	int maxFloor = 5;
	int numOfElevators = 3;
	
	public Simulater() {
		//1. create requests
		createRequests();
		//2. create elevators;
		this.elevators = new ArrayList<Elevator>();
		for(int i = 0; i < numOfElevators; i++) {
			elevators.add(new Elevator(capacity));
		}
		//3. create Scheduler
		this.scheduler = new SchedulerImpl();
	}
	
	public void simulate(int step) {}
	
	private void createRequests() {}

}
