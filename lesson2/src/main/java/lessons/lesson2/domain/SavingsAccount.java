package lessons.lesson2.domain;

public class SavingsAccount extends Account{

    public SavingsAccount(String ownerName, double balance) {
        super(ownerName, balance);
    }

    public SavingsAccount(String ownerName) {
        this(ownerName, 0);
    }

    public void applyInterest(double rate) {
        double balance = this.getBalance();
        double interestBalance = balance * rate;
        setBalance(interestBalance);
    }

}
