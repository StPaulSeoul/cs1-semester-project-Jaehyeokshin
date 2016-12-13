
public class Machine {
	String name;

	public Machine(String name) {
		this.name = name;
	}

	public void display(Customer customer, Machine machine) {
		System.out.printf("1) Deposit \n2) Withdraw \n3) Check your account balance\n");
		customer.decision(customer, machine);

	}

	public void output(Customer customer, Machine machine, double balance) {
		System.out.printf("You have $%.2f\n", balance);
	}

}
