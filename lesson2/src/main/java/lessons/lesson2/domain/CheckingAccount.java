package lessons.lesson2.domain;

import lessons.lesson2.exceptions.InvalidAmountException;
import lessons.lesson2.exceptions.OverdraftLimitViolationException;

public class CheckingAccount extends Account {

    private final double overdraftLimit;

    public CheckingAccount (String ownerName, double balance, double overdraftLimit) {
        super(ownerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Cannot withdraw negative | 0 amount");
        }
        double balance = this.getBalance() - amount;
        if (balance < -overdraftLimit) {
            throw new OverdraftLimitViolationException("Exceeded overdraft limit");
        }
        setBalance(balance);
    }
}
