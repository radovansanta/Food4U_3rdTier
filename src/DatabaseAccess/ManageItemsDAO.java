package DatabaseAccess;

import Models.Item;
import Models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageItemsDAO implements ManageItems {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    @Override
    public void addItem(Item item) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO item(name, description, price, " +
                    "category_id, discount) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setInt(4, item.getCategoryId());
            statement.setInt(5, item.getDiscount());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item getItemByItemId(int itemId) {
        Item item = new Item();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM item WHERE item_id = ?");
            statement.setInt(1, itemId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                item = getItem(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void updateItem(Item item) {
        try (Connection connection = databaseConnection.getConnection()) {
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

    @Override
    public void deleteItem(int itemId) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM item WHERE item_id = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Item> getItemsByCategoryId(int categoryId) {
        ArrayList<Item> items = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM item WHERE category_id = ?");
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(getItem(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void orderItems(Order order) {
        try(Connection connection = databaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ordereditem(order_id, item_id)" +
                    " VALUES (?,?)");
            for (int i = 0; i < order.getItems().size(); i++) {
                statement.setInt(1, order.getOrderID());
                statement.setInt(2, order.getItems().get(i).getItemID());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Item> getItemsOrdered(int orderId) {
        ArrayList<Item> items = new ArrayList<>();
        try(Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ordereditem WHERE order_id = ?");
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int order_id = resultSet.getInt(1);
                int item_id = resultSet.getInt(2);
                items.add(getItemByItemId(item_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    private Item getItem(ResultSet resultSet) {
        Item item = new Item();
        try {
            int itemID = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            int categoryId = resultSet.getInt(5);
            int discount = resultSet.getInt(6);
            item.setItemID(itemID);
            item.setName(name);
            item.setPrice(price);
            item.setDescription(description);
            item.setCategoryId(categoryId);
            item.setDiscount(discount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}
