package Managers;

import DatabaseAccess.ManageMenus;
import Models.Menu;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MenuManager {
    ManageMenus manageMenus;
    Gson gson;

    public MenuManager(ManageMenus manageMenus) {
        this.manageMenus = manageMenus;
        this.gson = new Gson();
    }

    public void addMenu(String menuAsJson) {
        System.out.println(menuAsJson);
        try {
            Menu menu = gson.fromJson(menuAsJson, Menu.class);
            manageMenus.addMenu(menu);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getMenu(String menuId) {
        try {
            return gson.toJson(manageMenus.getMenu(Integer.parseInt(menuId)));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void updateMenu(String menuAsJson) {
        System.out.println(menuAsJson);
        try {
            Menu menu = gson.fromJson(menuAsJson, Menu.class);
            manageMenus.updateMenu(menu);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    // TODO: 12.12.2021 we should have 'deleteMenu'
}
