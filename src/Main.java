import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int balance = 50000, pin = 8754, pin_limit = 0, type_times = 0;
        String acc_typ = "Saving";
        int withdraw, deposit;
        Scanner in = new Scanner(System.in);
        System.out.println("\t****Welcome to Everest bank ATM!****\n");
        System.out.print("Enter Your Card Detail: ");
        String str = in.next();
//        long card = Long.parseLong(str);
        int len_card = str.length();
        if (len_card == 16) {
            System.out.println("Nice Your Card is valid...Please Go ahead");

            while (pin_limit < 3) {
                System.out.print("Please Enter Your Pin: ");
                int Entered_pin = in.nextInt();
                if (Entered_pin == pin) {
                    while (type_times <= 4) {
                        System.out.println("1. Saving A/c");
                        System.out.println("2. Current A/c");
                        System.out.println("3. Current & OD A/c");
                        System.out.println("4. Exit");
                        int type = in.nextInt();
                        type_times += 1;
                        switch (type) {
                            case 1:
                                if (acc_typ.equals("Saving"))
                                    account(balance, "Saving");
                                else
                                    System.out.println("Sorry..you don't have Saving A/c, Please Select Correct A/c type..");
                                break;
                            case 2:
                                if (acc_typ.equals("Current"))
                                    account(balance, "Current");
                                else
                                    System.out.println("Sorry..you don't have Current A/c, Please Select Correct A/c type..");
                                break;
                            case 3:
                                if (acc_typ.equals("Current & OD"))
                                    account(balance, "Current & OD");
                                else
                                    System.out.println("Sorry..you don't have Current & OD A/c, Please Select Correct A/c type...");
                                break;
                            case 4:
                                System.exit(0);
                            default:
                                System.out.println("Please Select From Given Option only...");
                        }


                    }

                } else {
                    System.out.println("\nWrong Pin " + "Remaining Attempt " + (2 - pin_limit));
                    if ((2 - pin_limit) == 0) {
                        System.out.println("You have Entered Wrong Pin Max. Times So Your Card is Blocked for Today...");
                    }

                }

                pin_limit += 1;
            }
        } else {
            System.out.println("Duplicate Card....Get Lost");
        }
    }

    public static void printBalance(int balance) {
        System.out.println(" The Current Balance : " + balance);
        System.out.println();
    }

    public static int withdraw(int balance, int withdrawAmount) {
        System.out.println("Withdrawn Operation :");
        System.out.println("The withdrawing Amount is : " + withdrawAmount);
        if (balance >= withdrawAmount) {
            balance = balance - withdrawAmount;
            System.out.println("Please collect your money and remove the card");
            printBalance(balance);
        } else {
            System.out.println("Sorry! the balance is insufficient.");
            System.out.println();
        }
        return balance;
    }

    public static int deposit(int balance, int depositAmount) {
        System.out.println("Deposit Operation :");
        System.out.println(" The depositing amount is : " + depositAmount);
        balance = balance + depositAmount;
        System.out.println("Your Money has been successfully deposited");
        printBalance(balance);
        return balance;
    }

    public static void account(int balance, String acc_name) {
        int withdraw, deposit;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome back..to your " + acc_name + " A/c");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. EXIT");
            System.out.print("Select options you want to perform:");
            int op = in.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.print("Enter the amount to be withdrawn :");
                    withdraw = in.nextInt();
                    balance = withdraw(balance, withdraw);
                }
                case 2 -> {
                    System.out.print("Enter the amount to be deposited :");
                    deposit = in.nextInt();
                    balance = deposit(balance, deposit);
                }
                case 3 -> {
                    printBalance(balance);
                    System.out.println(" ");
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Please Select From Given Option only...");
            }
        }
    }

}


