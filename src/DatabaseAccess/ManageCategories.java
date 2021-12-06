package DatabaseAccess;

import Models.Category;
import Models.Item;
import Models.Menu;

import java.util.ArrayList;

public interface ManageCategories {
    void addCategory(Category category);
    Category getCategory(String categoryName);
    void deleteCategory(String categoryName);
    void updateCategory(Category oldCategory, Category newCategory);
    ArrayList<Category> getCategoriesByMenuID(int menuID);
}
