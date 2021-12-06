package Models;

public class Category {
    private int categoryID;
    private String name;
    private int menuId;

    public Category() {
        categoryID = 0;
        name = null;
        menuId = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public int getMenuId() {
        return menuId;
    }

    public int getCategoryID() {
        return categoryID;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", name='" + name + '\'' +
                ", menuId=" + menuId +
                '}';
    }
}
