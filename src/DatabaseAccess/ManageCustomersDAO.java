package DatabaseAccess;

import Models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageCustomersDAO implements ManageCustomers {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    @Override
    public void addCustomer(Customer customer) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customer(user_name, password," +
                    "first_name, last_name, phone_number, email, address) VALUES (?,?,?,?,?,?,?)");
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getFirstName());
            statement.setString(4, customer.getLastName());
            statement.setString(5, customer.getPhoneNumber());
            statement.setString(6, customer.getEmail());
            statement.setString(7, customer.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE customer SET password = ? WHERE user_name = ?");
            statement.setString(1, customer.getPassword());
            statement.setString(2, customer.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE customer SET first_name = ? WHERE user_name = ?");
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE customer SET last_name = ? WHERE user_name = ?");
            statement.setString(1, customer.getLastName());
            statement.setString(2, customer.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE customer SET address = ? WHERE user_name = ?");
            statement.setString(1, customer.getAddress());
            statement.setString(2, customer.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE customer SET phone_number = ? WHERE user_name = ?");
            statement.setString(1, customer.getPhoneNumber());
            statement.setString(2, customer.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE customer SET email = ? WHERE user_name = ?");
            statement.setString(1, customer.getEmail());
            statement.setString(2, customer.getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(String username) {
        Customer customer = new Customer();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE user_name = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = getCustomer(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void deleteCustomer(String username) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM customer WHERE user_name = ?");
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer getCustomer(ResultSet resultSet) {
        Customer customer = new Customer();
        try {
            String userName = resultSet.getString(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String phoneNumber = resultSet.getString(4);
            String email = resultSet.getString(5);
            String address = resultSet.getString(6);
            String password = resultSet.getString(7);
            customer.setUsername(userName);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setPhoneNumber(phoneNumber);
            customer.setEmail(email);
            customer.setAddress(address);
            customer.setPassword(password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
