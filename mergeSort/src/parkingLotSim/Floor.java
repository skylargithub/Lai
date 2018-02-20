package parkingLotSim;

import java.util.ArrayList;
import java.util.List;

public class Floor {

	final List<ParkingSpot> parkingSpots;
	
	public Floor(int num) {
		this.parkingSpots = new ArrayList<ParkingSpot>(num);
	}
	
	public boolean park(Vehicle vehicle) {
		for(ParkingSpot parkingSpot: parkingSpots) {
			if(parkingSpot != null && parkingSpot.fit(vehicle)) {
				return true;
			}
		}
		return false;
	}
	
	public void leave(Vehicle vehicle) {
		for(ParkingSpot parkingSpot: parkingSpots) {
			if(parkingSpot.vehicle == vehicle) {
				parkingSpot.vehicle = null;
			}
		}
	}
	
	public boolean hasSpot(Vehicle vehicle) {
		return false;
	}
	
}
