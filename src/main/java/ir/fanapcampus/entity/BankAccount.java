package ir.fanapcampus.entity;

public abstract class BankAccount {

    private String accountNumber;

    private String ownerName;

    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public BankAccount setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);


    public abstract void withdraw(double amount);


}