package VendingMachine;

public class Chip extends Snack {
	
	private final float value;
	
	public Chip (float value) {
		this.value = value;
	}
	
	public float getValue() {
		return value;
	}

}
