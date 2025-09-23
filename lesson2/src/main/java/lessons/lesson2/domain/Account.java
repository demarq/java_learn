package lessons.lesson2.domain;

import lessons.lesson2.exceptions.InvalidAmountException;

public class Account {
    private final String ownerName;
    private double balance;

    public Account(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public Account(String ownerName) {
        this(ownerName, 0.0);
    }

    protected void setBalance(double amount) {
        this.balance = amount;
    }

    public void withdraw(double amount) {
        if ((balance - amount) < 0) {
            throw new InvalidAmountException("Balance cant be lower than 0");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Cannot withdraw negative amount or 0");
        }
        balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Cannot deposit negative | 0 amount");
        }
        balance += amount;
    }
}
