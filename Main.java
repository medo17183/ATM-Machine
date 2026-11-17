
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int pincode = 1234;
        int ttry = 0;
        boolean login = false;

        while (ttry < 3) {

            System.out.println("Enter a 4-digit PIN");
            int pin = input.nextInt();

            if (pin == pincode) {
                System.out.println("Successful Login");
                login = true;
                break;
            } else {
                System.out.println("PIN not correct");
                ttry++;
            }
        }

        if (login == false) {
            System.out.println("Your account has been locked.");
        } else {

            double balance = 2500.75;
            int choice;

            do {
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Account Status");
                System.out.println("5. Exit");

                System.out.println("Choose:");
                choice = input.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Balance: " + balance);
                        break;

                    case 2:
                        System.out.println("Enter amount:");
                        double deposit = input.nextDouble();

                        if (deposit > 0) {
                            balance = balance + deposit;
                            System.out.println("New Balance: " + balance);
                        } else {
                            System.out.println("Invalid amount.");
                        }
                        break;

                    case 3:
                        System.out.println("Enter amount:");
                        double withdraw = input.nextDouble();

                        if (withdraw == 0) {
                            System.out.println("Transaction cancelled.");
                        } else if (withdraw < 0) {
                            System.out.println("Invalid amount.");
                        } else if (withdraw > balance) {
                            System.out.println("Insufficient balance.");
                        } else {
                            balance = balance - withdraw;
                            System.out.println("New Balance: " + balance);

                            if (balance == 0) {
                                System.out.println("Warning: Your account is empty.");
                            }
                        }
                        break;

                    case 4:
                        if (balance >= 5000) {
                            System.out.println("VIP Customer");
                        } else if (balance >= 1000) {
                            System.out.println("Regular Customer");
                        } else {
                            System.out.println("Low Balance");
                        }
                        break;

                    case 5:
                        System.out.println("Thank you for using our ATM.");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }

            } while (choice != 5);
        }

        input.close();
    }
}
