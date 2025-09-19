package lessons.lesson2;

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

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public void addToBalance(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        }
        balance += amount;
    }

    public void withdrawFromBalance(double amount) {
        if ((balance - amount) < 0) {
            throw new IllegalStateException("Balance cant be lower than 0");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot withdraw negative amount");
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
        addToBalance(amount);
    }





}
