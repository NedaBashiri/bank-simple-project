package ir.fanapcampus.entity;

public class BasicAccount extends BankAccount {

    private static final double MINIMUM_DEPOSIT = 1000;
    private static final double MAXIMUM_WITHDRAWAL = 5000000;

    public BasicAccount() {
    }

    public BasicAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > MINIMUM_DEPOSIT) {
            setBalance(getBalance() + amount);
            System.out.println("Amount: " + amount + " deposit your balance");
        } else {
            System.out.println("The minimum Deposit is 1000.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if ((getBalance() + MINIMUM_DEPOSIT) > amount) {
            if (amount < MAXIMUM_WITHDRAWAL) {
                System.out.println("successfully withdrew: " + amount);
                setBalance(getBalance() - amount);
            } else {
                System.out.println("The maximum withdrawal is 5000000.");
            }
        } else {
            System.out.println("Insufficient funds and credit limit.");
        }
    }

}
