import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

// Main ATM interface
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.0); // Starting balance

        int choice;
        do {
            System.out.println("\nATM Interface:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    account.deposit(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    account.withdraw(sc.nextDouble());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }

        } while (choice != 4);

        sc.close();
    }
}