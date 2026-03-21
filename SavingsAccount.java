public class SavingsAccount extends CheckingAccount {

    private double interestRate;

    public static void main(String[] args) {
        SavingsAccount acc = new SavingsAccount();
        acc.start();
    }

    public void calcInterest() {
        double interest = balance * interestRate;
        balance += interest;
    }

    public void setInterestRate(double rate) {
        interestRate = rate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
