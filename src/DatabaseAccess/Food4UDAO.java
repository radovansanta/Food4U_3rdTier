package DatabaseAccess;

import Models.*;

import java.sql.*;
import java.util.ArrayList;

public class Food4UDAO implements ManageRestaurants, ManageDeliveryOptions, ManageMenus, ManageCategories, ManageItems, ManageCustomers
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

    // TODO: 01.12.2021 test
    @Override
    public void addRestaurant(Restaurant restaurant) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO restaurant(user_name, password, name," +
                    "address, phone_number, monday, tuesday, wednesday, thursday, friday, saturday, sunday," +
                    " description, visibility) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
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
            if (restaurant.getDeliveryOption1() != null) {
                addDeliveryOption(restaurant.getDeliveryOption1());
            }
            if (restaurant.getDeliveryOption2() != null) {
                addDeliveryOption(restaurant.getDeliveryOption2());
            }
            if(restaurant.getMenu() != null)
            {
                addMenu(restaurant.getMenu());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Restaurant getRestaurant(String username) {
        Restaurant restaurant = new Restaurant();
        try (Connection connection = getConnection()) {
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

    // TODO: 01.12.2021 test
    @Override
    public void updateRestaurant(Restaurant restaurant) {
        try (Connection connection = getConnection()) {
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
            if(restaurant.getDeliveryOption1() != null)
                updateDeliveryOption(restaurant.getDeliveryOption1());
            if(restaurant.getDeliveryOption2() != null)
                updateDeliveryOption(restaurant.getDeliveryOption2());
            if(restaurant.getMenu() != null)
                updateMenu(restaurant.getMenu());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 01.12.2021 test
    @Override
    public void deleteRestaurant(String username) {
        try(Connection connection = getConnection()){
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
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM restaurant WHERE visibility = true");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
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
            ArrayList<DeliveryOption> deliveryOptions = getDeliveryOptionsByUsername(username);
            Menu menu = getMenuByRestaurant(username);
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
            if (deliveryOptions.size() >= 1) {
                restaurant.setDeliveryOption1(deliveryOptions.get(0));
            }
            if (deliveryOptions.size() >= 2) {
                restaurant.setDeliveryOption2(deliveryOptions.get(1));
            }
            if(menu != null)
                restaurant.setMenu(menu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    // TODO: 01.12.2021 test
    @Override
    public void addDeliveryOption(DeliveryOption deliveryOption) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO delivery(delivery_option, " +
                    "price, user_name) VALUES (?, ?, ?)");
            if (deliveryOption.getDeliveryName().equalsIgnoreCase("takeaway")) {
                statement.setString(1, "Takeaway");
            } else {
                statement.setString(1, "Delivery");
            }
            statement.setDouble(2, deliveryOption.getPrice());
            statement.setString(3, deliveryOption.getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public ArrayList<DeliveryOption> getDeliveryOptionsByUsername(String username) {
        ArrayList<DeliveryOption> deliveryOptions = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM delivery WHERE user_name = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                deliveryOptions.add(getDeliveryOption(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryOptions;
    }

    // TODO: 01.12.2021 test
    @Override
    public DeliveryOption getDeliveryOption(int deliveryID) {
        DeliveryOption deliveryOption = new DeliveryOption();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM delivery WHERE delivery_id = ?");
            statement.setInt(1, deliveryID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                deliveryOption = getDeliveryOption(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryOption;
    }

    // TODO: 01.12.2021 test
    @Override
    public void updateDeliveryOption(DeliveryOption deliveryOption) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE delivery SET delivery_option = ? " +
                    "WHERE delivery_id = ?");
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

    // TODO: 01.12.2021 test
    @Override
    public void deleteDeliveryOption(int deliveryID) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM delivery WHERE delivery_id = ?");
            statement.setInt(1, 1);
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
            String username = resultSet.getString(4);
            deliveryOption.setDeliveryID(deliveryId);
            deliveryOption.setDeliveryName(deliveryName);
            deliveryOption.setPrice(price);
            deliveryOption.setUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryOption;
    }

    // TODO: 01.12.2021 test
    @Override
    public void addMenu(Menu menu) {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO menu(description, user_name)" +
                    "VALUES (?, ?)");
            statement.setString(1, menu.getDescription());
            statement.setString(2, menu.getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 01.12.2021 test
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
    public Menu getMenuByRestaurant(String username) {
        Menu menu = new Menu();
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM menu WHERE user_name = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                menu = getMenu(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    // TODO: 01.12.2021 test
    @Override
    public Menu getMenu(int menuID) {
        Menu menu = new Menu();
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM menu WHERE menu_id = ?");
            statement.setInt(1, menuID);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                menu = getMenu(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    // TODO: 01.12.2021 test
    @Override
    public void deleteMenu(int menuID) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM menu WHERE menu_id = ?");
            statement.setInt(1, menuID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Menu getMenu(ResultSet resultSet){
        Menu menu = new Menu();
        try{
            int menu_id = resultSet.getInt(1);
            String description = resultSet.getString(2);
            String username = resultSet.getString(3);
            menu.setMenuID(menu_id);
            menu.setDescription(description);
            menu.setUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    // TODO: 01.12.2021 test
    @Override
    public void addCategory(Category category) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO category(name, menu_id) VALUES (?, ?)");
            statement.setString(1, category.getName());
            statement.setInt(2, category.getMenuId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 01.12.2021 test
    @Override
    public Category getCategory(int categoryID) {
        Category category = new Category();
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE name = ?");
            statement.setInt(1, categoryID);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                category = getCategory(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    // TODO: 01.12.2021 test
    @Override
    public void deleteCategory(int categoryID){
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM category WHERE category_id = ?");
            statement.setInt(1, categoryID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 06.12.2021 test
    @Override
    public void updateCategory(Category category) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE category SET name = ? WHERE category_id = ?");
            statement.setString(1, category.getName());
            statement.setInt(2, category.getCategoryID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 01.12.2021 test
    @Override
    public ArrayList<Category> getCategoriesByMenuID(int menuID) {
        ArrayList<Category> categories = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE menu_id = ?");
            statement.setInt(1, menuID);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                categories.add(getCategory(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    // TODO: 01.12.2021 test
    private Category getCategory(ResultSet resultSet){
        Category category = new Category();
        try{
            int categoryID = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int menuID = resultSet.getInt(3);
            category.setName(name);
            category.setMenuId(menuID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    // TODO: 01.12.2021 test
    @Override
    public void addItem(Item item) {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO item(name, description, price, " +
                    "category_name, discount) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setString(4, item.getCategoryName());
            statement.setInt(5, item.getDiscount());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 01.12.2021 test 
    @Override
    public Item getItemByItemID(int itemID) {
        Item item = new Item();
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM item WHERE item_id = ?");
            statement.setInt(1, itemID);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                item = getItem(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    // TODO: 01.12.2021 test
    @Override
    public void updateItem(Item item) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE item SET name = ? WHERE item_id = ?");
            statement.setString(1, item.getName());
            statement.setInt(2, item.getItemID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE item SET description = ? WHERE item_id = ?");
            statement.setString(1, item.getDescription());
            statement.setInt(2, item.getItemID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE item SET price = ? WHERE item_id = ?");
            statement.setDouble(1, item.getPrice());
            statement.setInt(2, item.getItemID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE item SET discount = ? WHERE item_id = ?");
            statement.setInt(1, item.getDiscount());
            statement.setInt(2, item.getItemID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 01.12.2021 test 
    @Override
    public void deleteItem(int itemID) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM item WHERE item_id = ?");
            statement.setInt(1, itemID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 01.12.2021 test 
    @Override
    public ArrayList<Item> getItemsByCategoryName(String categoryName) {
        ArrayList<Item> items = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM item WHERE category_name = ?");
            statement.setString(1, categoryName);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                items.add(getItem(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    // TODO: 01.12.2021 test
    private Item getItem(ResultSet resultSet){
        Item item = new Item();
        try{
            int itemID = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            String categoryName = resultSet.getString(5);
            int discount = resultSet.getInt(6);
            item.setItemID(itemID);
            item.setName(name);
            item.setPrice(price);
            item.setDescription(description);
            item.setCategoryName(categoryName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    // TODO: 03.12.2021 test
    @Override
    public void addCustomer(Customer customer) {
        try(Connection connection = getConnection()) {
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

    // TODO: 03.12.2021 test
    @Override
    public void updateCustomer(Customer customer) {
        try(Connection connection = getConnection()) {
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

    // TODO: 03.12.2021 test
    @Override
    public Customer getCustomer(String username) {
        Customer customer = new Customer();
        try(Connection connection = getConnection()) {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM customer WHERE user_name = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                customer = getCustomer(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    // TODO: 03.12.2021 test
    @Override
    public void deleteCustomer(String username) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM customer WHERE username = ?");
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 03.12.2021 test
    private Customer getCustomer(ResultSet resultSet){
        Customer customer = new Customer();
        try{
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
