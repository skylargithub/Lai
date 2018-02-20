package parkingLotSim;

public enum VehicleSize {
	
	Compact(1), Large(2);
	
	public int size;
	
	VehicleSize(int size) {
		this.size = size;
	}
}
