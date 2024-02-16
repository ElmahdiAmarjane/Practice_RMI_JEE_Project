package estm.dsic.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estm.dsic.jee.Models.Account;

public class AccountDAO {
    // ...

    // Create (Add) a new account
    public void addAccount(Account account) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO accounts (amount, accountId, userEmail) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDouble(1, account.getAmount());
                preparedStatement.setString(2, account.getAccountId());
                preparedStatement.setString(3, account.getUserEmail());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to add account to the database.", e);
        }
    }

   // Delete an account by user's email
   public void deleteAccountByEmail(String userEmail) {
    try (Connection connection = DatabaseConnector.getConnection()) {
        String query = "DELETE FROM accounts WHERE userEmail = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userEmail);
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to delete account from the database.", e);
    }
}

// Get an account by user's email
public Account getAccountByEmail(String userEmail) {
    try (Connection connection = DatabaseConnector.getConnection()) {
        String query = "SELECT * FROM accounts WHERE userEmail = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userEmail);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    double amount = resultSet.getDouble("amount");
                    String accountId = resultSet.getString("accountId");
                    return new Account(amount, accountId, userEmail);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to retrieve account from the database.", e);
    }
    return null; // Account not found
}

// Update an existing account by user's email
public void updateAccountByEmail(Account updatedAccount) {
    try (Connection connection = DatabaseConnector.getConnection()) {
        String query = "UPDATE accounts SET amount = ? WHERE userEmail = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, updatedAccount.getAmount());
            preparedStatement.setString(2, updatedAccount.getUserEmail());
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to update account in the database.", e);
    }
}

    public List<Account> getAllAccounts() {
        List<Account> accountList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM accounts";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        double amount = resultSet.getDouble("amount");
                        String accountId = resultSet.getString("accountId");
                        String userEmail = resultSet.getString("userEmail");
                        accountList.add(new Account(amount, accountId, userEmail));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve accounts from the database.", e);
        }
        return accountList;
    }
}
