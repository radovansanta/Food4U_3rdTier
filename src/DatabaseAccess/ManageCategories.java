package DatabaseAccess;

import Models.Category;

import java.util.ArrayList;

public interface ManageCategories {
    void addCategory(Category category);
    Category getCategoryByCategoryName(String categoryName);
    void deleteCategory(String categoryName);
    ArrayList<Category> getCategoriesByMenuID(int menuID);
}
