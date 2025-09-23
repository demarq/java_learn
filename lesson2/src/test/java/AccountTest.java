import lessons.lesson2.domain.Account;
import lessons.lesson2.exceptions.InvalidAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountTest {


    Account account;
    String account_owner_name;
    double account_balance;

    @BeforeEach
    void setUp() {
        account_owner_name = "Pepperonny";
        account_balance = 10.;
        account = new Account(account_owner_name, account_balance);
    }

    @Test
    void testCreateAccount() {
        var ownerName = "Pepperonny";
        var balance = 10;
        var account = new Account(ownerName, balance);
        assertEquals(balance, account.getBalance());
        assertEquals(ownerName, account.getOwnerName());
    }

    @Test
    void testGetBalance() {
        assertEquals(account_balance, account.getBalance());
    }

    @Test
    void testGetOwnerName() {
        assertEquals(account_owner_name, account.getOwnerName());
    }

    @Test
    void testAccountDeposit() {
        var deposit_value = 33.33;
        account.deposit(deposit_value);
        assertEquals(account_balance + deposit_value, account.getBalance());
    }
    @Test
    void testAccountDepositLowerThanZero() {
        var deposit_value = -10;
        var expected_error_message = "Cannot deposit negative | 0 amount";
        Exception exception = assertThrows(InvalidAmountException.class, () -> account.deposit(deposit_value));
        assertEquals(expected_error_message, exception.getMessage());
    }

    @Test
    void testAccountWithdraw() {
        var withdraw_value = 3.3;
        account.withdraw(withdraw_value);
        assertEquals(account_balance - withdraw_value, account.getBalance());
    }

    @Test
    void testWithdrawNegativeValue() {
        var withdraw_value = -3.3;
        var expected_message = "Cannot withdraw negative amount or 0";
        Exception error = assertThrows(
                InvalidAmountException.class,
                () -> account.withdraw(withdraw_value)
        );
        assertEquals(expected_message, error.getMessage());
    }

    @Test
    void testWithdrawMoreThanAccountBalance() {

        var expected_message = "Balance cant be lower than 0";
        var withdraw_value = 11;
        Exception error = assertThrows(
                InvalidAmountException.class,
                () -> account.withdraw(withdraw_value)
        );
        assertEquals(expected_message, error.getMessage());
    }
    @Test
    void testWithdrawZero() {

        var expected_message = "Cannot withdraw negative amount or 0";
        var withdraw_value = 0;
        Exception error = assertThrows(
                InvalidAmountException.class,
                () -> account.withdraw(withdraw_value)
        );
        assertEquals(expected_message, error.getMessage());
    }


}
