package parkingLotSim;

public class ParkingSpot {
	VehicleSize parkingLotSize;
	Vehicle vehicle;
	
	public boolean fit(Vehicle vehicle) {
		if(getVehicle() == null && this.parkingLotSize.size > vehicle.getVehicleSize().size) {
			return true;
		} 
		return false;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void park(Vehicle vehicle) {
		
			this.vehicle = vehicle;
		
	}
	
	public void leave() {
		this.vehicle = null;
	}
}
