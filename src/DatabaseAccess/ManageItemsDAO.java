package DatabaseAccess;

import Models.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageItemsDAO implements ManageItems{

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    // TODO: 01.12.2021 test
    @Override
    public void addItem(Item item) {
        try(Connection connection = databaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO item(name, description, price, " +
                    "category_name, discount) VALUES (?, ?, ?, ?, ?)");
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

    // TODO: 01.12.2021 test
    @Override
    public Item getItemByItemId(int itemId) {
        Item item = new Item();
        try(Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM item WHERE item_id = ?");
            statement.setInt(1, itemId);
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
        try(Connection connection = databaseConnection.getConnection()) {
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
    public void deleteItem(int itemId) {
        try(Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM item WHERE item_id = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 01.12.2021 test
    @Override
    public ArrayList<Item> getItemsByCategoryId(int categoryId) {
        ArrayList<Item> items = new ArrayList<>();
        try(Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM item WHERE category_id = ?");
            statement.setInt(1, categoryId);
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
