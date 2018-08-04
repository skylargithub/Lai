package VendingMachine;

public enum SnackEnum {
	
	Chip("Chip", 0.50), EnergyBar("Oatmeal", 1.00), Drink("Pepsi", 1.25);
	
	private String name;
	private double price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private SnackEnum(String name, double price) {
		this.price = price;
		this.name = name;
	}
	
	

}
