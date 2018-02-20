package parkingLotSim;

import java.util.List;

public class ParkingLot {
	
	private List<Floor> floors;
	
	public void park(Vehicle vehicle) {
		for(Floor floor: floors) {
			if(floor.park(vehicle)) {
				return;
			}
		}
	}
	
	public boolean hasSpot(Vehicle vehicle) {
		for(Floor floor: floors) {
			if(floor.hasSpot(vehicle)) {
				return true;
			}
		}
		return false;
	}
	
	public void leave(Vehicle vehicle) {
		for(Floor floor: floors) {
			floor.leave(vehicle);
		}
	}

}
