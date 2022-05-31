package david.project;

public class Users {

    private String lastName;
    private String firstName;
    private Account account;

    public Users(){

    }

    public Users(String lastName,String firstName,Account account){
        this.lastName = lastName;
        this.firstName = firstName;
        this.account = account;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static CurrencyType selectCurrencyType(String currencyType){
        CurrencyType currencyType1 = null;
        if(currencyType.matches("EUR|eur"))
            currencyType1 = CurrencyType.EUR;
        else if(currencyType.matches("RON|ron"))
            currencyType1 = CurrencyType.RON;
        return currencyType1;
    }

    @Override
    public String toString() {
        return "\nName: " + getLastName()+" "+ getFirstName()+
                "\nAccount Details: " + "\n\t" + account.toString();
    }
}
