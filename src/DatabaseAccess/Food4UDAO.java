package DatabaseAccess;

import Models.Restaurant;
import Models.User;

import java.sql.*;

public class Food4UDAO implements ManageUsers, ManageRestaurants
{
    private static Food4UDAO instance;

    public static Food4UDAO getInstance() {
        if (instance == null)
            instance = new Food4UDAO();
        return instance;
    }

    private Food4UDAO() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=food4u",
                "postgres", "maria5561");
    }


    @Override
    public User getUser(String username) {
        User user = new User();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM login WHERE user_name = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = getUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO login(user_name, password) VALUES (?,?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User getUser(ResultSet resultSet) {
        User user = new User();
        try {
            String username = resultSet.getString(1);
            String password = resultSet.getString(2);
            user.setUsername(username);
            user.setPassword(password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO restaurant(name," +
                    "address, phone_number, opening_hours, description) VALUES (?,?,?,?,?)");
            statement.setString(1, restaurant.getName());
            statement.setString(2, restaurant.getAddress());
            statement.setString(3, restaurant.getPhoneNumber());
            statement.setString(4, restaurant.getOpeningHours());
            statement.setString(5, restaurant.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}