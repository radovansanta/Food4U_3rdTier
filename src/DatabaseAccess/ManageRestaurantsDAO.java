package DatabaseAccess;

import Models.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageRestaurantsDAO implements ManageRestaurants {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    @Override
    public void addRestaurant(Restaurant restaurant) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO restaurant(user_name, password, name," +
                    "address, phone_number, monday, tuesday, wednesday, thursday, friday, saturday, sunday," +
                    " description, visibility) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, restaurant.getUsername());
            statement.setString(2, restaurant.getPassword());
            statement.setString(3, restaurant.getName());
            statement.setString(4, restaurant.getAddress());
            statement.setString(5, restaurant.getPhoneNumber());
            statement.setString(6, restaurant.getOpeningHoursMonday());
            statement.setString(7, restaurant.getOpeningHoursTuesday());
            statement.setString(8, restaurant.getOpeningHoursWednesday());
            statement.setString(9, restaurant.getOpeningHoursThursday());
            statement.setString(10, restaurant.getOpeningHoursFriday());
            statement.setString(11, restaurant.getOpeningHoursSaturday());
            statement.setString(12, restaurant.getOpeningHoursSunday());
            statement.setString(13, restaurant.getDescription());
            statement.setBoolean(14, restaurant.getVisibility());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurant(String username) {
        Restaurant restaurant = new Restaurant();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM restaurant WHERE user_name = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                restaurant = getRestaurant(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE restaurant SET name = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getName());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET address = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getAddress());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET phone_number = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getPhoneNumber());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET monday = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getOpeningHoursMonday());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET tuesday = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getOpeningHoursTuesday());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET wednesday = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getOpeningHoursWednesday());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET thursday = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getOpeningHoursThursday());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET friday = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getOpeningHoursFriday());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET saturday = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getOpeningHoursSaturday());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET sunday = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getOpeningHoursSunday());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET description = ? WHERE user_name = ?");
            statement.setString(1, restaurant.getDescription());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET visibility = ? WHERE user_name = ?");
            statement.setBoolean(1, restaurant.getVisibility());
            statement.setString(2, restaurant.getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRestaurant(String username) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM restaurant WHERE user_name = ?");
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Restaurant> getRestaurants() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM restaurant WHERE visibility = true");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                restaurants.add(getRestaurant(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    private Restaurant getRestaurant(ResultSet resultSet) {
        Restaurant restaurant = new Restaurant();
        try {
            String username = resultSet.getString(1);
            String password = resultSet.getString(2);
            String name = resultSet.getString(3);
            String address = resultSet.getString(4);
            String phoneNumber = resultSet.getString(5);
            String openingHoursMonday = resultSet.getString(6);
            String openingHoursTuesday = resultSet.getString(7);
            String openingHoursWednesday = resultSet.getString(8);
            String openingHoursThursday = resultSet.getString(9);
            String openingHoursFriday = resultSet.getString(10);
            String openingHoursSaturday = resultSet.getString(11);
            String openingHoursSunday = resultSet.getString(12);
            String description = resultSet.getString(13);
            boolean visibility = resultSet.getBoolean(14);
            restaurant.setUsername(username);
            restaurant.setPassword(password);
            restaurant.setName(name);
            restaurant.setAddress(address);
            restaurant.setPhoneNumber(phoneNumber);
            restaurant.setOpeningHoursMonday(openingHoursMonday);
            restaurant.setOpeningHoursTuesday(openingHoursTuesday);
            restaurant.setOpeningHoursWednesday(openingHoursWednesday);
            restaurant.setOpeningHoursThursday(openingHoursThursday);
            restaurant.setOpeningHoursFriday(openingHoursFriday);
            restaurant.setOpeningHoursSaturday(openingHoursSaturday);
            restaurant.setOpeningHoursSunday(openingHoursSunday);
            restaurant.setDescription(description);
            restaurant.setVisibility(visibility);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }
}
