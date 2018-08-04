package VendingMachine;

public class Simulater {
	
	VendingMachine vm = VendingMachineFactory.getVendingMachine();
	
	public void simulate(int number, int money) {
		if(vm.inStock(number)) {
			if(vm.fullPaid(number, money)) {
				SnackEnum snackEnum = vm.collectItem(number, money);
				vm.refund(money - snackEnum.getPrice());
				vm.refillSnacks();
			} else {
				vm.refund(money);
			}
		} else {
			System.out.println("out of stack");
		}
	}

}
