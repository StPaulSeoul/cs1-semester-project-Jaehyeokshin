import java.util.Scanner;

public class Customer {
	Scanner input = new Scanner(System.in);

	String name;
	int decision;
	double balance = 0;
	double deposit;
	double withdraw;

	public Customer(String name) {
		this.name = name;
	}

	public void enter(Customer customer, Machine machine) {
		System.out.println(this.name + ": Hmm, What should I do for today?");
		machine.display(this, machine);
	}

	public void decision(Customer customer, Machine machine) {
		decision = input.nextInt();
		if (decision == 1) {
			// deposit
			System.out.println("How much would you deposit?");
			this.deposit = input.nextDouble();
			this.balance = this.balance + this.deposit;
		} else if (decision == 2 && balance > 0) {
			// withdraw
			System.out.println("How much would you withdraw?");
			this.withdraw = input.nextDouble();
			if (withdraw > balance) {
				System.out.println("Error. Please check your balance.");
			} else {
				this.balance = this.balance - this.withdraw;
			}
		} else if (decision == 3) {
			// check
			System.out.printf("Your account has $%.2f\n", balance);
		} else {
			System.out.println("Error. Please check your balance.");
		}
		machine.output(this, machine, balance);
	}

	public static void main(String[] args) {
		Scanner Sana = new Scanner(System.in);
		String again;

		Customer myCustomer = new Customer("CW");
		Machine myMachine = new Machine("ATM Machine");

		for (;;) {
			myCustomer.enter(myCustomer, myMachine);
			System.out.println("Would you like to do something else?");
			// yes or no?
			again = Sana.nextLine();
			if (again.equals("No")) {
				break;
			}
		}
	}

}
