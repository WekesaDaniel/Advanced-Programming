package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        Calendar date = Calendar.getInstance();

        System.out.println("Initial Account Balance: " + account.getBalance());

        // Testing Deposit Transaction
        DepositTransaction deposit = new DepositTransaction(1500, date);
        deposit.printTransactionDetails();
        deposit.apply(account);

        // Testing Withdrawal Transaction
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(2000, date);
        withdrawal.printTransactionDetails();
        try {
            withdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Error during withdrawal: " + e.getMessage());
        }

        // Testing Reversal
        withdrawal.reverse(account);

        // Partial Withdrawal Test
        withdrawal = new WithdrawalTransaction(8000, date);
        withdrawal.apply(account, true);

        System.out.println("Final Account Balance: " + account.getBalance());
    }
}
