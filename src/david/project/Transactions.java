package david.project;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Transactions {

    public String name;
    public String IBAN;
    public double amt;

    private LocalDateTime transactionDate;

    public Transactions(String IBAN, double amt,String name) {
        this.IBAN = IBAN;
        this.amt = amt;
        this.name = name;
        this.transactionDate = LocalDateTime.now();
    }

    public Transactions(){
        System.out.println("There are no transactions!");
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public String getTransactionDate(){
        return "Date: " + transactionDate.toLocalDate() + " Hour: " + transactionDate.toLocalTime().truncatedTo(ChronoUnit.MINUTES);
    }


    @Override
    public String toString() {
        return "\nName: " +name +"\nIBAN: "+getIBAN()+"\nAmount: "+getAmt()+"\nTransaction Date: "+getTransactionDate();
    }
}
