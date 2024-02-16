package estm.dsic.jee.Models;

public class Account {
    private double amount;
    private String accountId;
    private String userEmail;

    // Constructor
    public Account(double amount, String accountId, String userEmail) {
        this.amount = amount;
        this.accountId = accountId;
        this.userEmail = userEmail;
    }

    // Getter for amount
    public double getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter for accountId
    public String getAccountId() {
        return accountId;
    }

    // Setter for accountId
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    // Getter for userEmail
    public String getUserEmail() {
        return userEmail;
    }

    // Setter for userEmail
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

