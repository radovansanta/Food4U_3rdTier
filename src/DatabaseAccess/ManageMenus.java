package DatabaseAccess;

import Models.Menu;

public interface ManageMenus {

    void addMenu(Menu menu);
    void updateMenu(Menu menu);
    Menu getMenuByRestaurant(String username);
    Menu getMenu(int menuId);
    void deleteMenu(int menuId);
}
