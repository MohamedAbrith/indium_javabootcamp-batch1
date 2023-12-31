import Service.*;
import Model.Account;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //AccountService accountService = new AccountService();
        //AccountServiceArrayList accountService = new AccountServiceArrayList();
        //AccountServiceLinkedList accountService = new AccountServiceLinkedList();
        //AccountServiceTreeMap accountService = new AccountServiceTreeMap();
        //AccountServiceHashMap accountService = new AccountServiceHashMap();
        AccountServiceHashSet accountService = new AccountServiceHashSet();
        //AccountServiceTreeSet accountService = new AccountServiceTreeSet();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("BANK ACCOUNT APPLICATION");
            System.out.println("1) Create Account");
            System.out.println("2) Read Account");
            System.out.println("3) Read Account by ID");
            System.out.println("4) Update Account");
            System.out.println("5) Delete Account");
            System.out.println("6) Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Account ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Account Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Account Balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter Account Type: ");
                    String type = scanner.next();
                    accountService.createAccount(id, name, balance, type);
                    break;
                case 2:
                    Account[] allAccounts = accountService.getAllAccounts();
                    for (Account account : allAccounts) {
                        System.out.println(account);
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Enter Account ID to Read: ");
                    int viewId = scanner.nextInt();
                    Account viewAccount = accountService.getAccountById(viewId);
                    if (viewAccount != null) {
                        System.out.println(viewAccount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Balance: ");
                    double newBalance = scanner.nextDouble();
                    accountService.updateBalance(updateId, newBalance);
                    break;
                case 5:
                    System.out.print("Enter Account ID to delete: ");
                    int deleteId = scanner.nextInt();
                    accountService.deleteAccount(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        scanner.close();
    }
}




