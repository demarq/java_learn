package lessons.lesson2;

public class CheckingAccount extends Account {

    double overdraftLimit;

    public CheckingAccount (String ownerName, double balance, double overdraftLimit) {
        super(ownerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdrawFromBalance(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot withdraw negative amount");
        }
        double balance = this.getBalance() - amount;
        if (balance < -this.overdraftLimit) {
            throw new IllegalStateException("Exceeded overdraft limit");
        }
        setBalance(balance);
    }
}
