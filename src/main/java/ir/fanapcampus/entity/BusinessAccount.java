package ir.fanapcampus.entity;

import ir.fanapcampus.interfaces.Loanable;

import java.util.Date;

public class BusinessAccount extends BankAccount implements Loanable {

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

    @Override
    public void receiveLoan(double amount) {

        if ((amount + calculateTransactionFee(amount)) > getBalance() + creditLimit) {
            System.out.println("Insufficient funds and credit limit.");
        } else {
            Transaction transaction = new Transaction("1", "deposit", amount, new Date(), this);
            transaction.execute();
            setBalance(getBalance() + amount);
            System.out.println("You received loan");
        }

    }

    @Override
    public void payLoan(double amount) {

        double balance = getBalance();
        if (amount > balance) {
            System.out.println("The amount is more than the balance and we cannot pay you the loan");
        } else {
            withdraw(amount);
        }

    }

}
