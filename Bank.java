import java.util.Scanner;

public class Bank implements HasMenu {
	private Admin admin;
	private CustomerList customers;
	
	public Bank() {
		admin = new Admin();
		customers = new CustomerList();
		loadSampleCustomers();
		start();
	}
	public static void main(String[] args) {
		new Bank();
	}
	
	public void loadSampleCustomers() {
		Customer c1 = new Customer();
		c1.setUserName("Alice");
		c1.setPIN("1111");
		c1.getChecking().setBalance(1000);
		c1.getSavings().setBalance(1000);
		Customer c2 = new Customer();
		c2.setUserName("Bob");
		c2.setPIN("2222");
		customers.add(c1);
		customers.add(c2);
	}
	
	public String menu() {
		return "Bank Menu\n" +
			"0) Exit system\n" +
			"1) Login as admin\n" +
			"2) Login as customer";
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(menu());
			int choice = sc.nextInt();
			if (choice == 0) break;
			if (choice == 1) loginAdmin(sc);
			if (choice == 2) loginCustomer(sc);
		}
	}
	
	public void loginAdmin(Scanner sc) {
		System.out.print("User name: ");
		String u = sc.next();
		System.out.print("PIN: ");
		String p = sc.next();
		if (admin.login(u, p)) {
			adminMenu(sc);
		} else {
			System.out.println("Invalid login");
		}
	}
	
	public void adminMenu(Scanner sc) {
		while (true) {
			System.out.println(admin.menu());
			int choice = sc.nextInt();
			if (choice == 0) break;
			if (choice == 1) fullCustomerReport();
			if (choice == 2) addUser(sc);
			if (choice == 3) applyInterest();
		}
	}
	
	public void fullCustomerReport() {
		for (Customer c : customers) {
			System.out.println(c.getReport());
		}
	}
	
	public void addUser(Scanner sc) {
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("PIN: ");
		String pin = sc.next();
		Customer c = new Customer();
		c.setUserName(name);
		c.setPIN(pin);
		customers.add(c);
	}
	
	public void applyInterest() {
		for (Customer c : customers) {
			c.getSavings().calcInterest();
		}
	}
	
	public void loginCustomer(Scanner sc) {
		System.out.print("User name: ");
		String u = sc.next();
		System.out.print("PIN: ");
		String p = sc.next();
		
		for (Customer c : customers) {
			if (c.login(u, p)) {
				System.out.println("Welcome " + c.getUserName());
				return;
			}
		}
		System.out.println("Login failed");
	}
}
