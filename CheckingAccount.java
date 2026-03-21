import java.util.Scanner;
public class CheckingAccount implements HasMenu {
	protected double balance;
	private Scanner scanner = new Scanner(System.in);
	public CheckingAccount() {
		balance = 0.0;
	}
	
	public CheckingAccount(double b) {
		balance = b;
	}
	
	public static void main(String[] args) {
		CheckingAccount acc = new CheckingAccount(100);
		acc.start();
	}
	
	public String menu() {
		return "0) quit\n1) check balance\n2) deposit\n3) withdraw";
	}
	
	public void start() {
		int choice;
		do {
			System.out.println(menu());
			System.out.print("Enter choice: ");
			choice = getInt();
			if (choice == 1) {
				checkBalance();
			} else if (choice == 2) {
				makeDeposit();
			} else if (choice == 3) {
				makeWithdrawal();
			}
		} while (choice != 0);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getBalanceString() {
		return String.format("$%.2f", balance);
	}
	
	public void setBalance(double b) {
		balance = b;
	}
	
	public void checkBalance() {
		System.out.println("Balance: " + getBalanceString());
	}
	private double getDouble() {
		try {
			return Double.parseDouble(scanner.nextLine());
		} catch (Exception e) {
			return 0.0;
		}
	}
	
	private int getInt() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			return 0;
		}
	}
	
	public void makeDeposit() {
		System.out.print("Deposit amount: ");
		double amt = getDouble();
		balance += amt;
		System.out.println("New balance: " + getBalanceString());
	}
	
	public void makeWithdrawal() {
		System.out.print("Withdraw amount: ");
		double amt = getDouble();
		balance -= amt;
		System.out.println("New balance: " + getBalanceString());
	}
}
