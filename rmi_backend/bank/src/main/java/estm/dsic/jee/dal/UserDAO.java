package estm.dsic.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estm.dsic.jee.Models.User;

public class UserDAO {
    // ...

    // Create (Add) a new user
    public void addUser(User user) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO users (email, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to add user to the database.", e);
        }
    }

    // Read (Get) a user by email
    public User getUserByEmail(String email) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String userEmail = resultSet.getString("email");
                        String userPassword = resultSet.getString("password");
                        return new User(userEmail, userPassword);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve user from the database.", e);
        }
        return null; // User not found
    }

    // Update an existing user
    public void updateUser(User updatedUser) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "UPDATE users SET password = ? WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, updatedUser.getPassword());
                preparedStatement.setString(2, updatedUser.getEmail());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update user in the database.", e);
        }
    }

    // Delete a user by email
    public void deleteUserByEmail(String email) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "DELETE FROM users WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to delete user from the database.", e);
        }
    }

    // Get all users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String userEmail = resultSet.getString("email");
                        String userPassword = resultSet.getString("password");
                        userList.add(new User(userEmail, userPassword));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve users from the database.", e);
        }
        return userList;
    }
}

