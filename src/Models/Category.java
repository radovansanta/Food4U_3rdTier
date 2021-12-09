package Models;

public class Category {
    private int categoryId;
    private String name;
    private int menuId;

    public Category() {
        categoryId = 0;
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
        this.categoryId = categoryID;
    }

    public String getName() {
        return name;
    }

    public int getMenuId() {
        return menuId;
    }

    public int getCategoryID() {
        return categoryId;
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
