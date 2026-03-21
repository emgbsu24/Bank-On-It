import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements HasMenu, Serializable {
	protected String userName;
	protected String PIN;
	protected Scanner scanner = new Scanner(System.in);
	
	public boolean login() {
		System.out.print("Username: ");
		String u = scanner.nextLine();
		System.out.print("PIN: ");
		String p = scanner.nextLine();
		return login(u, p);
	}
	
	public boolean login(String u, String p) {
		return userName.equals(u) && PIN.equals(p);
	}
	
	public void setUserName(String u) {
		userName = u;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setPIN(String p) {
		PIN = p;
	}
	
	public String getPIN() {
		return PIN;
	}
	
	public abstract String getReport();
}
