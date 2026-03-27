public class Admin extends User implements HasMenu {
	public Admin() {
		this.userName = "admin";
		this.PIN = "0000";
	}
	public String menu() {
		return "Admin Menu\n" +
			"0) Exit this menu\n" +
			"1) Full customer report\n" +
			"2) Add user\n" +
			"3) Apply interest to savings accounts";
	}
	public void start() {
	}
	public String getReport() {
		return "Admin: " + userName;
	}
}
