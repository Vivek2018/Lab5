import java.util.Random;

/**
 * Class implementing a bank account.
 * <p>
 * Complete and document this class as part of Lab 5.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/5/">Lab 5 Description</a>
 */
public class BankAccount {

    /**
     * You may want to use this to distinguish between different kinds of accounts.
     *
     */
    public enum BankAccountType {
        CHECKINGS,
        SAVINGS,
        STUDENT,
        WORKPLACE
    }

    public static int totalAccountNumber = 0;
    private int accountNumber;
    public BankAccountType accountType;
    private double accountBalance;
    private String ownerName;
    public double interestRate;
    private double interestEarned;
    /*public BankAccount() {
        totalAccounts = totalAccounts;
    }*/

    public BankAccount(final String name, final BankAccountType accountCategory) {
        ownerName = name;
        accountType = accountCategory;
        totalAccountNumber++;
    }

    public String getName() {
        return ownerName;
    }

    public void setOwnerName(final String name) {
        ownerName = name;
    }
    public double getAccountBalance() {

        return accountBalance;
    }
    public void setAccountBalance(final double newBalance) {
        accountBalance = newBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(final int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(final double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestEarned() {
        return interestEarned;
    }

    public void setInterestEarned(final double interestEarned) {
        this.interestEarned = interestEarned;
    }
}
