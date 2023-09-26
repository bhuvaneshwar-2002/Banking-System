package System;

import java.util.ArrayList;

public class Createacc{
    public static  BankAccount execute(ArrayList<BankAccount> accounts,String name, double initialDeposit){
        BankAccount account = new BankAccount(name, initialDeposit);
        accounts.add(account);
        System.out.println("Account Created Successfully.");
        System.out.println("Your Account ID is:" +account.getAccountId());
//        System.out.println("Enter the Initial Deposit Amount:");
        return account;
    }


}