package lessons.lesson2;

public class SavingsAccount extends Account{

    public SavingsAccount(String ownerName, double balance) {
        super(ownerName, balance);
    }

    public SavingsAccount(String ownerName) {
        this(ownerName, 0);
    }

    public void applyInterest(double rate) {
        double balance = this.getBalance();
        double interest_balance = balance * rate;
        setBalance(interest_balance);
    }

}
