public class Customer extends User {
	private CheckingAccount checking;
	private SavingsAccount savings;

	public Customer(String u, String p) {
		userName = u;
		PIN = p;
		checking = new CheckingAccount();
		savings = new SavingsAccount();
	}

	public static void main(String[] args) {
		Customer c = new Customer("Alice", "0000");
		if (c.login("Alice", "0000")) {
			System.out.println("Login successful");
			c.start();
		} else {
			System.out.println("Login failed");
		}
	}

	public String menu() {
		return "0) Exit\n1) Checking\n2) Savings\n3) Change PIN";
	}
	
	public void start() {
		int choice;
		do {
			System.out.println(menu());
			System.out.print("Choice: ");
			choice = Integer.parseInt(new java.util.Scanner(System.in).nextLine());

			if (choice == 1) {
				checking.start();
			} else if (choice == 2) {
				savings.start();
			} else if (choice == 3) {
				System.out.print("New PIN: ");
				PIN = new java.util.Scanner(System.in).nextLine();
			}
		} while (choice != 0);
	}

	public String getReport() {
		return "User: " + userName;
	}
}
