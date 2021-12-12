package DatabaseAccess;

import Models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageCategoriesDAO implements ManageCategories{

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    // TODO: 01.12.2021 test
    @Override
    public void addCategory(Category category) {
        try(Connection connection = databaseConnection.getConnection()) {
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
    public Category getCategory(int categoryId) {
        Category category = new Category();
        try(Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE category_id = ?");
            statement.setInt(1, categoryId);
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
    public void deleteCategory(int categoryId){
        try(Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM category WHERE category_id = ?");
            statement.setInt(1, categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 06.12.2021 test
    @Override
    public void updateCategory(Category category) {
        try(Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE category SET name = ? WHERE category_id = ?");
            statement.setString(1, category.getName());
            statement.setInt(2, category.getCategoryID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 01.12.2021 test
    @Override
    public ArrayList<Category> getCategoriesByMenuId(int menuId) {
        ArrayList<Category> categories = new ArrayList<>();
        try(Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE menu_id = ?");
            statement.setInt(1, menuId);
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
            String name = resultSet.getString(1);
            int categoryId = resultSet.getInt(2);
            int menuID = resultSet.getInt(3);
            category.setCategoryID(categoryId);
            category.setName(name);
            category.setMenuId(menuID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
