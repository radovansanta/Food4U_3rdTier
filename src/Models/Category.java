package Models;

public class Category {
    private String name;
    private int menuId;

    public Category() {
        name = null;
        menuId = 0;
    }

    public Category(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public int getMenuId() {
        return menuId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", menuId=" + menuId +
                '}';
    }
}
