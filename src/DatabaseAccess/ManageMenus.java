package DatabaseAccess;

import Models.Menu;

public interface ManageMenus {
    void addMenu(Menu menu, int restaurantID);
    void updateMenu(Menu menu);
}
