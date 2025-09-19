package lessons.lesson2;

public class Main {

    public static void printBalance(Account account) {
        System.out.printf("%s's Account balance %f%n", account.getOwnerName(),account.getBalance());
    }

    public static void checkBalance(Account account, double expectedValue) {
        if (account.getBalance() != expectedValue) {
            throw new RuntimeException(String.format("Invalid balance %f != %f", account.getBalance(), expectedValue ));
        }
    }

    public static void main(String[] args) {
        Person my_person = new Person("Alice", 30);
        my_person.introduce();

        Student my_student = new Student("Alice", 30, "NAU");
        my_student.introduce();


        var account = new Account("Valentyn");
        account.deposit(1600);
        checkBalance(account, 1600.0);
        printBalance(account);

        var savingsAccount = new SavingsAccount("Maryna");
        savingsAccount.deposit(10);
        savingsAccount.applyInterest(1.2);
        checkBalance(savingsAccount, 10 * 1.2);
        printBalance(savingsAccount);

        var checkingAccount = new CheckingAccount("Petro", 0., 10);
        checkingAccount.withdrawFromBalance(10);
        checkBalance(checkingAccount, -10);
        printBalance(checkingAccount);

    }
}
