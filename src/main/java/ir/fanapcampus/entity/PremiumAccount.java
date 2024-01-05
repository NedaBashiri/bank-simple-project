package ir.fanapcampus.entity;

import ir.fanapcampus.interfaces.InvestmentCapable;

public class PremiumAccount extends BankAccount implements InvestmentCapable {


    private double interestRate;
    private double capital;

    public PremiumAccount() {
    }

    public PremiumAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        double balance = getBalance();
        double interest = balance * interestRate;
        return interest;
    }

    public void applyInterest() {
        double interest = calculateInterest();
        System.out.println("Interest applied: " + interest);
        setBalance(getBalance() + interest);

    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Amount: " + amount + " deposit your balance");
            applyInterest();
        } else {
            System.out.println("Invalid amount try again");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount < getBalance() && amount <= getBalance()) {
            System.out.println("successfully withdrew: " + amount);
            setBalance(getBalance() - amount);
        } else {
            System.out.println("The account balance is not enough or invalid amount");
        }
    }

    public void invest(double amount) {
        if (amount > 0) {
            capital += amount;
            System.out.println("Invested: " + amount);
        } else {
            System.out.println("Invalid investment amount.");
        }
    }

    @Override
    public void withdrawInvestment(double amount) {
        if (amount > 0 && amount <= capital) {
            capital -= amount;
            System.out.println("Withdrawn from investment: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

}
