package DatabaseAccess;

import Models.Item;
import Models.Order;

import javax.crypto.CipherInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageOrdersDAO implements ManageOrders {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    // TODO: 07.12.2021 test
    @Override
    public void addOrder(Order order) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO purchase(address, comment, " +
                    "customer_username, total_price, date, restaurant_username, delivery_option, status, driver_username) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)");
            statement.setString(1, order.getAddress());
            statement.setString(2, order.getComment());
            statement.setString(3, order.getCustomerUsername());
            statement.setDouble(4, order.getPrice());
            statement.setString(5, order.getDate());
            statement.setString(6, order.getRestaurantUsername());
            statement.setInt(7, order.getDeliveryID());
            statement.setString(8, "Incoming");
            statement.setString(9, order.getDriverUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 13.12.2021 test
    @Override
    public Order getOrder(int orderId) {
        Order order = new Order();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM purchase WHERE order_id = ?");
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order = getOrder(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    // TODO: 09.12.2021 test
    @Override
    public ArrayList<Order> getIncomingOrders(String restaurantUsername) {
        ArrayList<Order> orders = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM purchase WHERE restaurant_username = ?" +
                    "AND status = 'Incoming'");
            statement.setString(1, restaurantUsername);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(getOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public ArrayList<Order> getAcceptedOrders(String restaurantUsername) {
        ArrayList<Order> orders = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM purchase WHERE restaurant_username = ?" +
                    "AND status = 'Accepted'");
            statement.setString(1, restaurantUsername);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(getOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public ArrayList<Order> getPreviousOrders(String customerUsername) {
        ArrayList<Order> orders = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM purchase WHERE customer_username = ?" +
                    "AND status = 'Completed'");
            statement.setString(1, customerUsername);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(getOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public ArrayList<Order> getReadyForPickUpOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM purchase WHERE status = 'Driver pick up'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(getOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void updateOrder(Order order) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE purchase SET status = ? WHERE order_id = ?");
            if(order.getStatus().equalsIgnoreCase("incoming"))
                statement.setString(1, "Incoming");
            if (order.getStatus().equalsIgnoreCase("accepted"))
                statement.setString(1, "Accepted");
            if (order.getStatus().equalsIgnoreCase("declined"))
                statement.setString(1, "Declined");
            if (order.getStatus().equalsIgnoreCase("driver pick up"))
                statement.setString(1, "Driver pick up");
            if (order.getStatus().equalsIgnoreCase("customer pick up"))
                statement.setString(1, "Customer pick up");
            if (order.getStatus().equalsIgnoreCase("completed"))
                statement.setString(1, "Completed");
            statement.setInt(2, order.getOrderID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE purchase SET restaurant_username = ? WHERE order_id = ?");
            statement.setString(1, order.getRestaurantUsername());
            statement.setInt(2, order.getOrderID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE purchase SET customer_username = ? WHERE order_id = ?");
            statement.setString(1, order.getCustomerUsername());
            statement.setInt(2, order.getOrderID());
            statement.executeUpdate();
            statement = connection.prepareStatement("UPDATE purchase SET driver_username = ? WHERE order_id = ?");
            statement.setString(1, order.getDriverUsername());
            statement.setInt(2, order.getOrderID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Order getOrder(ResultSet resultSet) {
        Order order = new Order();
        try {
            String address = resultSet.getString(1);
            String comment = resultSet.getString(2);
            int orderID = resultSet.getInt(3);
            String customerUsername = resultSet.getString(4);
            double price = resultSet.getDouble(5);
            String date = resultSet.getString(6);
            String restaurantUsername = resultSet.getString(7);
            int deliveryID = resultSet.getInt(8);
            String status = resultSet.getString(9);
            String driverUsername = resultSet.getString(10);
            order.setAddress(address);
            order.setComment(comment);
            order.setOrderID(orderID);
            order.setCustomerUsername(customerUsername);
            order.setPrice(price);
            order.setDate(date);
            order.setRestaurantUsername(restaurantUsername);
            order.setDeliveryID(deliveryID);
            order.setStatus(status);
            order.setDriverUsername(driverUsername);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
