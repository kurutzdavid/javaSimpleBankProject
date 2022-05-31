package david.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String lastName,firstName,IBAN,currencyType;
        double amt;
        int op;

        System.out.println("Welcome");
        System.out.print("Last name: ");
        lastName = in.next();
        System.out.print("First name: ");
        firstName = in.next();
        System.out.print("IBAN: ");
        IBAN = in.next();
        System.out.print("Current Amount: ");
        amt = in.nextDouble();
        System.out.print("Currency Type: (RON/EUR): ");
        currencyType = in.next();
        Users user1 = new Users(lastName,firstName,new Account(IBAN,amt,Users.selectCurrencyType(currencyType)));

        do{
            System.out.println("\t\nMenu");
            System.out.println("1 Your Account");
            System.out.println("2 Deposit");
            System.out.println("3 Withdrawal");
            System.out.println("4 Your balance");
            System.out.println("5 Initiate Transaction");
            System.out.println("6 View transaction list");
            System.out.println("7 Find transaction by IBAN");
            System.out.println("8 View deposit or withdrawal history");
            System.out.println("0 Exit");
            System.out.print("Input your option: ");

            op = in.nextInt();
            System.out.println();
            switch (op) {
                case 4 -> {
                    System.out.println("\tYour balance is: " + user1.getAccount().getCurrentAmount() + " " + user1.getAccount().getCurrencyType());
                }
                case 2 -> {
                    System.out.println("\tDeposit");
                    double amount;
                    System.out.print("\tAmount: ");
                    amount = in.nextDouble();
                    user1.getAccount().deposit(amount);
                }
                case 3 -> {
                    System.out.println("\tWithdrawal");
                    double amount;
                    System.out.print("\tAmount: ");
                    amount = in.nextDouble();
                    user1.getAccount().withdrawal(amount);
                }
                case 1 -> {
                    System.out.println("\tYour Account");
                    System.out.println(user1);
                }
                case 5 -> {
                    System.out.println("\tInitiate Transaction");
                    String nameOfBeneficiary, IBAN_beneficiary;
                    double amount;
                    System.out.print("Send to: ");
                    nameOfBeneficiary = in.next();
                    System.out.print("Account(IBAN): ");
                    IBAN_beneficiary = in.next();
                    System.out.print("Amount: ");
                    amount = in.nextDouble();
                    user1.getAccount().transferMoney(IBAN_beneficiary, amount, nameOfBeneficiary);
                }

                case 6 -> {
                    System.out.println("\tTransactions List");
                    user1.getAccount().viewListOfTransaction();
                }

                case 7 ->{
                    System.out.println("\tFind transaction by IBAN");
                    String IBAN_TR;
                    System.out.print("IBAN: ");
                    IBAN_TR = in.next();
                    user1.getAccount().filterTransactionsByIBAN(IBAN_TR).orElse(new Transactions());
                }

                case 8 ->{
                    System.out.println("\tView deposit or withdrawal history");
                    user1.getAccount().viewListOfActions();
                }
            }
        }while(op != 0);

        in.close();
    }

}