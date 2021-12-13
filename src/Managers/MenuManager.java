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

    public String getMenuByRestaurant(String username){
        try{
            return gson.toJson(manageMenus.getMenuByRestaurant(username));
        } catch (Exception e) {
            e.printStackTrace();
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

    public void deleteMenu(String menuId){
        try{
            manageMenus.deleteMenu(Integer.parseInt(menuId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
