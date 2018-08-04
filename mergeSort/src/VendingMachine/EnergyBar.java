package VendingMachine;

public class EnergyBar extends Snack {
	
	private final int value;

	public EnergyBar(int value) {
		this.value = value;
	}
	
	public float getValue() {
		return this.value;
	}
}
