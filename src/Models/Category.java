package Models;

import java.util.ArrayList;

public class Category {
    private int categoryId;
    private String name;
    private int menuId;
    private ArrayList<Item> items;

    public Category() {
        categoryId = 0;
        name = null;
        menuId = 0;
        items = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setCategoryId(int categoryID) {
        this.categoryId = categoryID;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public int getMenuId() {
        return menuId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", menuId=" + menuId +
                '}';
    }
}
