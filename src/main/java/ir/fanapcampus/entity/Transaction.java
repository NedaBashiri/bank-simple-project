package ir.fanapcampus.entity;

import java.util.Date;

public class Transaction {

    private String transactionId;
    private String transactionType;
    private double amount;
    private Date transactionDate;
    private BankAccount account;

    public Transaction(String transactionId, String transactionType, double amount, Date transactionDate, BankAccount account) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.account = account;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public void execute() {
        switch (transactionType) {
            case "deposit":
                account.deposit(amount);
                break;
            case "withdraw":
                account.withdraw(amount);
                break;
            default:
                System.out.println("Invalid transaction type.");
                break;
        }
    }

    public void rollback() {
        switch (transactionType) {
            case "deposit":
                account.withdraw(amount);
                System.out.println("Rollback: Reversed deposit transaction.");
                break;
            case "withdraw":
                account.deposit(amount);
                System.out.println("Rollback: Reversed withdrawal transaction.");
                break;
            default:
                System.out.println("Invalid transaction type.");
                break;
        }
    }
}

