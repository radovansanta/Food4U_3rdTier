package DatabaseAccess;

import Models.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageDriversDAO implements ManageDrivers {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    @Override
    public void addDriver(Driver driver) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO driver(user_name, first_name, last_name," +
                    "phone_number, email, password, license_number, address) VALUES (?,?,?,?,?,?,?,?)");
            statement.setString(1, driver.getUsername());
            statement.setString(2, driver.getFirstName());
            statement.setString(3, driver.getLastName());
            statement.setString(4, driver.getPhoneNumber());
            statement.setString(5, driver.getEmail());
            statement.setString(6, driver.getPassword());
            statement.setString(7, driver.getLicenseNumber());
            statement.setString(8, driver.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Driver getDriver(String username) {
        Driver driver = new Driver();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM driver WHERE user_name = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                driver = getDriver(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    @Override
    public void updateDriver(Driver driver) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE driver SET password = ? WHERE user_name = ?");
            statement.setString(1, driver.getPassword());
            statement.setString(2, driver.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE driver SET first_name = ? WHERE user_name = ?");
            statement.setString(1, driver.getFirstName());
            statement.setString(2, driver.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE driver SET last_name = ? WHERE user_name = ?");
            statement.setString(1, driver.getLastName());
            statement.setString(2, driver.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE driver SET phone_number = ? WHERE user_name = ?");
            statement.setString(1, driver.getPhoneNumber());
            statement.setString(2, driver.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE driver SET email = ? WHERE user_name = ?");
            statement.setString(1, driver.getEmail());
            statement.setString(2, driver.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE driver SET address = ? WHERE user_name = ?");
            statement.setString(1, driver.getAddress());
            statement.setString(2, driver.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE driver SET license_number = ? WHERE user_name = ?");
            statement.setString(1, driver.getLicenseNumber());
            statement.setString(2, driver.getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDriver(String username) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM driver WHERE user_name = ?");
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Driver getDriver(ResultSet resultSet) {
        Driver driver = new Driver();
        try {
            String username = resultSet.getString(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String phoneNumber = resultSet.getString(4);
            String email = resultSet.getString(5);
            String address = resultSet.getString(6);
            String password = resultSet.getString(7);
            String licenseNumber = resultSet.getString(8);
            driver.setUsername(username);
            driver.setPassword(password);
            driver.setFirstName(firstName);
            driver.setLastName(lastName);
            driver.setPhoneNumber(phoneNumber);
            driver.setEmail(email);
            driver.setAddress(address);
            driver.setLicenseNumber(licenseNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
