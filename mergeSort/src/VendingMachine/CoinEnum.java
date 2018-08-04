package VendingMachine;

public enum CoinEnum {

	PENNY(1), NICKLE(5), DIME(10), DOLLAR(25);
	
	private int value;
	
	private CoinEnum(int value) {
		this.value = value;
	}
	
	public int value() {
		return this.value;
	}
}
