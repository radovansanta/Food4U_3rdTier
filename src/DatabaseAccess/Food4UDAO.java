package DatabaseAccess;

import Models.*;

import java.sql.*;
import java.util.ArrayList;

public class Food4UDAO implements ManageUsers, ManageRestaurants, ManageDeliveryOptions, ManageMenus, ManageCategories, ManageItems {
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
        try (Connection connection = getConnection()) {
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
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO restaurant(name," +
                    "address, phone_number, monday, tuesday, wednesday, thursday, friday, saturday, sunday," +
                    " description) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, restaurant.getName());
            statement.setString(2, restaurant.getAddress());
            statement.setString(3, restaurant.getPhoneNumber());
            statement.setString(4, restaurant.getOpeningHoursMonday());
            statement.setString(5, restaurant.getOpeningHoursTuesday());
            statement.setString(6, restaurant.getOpeningHoursWednesday());
            statement.setString(7, restaurant.getOpeningHoursThursday());
            statement.setString(8, restaurant.getOpeningHoursFriday());
            statement.setString(9, restaurant.getOpeningHoursSaturday());
            statement.setString(10, restaurant.getOpeningHoursSunday());
            statement.setString(11, restaurant.getDescription());
            statement.executeUpdate();
            Restaurant restaurant1 = getRestaurantByName(restaurant.getName());
            if (restaurant.getDeliveryOption1() != null) {
                addDeliveryOption(restaurant.getDeliveryOption1(), restaurant1.getRestaurantID());
            }
            if (restaurant.getDeliveryOption2() != null) {
                addDeliveryOption(restaurant.getDeliveryOption2(), restaurant1.getRestaurantID());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurant(int restaurantID) {
        Restaurant restaurant = new Restaurant();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM restaurant WHERE restaurant_id = ?");
            statement.setInt(1, restaurantID);
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
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE restaurant SET name = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getName());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET address = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getAddress());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET phone_number = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getPhoneNumber());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET monday = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getOpeningHoursMonday());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET tuesday = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getOpeningHoursTuesday());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET wednesday = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getOpeningHoursWednesday());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET thursday = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getOpeningHoursThursday());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET friday = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getOpeningHoursFriday());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET saturday = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getOpeningHoursSaturday());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET sunday = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getOpeningHoursSunday());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE restaurant SET description = ? WHERE restaurant_id = ?");
            statement.setString(1, restaurant.getDescription());
            statement.setInt(2, restaurant.getRestaurantID());
            statement.executeUpdate();
            updateDeliveryOption(restaurant.getDeliveryOption1());
            updateDeliveryOption(restaurant.getDeliveryOption2());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        Restaurant restaurant = new Restaurant();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM restaurant WHERE name = ?");
            statement.setString(1, name);
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
    public void deleteRestaurant(int restaurantID) {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM restaurant WHERE restaurant_id = ?");
            statement.setInt(1, restaurantID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Restaurant getRestaurant(ResultSet resultSet) {
        Restaurant restaurant = new Restaurant();
        try {
            int restaurant_id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phoneNumber = resultSet.getString(4);
            String openingHoursMonday = resultSet.getString(5);
            String openingHoursTuesday = resultSet.getString(6);
            String openingHoursWednesday = resultSet.getString(7);
            String openingHoursThursday = resultSet.getString(8);
            String openingHoursFriday = resultSet.getString(9);
            String openingHoursSaturday = resultSet.getString(10);
            String openingHoursSunday = resultSet.getString(11);
            String description = resultSet.getString(12);
            ArrayList<DeliveryOption> deliveryOptions = getDeliveryOption(restaurant_id);
            restaurant.setRestaurantID(restaurant_id);
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
            if (deliveryOptions.size() >= 1) {
                restaurant.setDeliveryOption1(deliveryOptions.get(0));
            }
            if (deliveryOptions.size() >= 2) {
                restaurant.setDeliveryOption2(deliveryOptions.get(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public void addDeliveryOption(DeliveryOption deliveryOption, int restaurantID) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO delivery(delivery_option, " +
                    "price, restaurant_id) VALUES (?, ?, ?)");
            if (deliveryOption.getDeliveryName().equalsIgnoreCase("takeaway")) {
                statement.setString(1, "Takeaway");
            } else {
                statement.setString(1, "Delivery");
            }
            statement.setDouble(2, deliveryOption.getPrice());
            statement.setInt(3, restaurantID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<DeliveryOption> getDeliveryOption(int restaurantID) {
        ArrayList<DeliveryOption> deliveryOptions = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM delivery WHERE restaurant_id = ?");
            statement.setInt(1, restaurantID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                deliveryOptions.add(getDeliveryOption(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryOptions;
    }

    @Override
    public void updateDeliveryOption(DeliveryOption deliveryOption) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE delivery SET delivery_option = ? WHERE delivery_id = ?");
            if (deliveryOption.getDeliveryName().equalsIgnoreCase("takeaway")) {
                statement.setString(1, "Takeaway");
            } else {
                statement.setString(1, "Delivery");
            }
            statement.setInt(2, deliveryOption.getDeliveryID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE delivery SET price = ? WHERE delivery_id = ?");
            statement.setDouble(1, deliveryOption.getPrice());
            statement.setInt(2, deliveryOption.getDeliveryID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DeliveryOption getDeliveryOption(ResultSet resultSet) {
        DeliveryOption deliveryOption = new DeliveryOption();
        try {
            int deliveryId = resultSet.getInt(1);
            String deliveryName = resultSet.getString(2);
            double price = resultSet.getDouble(3);
            int restaurantId = resultSet.getInt(4);
            deliveryOption.setDeliveryID(deliveryId);
            deliveryOption.setDeliveryName(deliveryName);
            deliveryOption.setPrice(price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryOption;
    }

    public void addMenu(Menu menu, int restaurantID) {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO menu(description, restaurant_id)" +
                    "VALUES (?, ?)");
            statement.setString(1, menu.getDescription());
            statement.setInt(2, restaurantID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateMenu(Menu menu) {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE menu SET description = ? WHERE menu_id = ?");
            statement.setString(1, menu.getDescription());
            statement.setInt(2, menu.getMenuID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCategory(Category category, int menuID) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO category(name, menu_id) VALUES (?, ?)");
            statement.setString(1, category.getName());
            statement.setInt(2, menuID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void addItem(Item item, String categoryName) {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO item(name, description, price, category_name)" +
                    "VALUES (?, ?, ?, ?)");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setString(4, categoryName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateCategory(Category category) {

    }
}