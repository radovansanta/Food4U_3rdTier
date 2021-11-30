package DatabaseAccess;

import Models.Category;
import Models.Menu;

public interface ManageCategories {
    void addCategory(Category category, int menuID);
    void updateCategory( Category category);
}
