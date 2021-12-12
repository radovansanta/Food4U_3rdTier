package DatabaseAccess;

import Models.DeliveryOption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageDeliveryOptionsDAO implements ManageDeliveryOptions{

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    // TODO: 01.12.2021 test
    @Override
    public void addDeliveryOption(DeliveryOption deliveryOption) {
        try (Connection connection = databaseConnection.getConnection()) {
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
        try (Connection connection = databaseConnection.getConnection()) {
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
    public DeliveryOption getDeliveryOption(int deliveryId) {
        DeliveryOption deliveryOption = new DeliveryOption();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM delivery WHERE delivery_id = ?");
            statement.setInt(1, deliveryId);
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
        try(Connection connection = databaseConnection.getConnection()) {
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
    public void deleteDeliveryOption(int deliveryId) {
        try(Connection connection = databaseConnection.getConnection()) {
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
}
