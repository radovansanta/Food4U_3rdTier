package DatabaseAccess;

import Models.Category;

import java.util.ArrayList;

public interface ManageCategories {
    void addCategory(Category category);
    Category getCategory(int categoryId);
    void deleteCategory(int categoryId);
    void updateCategory(Category category);
    ArrayList<Category> getCategoriesByMenuId(int menuId);
}
