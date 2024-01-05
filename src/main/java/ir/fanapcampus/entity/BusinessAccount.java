package ir.fanapcampus.entity;

public class BusinessAccount extends BankAccount {

    private double creditLimit;
    private double transactionFee;


    public BusinessAccount() {

    }

    public BusinessAccount(String accountNumber, String ownerName, double balance, double creditLimit) {
        super(accountNumber, ownerName, balance);
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getTransactionFee() {
        return transactionFee;
    }


    public double calculateTransactionFee(double amount) {
        transactionFee = 0.0;
        if (amount > 1000 && amount < 5000) {
            transactionFee = amount * 0.02;
        } else if (amount > 5000) {
            transactionFee = amount * 0.05;
        }

        return transactionFee;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Amount: " + amount + " deposit your balance");
        } else {
            System.out.println("Invalid amount try again");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() < amount) {
            if (getBalance() + creditLimit >= amount) {
                double borrowedAmount = amount - getBalance();
                setBalance(getBalance() - (amount + calculateTransactionFee(amount)));
                System.out.println("successfully withdrew: " + (amount + calculateTransactionFee(amount)));
            } else {
                System.out.println("Insufficient funds and credit limit.");
            }
        } else {
            setBalance(getBalance() - (amount + calculateTransactionFee(amount)));
            System.out.println("successfully withdrew: " + (amount + calculateTransactionFee(amount)));
        }
    }


}
