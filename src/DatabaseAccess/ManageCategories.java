package DatabaseAccess;

import Models.Category;
import Models.Item;
import Models.Menu;

import java.util.ArrayList;

public interface ManageCategories {
    void addCategory(Category category);
    Category getCategoryByCategoryName(String categoryName);
    void deleteCategory(String categoryName);
    void updateCategory(Category category);
    ArrayList<Category> getCategoriesByMenuID(int menuID);
}
