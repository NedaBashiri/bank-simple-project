package ir.fanapcampus.service;

import ir.fanapcampus.entity.BankAccount;
import ir.fanapcampus.entity.BasicAccount;
import ir.fanapcampus.entity.Transaction;

import java.util.Date;

public class BankingApp {
    public static void main(String[] args) {


       /* BankAccount basicAccount = new BasicAccount("1234567890", "Peter Jef", 10000);
        basicAccount.deposit(5000);
        basicAccount.withdraw(2000);*/
//--------------------------------------------------------------------------------------------------------

    /*    PremiumAccount premiumAccount = new PremiumAccount("1234567890", "Peter Jef", 10000, 0.05);
        premiumAccount.deposit(4000);
        premiumAccount.withdraw(5000);
        premiumAccount.invest(6000);
        premiumAccount.withdrawInvestment(3000);*/

//--------------------------------------------------------------------------------------------------------

   /*     BusinessAccount businessAccount = new BusinessAccount("1234567890", "Peter Jef", 10000, 100000);
        System.out.println("Credit limit is: " + businessAccount.getCreditLimit());
        businessAccount.deposit(5000);
        businessAccount.withdraw(2000);
        System.out.println("Transaction fee is: " + businessAccount.calculateTransactionFee(10000));
        businessAccount.receiveLoan(50000);
        businessAccount.payLoan(20000);*/

//--------------------------------------------------------------------------------------------------------

        BankAccount account = new BasicAccount("1234567890", "John Doe", 10000);
        Transaction depositTransaction = new Transaction("1", "deposit", 5000, new Date(), account);
        depositTransaction.execute();

        System.out.println("balance: " + account.getBalance());

        Transaction withdrawTransaction = new Transaction("2", "withdraw", 2000, new Date(), account);
        withdrawTransaction.execute();
        long amount1 = 2000;
        account.withdraw(amount1);
        if (amount1 >= 1000){
            withdrawTransaction.rollback();
        }
        System.out.println("balance: " + account.getBalance());


    }
}
