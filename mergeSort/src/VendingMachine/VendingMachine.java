package VendingMachine;

import java.util.ArrayList;
import java.util.List;

/* 
 * 1 Machine can take credit card or cash, but no combination
 * 
 * 2 Only $10, $5, $1 supported
 * 3 Return coins only
 * 4 Vending machine has a stack of snacks, including chips and energy bar
 * 5 Show error message if some snack out of stack
 * 6 refund cancel request
 * 
 * flow: user insert card/pay cash - select snack - (confirm) - vend snack - return coins
 * Class:
 * VendingMachine
 * Cash (Integer)
 * CreditCard 
 * Snack
 * Two dimension arrays of List of Snacks
 * */

public class VendingMachine {
	
	private List<SnackEnum>[] SnackInventory;
	private List<CoinEnum>[] CoinInventory;
	private final int SNACK_CAPACITY = 5;
	private final int COIN_CAPACITY = 5;
	
	public VendingMachine () {
		SnackInventory = new List[SnackEnum.values().length];
		CoinInventory = new List[CoinEnum.values().length];
		int i = 0;
		for(SnackEnum snackEnum : SnackEnum.values()) {
			List<SnackEnum> tempSnack = new ArrayList<SnackEnum>();
			for(int j = 0; j < SNACK_CAPACITY; j++) {
				tempSnack.add(snackEnum);
			}
			SnackInventory[i] = tempSnack;
			i++;
		}
		
		i = 0;
		//Similar for coin
		
	}
	
	public double refund(double d) {
		return d;
	}
	
	public Snack vend() {
		return new Chip(5);
	}
	
	//Skip authentication
	public SnackEnum collectItem(int number, int money) {
		return SnackInventory[number].remove(0);
	}
	
	public boolean inStock(int number) {
		return SnackInventory[number].size() > 0;
	}
	
	public boolean fullPaid(int number, int money) {
		return money > SnackInventory[number].get(0).getPrice();
	}
	
	public void refillSnacks() {
		
	}
	
	public void refillCoins() {
		
	}

}
