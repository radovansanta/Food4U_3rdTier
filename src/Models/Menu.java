package Models;

import java.util.ArrayList;

public class Menu {
    private int menuID;
    private String description;
    private String username;
    private ArrayList<Category> categories;

    public Menu() {
        menuID = 0;
        description = null;
        username = null;
        categories = new ArrayList<>();
    }

    public Menu(int menuID, String description, String username) {
        this.description = description;
        this.menuID = menuID;
        this.username = username;
        this.categories = new ArrayList<>();
    }

    public int getMenuID() {
        return menuID;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuID=" + menuID +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
