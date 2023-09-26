import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import System.*;
import System.Createacc;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

        while (true){
            System.out.println("Choose an option:");
            System.out.println("1. Create an Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Check Balance");
            System.out.println("5. Quit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter your name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter the initial deposit amount : ");
                    double initialDeposit = sc.nextDouble();

                    if (initialDeposit >= 1000) {
                        BankAccount newAccount = new BankAccount(name, initialDeposit);
                        accounts.add(newAccount);

                    } else {
                        System.out.println("Initial deposit must be at least Rs.1000.");
                    }
                    Createacc.execute(accounts, name,initialDeposit);
                    break;

                case 2:
                    System.out.println("Enter Your ID:");
                    int depositAccountId = sc.nextInt();
                    BankAccount depositAccount = findAccount(accounts,depositAccountId);
                    if(depositAccount != null){
                        System.out.print("Enter the deposit amount: Rs.");
                        double depositAmount = sc.nextDouble();
                        Deposit.execute(depositAccount, depositAmount);
                    }else{
                        System.out.println("Account not found!!");
                    }
                    break;
                case 3:
                    System.out.println("Enter your ID:");
                    int withdrawId = sc.nextInt();
                    BankAccount withdrawAccount = findAccount(accounts,withdrawId);
                    if(withdrawAccount != null){
                        System.out.print("Enter the Withdrawal Amount:");
                        double withdrawAmount  = sc.nextDouble();
                        Withdraw.execute(withdrawAccount,withdrawAmount);
                    }else{
                        System.out.println("Account not Found!!");
                    }
                    break;
                case 4:
                    System.out.println("Enter your ID:");
                    int checkBalanceId = sc.nextInt();
                    BankAccount checkBalance = findAccount(accounts, checkBalanceId);
                    if(checkBalance != null){
                        MainBalance.execute(checkBalance);
                    }else{
                        System.out.println("Account not found");
                    }
                    break;
                case 5:
                    System.out.println("Quiting.....");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice!!");
            }
            try{
                Thread.sleep(3000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private static BankAccount findAccount(ArrayList<BankAccount> accounts,int accountId){
        for (BankAccount account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }
}