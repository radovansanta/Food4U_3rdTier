package Models;

public class Menu {
    private int menuID;
    private String description;
    private String username;

    public Menu() {
        menuID = 0;
        description = null;
        username = null;
    }

    public Menu(int menuID, String description, String username) {
        this.description = description;
        this.menuID = menuID;
        this.username = username;
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

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsername(String username) {
        this.username = username;
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
