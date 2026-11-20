/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atmmachine;
import java.util.Scanner;
/**
 *
 * @author Thinkpad T480
 */
public class AtmMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int correctPin = 1234;
        int enteredPin;
        int attempts = 0;
        boolean loggedIn = false;

        double balance = 1000.0;
        double amount;

        int choice;

        String[] transactions = new String[100];
        int transactionCount = 0;

        System.out.println("===== WELCOME TO JAVA ATM =====");

        do {
            System.out.print("Enter your PIN: ");
            enteredPin = input.nextInt();

            if (enteredPin == correctPin) {
                System.out.println("Login successful!");
                loggedIn = true;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Try again.");
                System.out.println("Attempts remaining: " + (3 - attempts));
            }

        } while (attempts < 3 && loggedIn == false);

        if (loggedIn == false) {

            System.out.println("You have entered the wrong PIN 3 times.");
            System.out.println("Your account is locked.");

        } else {

            do {

                System.out.println("\n===== ATM MAIN MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. View Transaction History");
                System.out.println("5. Exit");

                System.out.print("Choose an option: ");
                choice = input.nextInt();

                if (choice == 1) {

                    System.out.println("Your current balance is: " + balance);

                } else if (choice == 2) {

                    System.out.print("Enter amount to deposit: ");
                    amount = input.nextDouble();

                    if (amount > 0) {

                        balance = balance + amount;

                        transactions[transactionCount] =
                                "Deposited: " + amount;

                        transactionCount++;

                        System.out.println("Deposit successful!");
                        System.out.println("New balance: " + balance);

                    } else {

                        System.out.println("Invalid deposit amount.");

                    }

                } else if (choice == 3) {

                    System.out.print("Enter amount to withdraw: ");
                    amount = input.nextDouble();

                    if (amount > 0 && amount <= balance) {

                        balance = balance - amount;

                        transactions[transactionCount] =
                                "Withdrawn: " + amount;

                        transactionCount++;

                        System.out.println("Withdrawal successful!");
                        System.out.println("Remaining balance: " + balance);

                    } else {

                        System.out.println("Insufficient balance or invalid amount.");

                    }

                } else if (choice == 4) {

                    System.out.println("\n===== TRANSACTION HISTORY =====");

                    if (transactionCount == 0) {

                        System.out.println("No transactions available.");

                    } else {

                        for (int i = 0; i < transactionCount; i++) {

                            System.out.println(transactions[i]);

                        }

                    }

                } else if (choice == 5) {

                    System.out.println("Thank you for using our ATM.");
                    System.out.println("Goodbye!");

                } else {

                    System.out.println("Invalid choice. Please try again.");

                }

            } while (choice != 5);

        }

        input.close();
    }
}
    

