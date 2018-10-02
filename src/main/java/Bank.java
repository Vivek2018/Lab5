/**
 * Implement a bank class.
 * <p>
 * In this lab we will model a bank. We have two classes: Bank and BankAccount. You should finish
 * both classes, by fixing checkstyle errors, defining constructors, getters and setters, and
 * accessing private variables.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/5/">Lab 5 Description</a>
 */
public class Bank {

    public String bankName;

    public Bank() {
        bankName = "Illini Bank";
    }

    /**
     * Withdraw money from an account.
     * <p>
     * Subtracts the amount of money from bank account's balance. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param bankAccount to withdraw money from.
     * @param amount to withdraw (double)
     * @return boolean
     */
    public boolean withdrawMoney(final BankAccount bankAccount, final double amount) {
       double balance = bankAccount.getAccountBalance();
       if (amount > balance) {
           return false;
       }
       balance -= amount;
       bankAccount.setAccountBalance(balance);
       return true;
    }

    /**
     * Deposit money in an account.
     * <p>
     * Adds the amount of money to bank account's balance. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param bankAccount to deposit money to.
     * @param amount to deposit
     * @return boolean
     */
    public boolean depositMoney(final BankAccount bankAccount, final double amount) {
        double balance = bankAccount.getAccountBalance();
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        bankAccount.setAccountBalance(balance);
        return true;
    }

    /**
     * Transfer money from one account to another.
     * <p>
     * Transfer the amount of money from one back account to another. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param source bank account to transfer money from.
     * @param destination bank account to transfer money to.
     * @param amount to transfer
     * @return boolean
     */

    public boolean transferMoney(final BankAccount source, final BankAccount destination,
            final double amount) {
        if (amount > source.getAccountBalance()) {
            return false;
        }
        destination.setAccountBalance(destination.getAccountBalance() + amount);
        source.setAccountBalance(source.getAccountBalance() - amount);
        return true;
    }

    /**
     * Change back account owner name.
     *
     * @param bankAccount to change
     * @param name new name to set
     */

    public void changeOwnerName(final BankAccount bankAccount, final String name) {
        bankAccount.setOwnerName(name);
    }

   public static int totalAccounts = 0;
    /**
     * Uses static variable to get number of bank accounts opened.
     *
     * @return the total number of accounts
     */
    public static int getNumberOfAccount() {
        totalAccounts = BankAccount.totalAccountNumber;
         return totalAccounts;
    }

    /**
     * Main method for testing.
     *
     * @param unused unused input arguments
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static void main(final String[] unused) {
        Bank bank = new Bank();
        System.out.println("Welcome to " + bank.bankName);
        System.out.println("We are excited to have you banking with us!\n\n");

        // Create Bank Accounts
        BankAccount account1 = new BankAccount("John Doe", BankAccount.BankAccountType.CHECKINGS);
        System.out.println("Bank account for John Doe created");

        BankAccount account2 = new BankAccount("Jony Ive", BankAccount.BankAccountType.STUDENT);
        System.out.println("Bank account for Johy Ive created\n\n");

        // Deposit money to both accounts and print new balance

        bank.depositMoney(account1, 1000.0);
        bank.depositMoney(account2, 5000.0);


        System.out.println("account1 deposit 1000 " + account1.getAccountBalance());
        System.out.println("account2 deposit 5000 " + account2.getAccountBalance());

        // Withdraw money from Account 2 and print new balance

        bank.withdrawMoney(account2, 200.0);
        System.out.println("account 2 loses 200 from 5000 " + account2.getAccountBalance());

        // Transfer money from Account 2 to Account 1 and print new balances
        System.out.println("Account1 balance proior transfer " + account1.getAccountBalance());
        System.out.println("Account2 balance proior transfer " + account2.getAccountBalance());

        bank.transferMoney(account2, account1, 350.0);
        System.out.println("Account1 balance after transfer " + account1.getAccountBalance());
        System.out.println("Account2 balance after transfer " + account2.getAccountBalance());
        // Print number of accounts
        System.out.print("Number of active accounts at " + bank.bankName + " are ");
        System.out.println(BankAccount.totalAccountNumber);
    }
}
