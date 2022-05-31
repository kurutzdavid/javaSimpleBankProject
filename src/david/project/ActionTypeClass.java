package david.project;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ActionTypeClass {

    private double amount;
    private ActionType actionType;

    private LocalDateTime creationDate;

    public ActionTypeClass(double amount,ActionType actionType){
        this.amount = amount;
        this.actionType = actionType;
        this.creationDate = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public String getCreationDate() {
        return "Date: " + creationDate.toLocalDate() + " Hour: " + creationDate.toLocalTime().truncatedTo(ChronoUnit.MINUTES);
    }

    @Override
    public String toString() {
        return "\nType: " + getActionType() + "\nAmount: " + getAmount() + "\nDate: " + getCreationDate();
    }
}
