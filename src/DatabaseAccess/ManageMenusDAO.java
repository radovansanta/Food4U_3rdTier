package DatabaseAccess;

import Models.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageMenusDAO implements ManageMenus {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    // TODO: 01.12.2021 test
    @Override
    public void addMenu(Menu menu) {
        try(Connection connection = databaseConnection.getConnection()){
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
        try(Connection connection = databaseConnection.getConnection()){
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
        try(Connection connection = databaseConnection.getConnection()){
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
    public Menu getMenu(int menuId) {
        Menu menu = new Menu();
        try(Connection connection = databaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM menu WHERE menu_id = ?");
            statement.setInt(1, menuId);
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
    public void deleteMenu(int menuId) {
        try(Connection connection = databaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM menu WHERE menu_id = ?");
            statement.setInt(1, menuId);
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
}
