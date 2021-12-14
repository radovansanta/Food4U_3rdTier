package DatabaseAccess;

import Models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageCategoriesDAO implements ManageCategories {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    @Override
    public void addCategory(Category category) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO category(name, menu_id) VALUES (?, ?)");
            statement.setString(1, category.getName());
            statement.setInt(2, category.getMenuId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category getCategory(int categoryId) {
        Category category = new Category();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE category_id = ?");
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                category = getCategory(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void deleteCategory(int categoryId) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM category WHERE category_id = ?");
            statement.setInt(1, categoryId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(Category category) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE category SET name = ? WHERE category_id = ?");
            statement.setString(1, category.getName());
            statement.setInt(2, category.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Category> getCategoriesByMenuId(int menuId) {
        ArrayList<Category> categories = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE menu_id = ?");
            statement.setInt(1, menuId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                categories.add(getCategory(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    private Category getCategory(ResultSet resultSet) {
        Category category = new Category();
        try {
            int categoryId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int menuID = resultSet.getInt(3);
            category.setCategoryId(categoryId);
            category.setName(name);
            category.setMenuId(menuID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
