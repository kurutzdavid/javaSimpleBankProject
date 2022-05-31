package david.project;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Account implements  AccountCriterion{

    private String IBAN;
    private Double currentAmount;
    private LocalDateTime creationDate;
    private CurrencyType currencyType;


    public List<Transactions> listOfTransactions = new ArrayList<>();
    public List<ActionTypeClass> historyOfAccount = new ArrayList<>();

    public Account(){
        this.creationDate = LocalDateTime.now();
    }

    public Account(String IBAN,Double currentAmount,CurrencyType currencyType){
        this.IBAN = IBAN;
        this.currentAmount = currentAmount;
        this.creationDate = LocalDateTime.now();
        this.currencyType = currencyType;
    }


    public String getIBAN() {
        return IBAN;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public String getCreationDate() {
        return "Date: " + creationDate.toLocalDate() + " Hour: " + creationDate.toLocalTime().truncatedTo(ChronoUnit.MINUTES);
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void transferMoney(String IBAN, double amt,String name){
        if(this.currentAmount > amt) {
            currentAmount = currentAmount - amt;
            listOfTransactions.add(new Transactions(IBAN, amt,name));
            System.out.println("Successful Transaction!");
        }else{
            System.out.println("Your balance is not enough!\nYou only have :"+getCurrentAmount());
        }
    }

    @Override
    public void deposit(double amt){
        this.currentAmount += amt;
        historyOfAccount.add(new ActionTypeClass(amt,ActionType.Deposit));
        System.out.println("\tSuccessful Deposit");
    }

    @Override
    public void withdrawal(double amt){
        if(this.currentAmount < amt){
            System.out.println("Your balance is not enough!\nYou only have "+getCurrentAmount());
        }else {
            this.currentAmount -= amt;
            historyOfAccount.add(new ActionTypeClass(amt,ActionType.Withdrawal));
            System.out.println("Successful Withdrawal!");
        }
    }

    public Optional<Transactions> filterTransactionsByIBAN(String IBAN){
        return listOfTransactions.stream()
                .filter(iban -> iban.getIBAN().equals(IBAN))
                .findAny();
    }

    public Optional<Transactions> filterTransactionsByAMT(double amt){
        return listOfTransactions.stream()
                .filter(iban -> iban.getAmt() == amt)
                .findAny();
    }

    public void viewListOfTransaction(){
        if(listOfTransactions.isEmpty()){
            System.out.println("There are no transactions");
        }else {
            for (Transactions t : listOfTransactions) {
                System.out.println(t);
            }
        }
    }

    public void viewListOfActions(){
        if(historyOfAccount.isEmpty()){
            System.out.println("There is no movement on the account");
        }else{
            for(ActionTypeClass a : historyOfAccount){
                System.out.println(a);
            }
        }
    }


    @Override
    public String toString() {
        return "IBAN: " + getIBAN()+ "\n\tCurrency Amount: "+getCurrentAmount()+"\n\tCreation Date: "+getCreationDate()+
                "\n\tCurrency Type: "+ getCurrencyType()+"\n\n";
    }
}
