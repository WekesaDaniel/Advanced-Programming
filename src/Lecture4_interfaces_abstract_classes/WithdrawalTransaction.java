package Lecture4_interfaces_abstract_classes;

<<<<<<< HEAD
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkDepositAmount(int amt) {
        if (amt < 0) {
            return false;
        } else {
            return true;
        }
    }

    // Method to reverse the transaction
    public boolean reverse() {
        return true;
    } // return true if reversal was successful

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Deposit Trasaction: " + this.toString());
    }

    /*
    Oportunity for assignment: implementing different form of withdrawal
     */
    public void apply(BankAccount ba) {
        double curr_balance = ba.getBalance();
        if (curr_balance > getAmount()) {
            double new_balance = curr_balance - getAmount();
            ba.setBalance(new_balance);
        }
    }

    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */
}

=======
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(double amount, Calendar date) {
        super(amount, date);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        double balance = ba.getBalance();
        if (balance < getAmount()) {
            throw new InsufficientFundsException("Insufficient funds to complete withdrawal.");
        }
        ba.setBalance(balance - getAmount());
        System.out.println("Withdrawal successful. New balance: " + ba.getBalance());
    }

    // Overloaded apply method
    public void apply(BankAccount ba, boolean partialWithdrawal) {
        try {
            if (!partialWithdrawal) {
                apply(ba);
            } else {
                double balance = ba.getBalance();
                if (balance > 0 && balance < getAmount()) {
                    System.out.println("Partial withdrawal. Available: " + balance + ", Requested: " + getAmount());
                    ba.setBalance(0);
                } else {
                    apply(ba);
                }
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete.");
        }
    }

    public boolean reverse(BankAccount ba) {
        ba.setBalance(ba.getBalance() + getAmount());
        System.out.println("Withdrawal reversed. Balance restored to: " + ba.getBalance());
        return true;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: ");
        super.printTransactionDetails();
    }
}
>>>>>>> b243ed3 (First commit Assignment 1)
