package System;
import java.util.Scanner;
import java.util.ArrayList;
public class BankAccount {
    private static int startAccountId = 100;
    private int accountId;
    private String accHolder;
    private double balance = 0.0;

    public BankAccount(String accHolder,double initialDeposit){
        this.accountId = startAccountId++;
        this.accHolder = accHolder;
        this.balance = initialDeposit;
    }

    public int getAccountId() {

        return accountId;
    }

    public String getAccHolder() {

        return accHolder;
    }

    public double getBalance() {

        return balance;
    }


    public void deposit(double amount) {
        if (amount < 500) {
            System.out.println("The Minimum Deposit Amount is Rs.500");
        } else {
            balance += amount;
            System.out.println("Deposit Successful");
            System.out.println("New Balance in Your Account is:" + balance);
        }
    }
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal Successful.");
            System.out.println("The Current Balance is:"+ balance);
        }
        else{
            System.out.println("Invalid Withdrawal amount or insufficient balance");
        }
    }
}