package Managers;

import DatabaseAccess.ManageCategories;
import Models.Category;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CategoryManager {
    ManageCategories manageCategories;
    Gson gson;

    public CategoryManager(ManageCategories manageCategories) {
        this.manageCategories = manageCategories;
        this.gson = new Gson();
    }

    public void addCategory(String categoryAsJson) {
        System.out.println(categoryAsJson);
        try {
            Category category = gson.fromJson(categoryAsJson, Category.class);
            manageCategories.addCategory(category);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public String getCategory(String categoryId) {
        try {
            return gson.toJson(manageCategories.getCategory(
                    Integer.parseInt(categoryId)));
        } catch (JsonSyntaxException e) {
            System.out.println(e);
            return null;
        }
    }

    public String getCategories(String menuId) {
        try {
            return gson.toJson(manageCategories.getCategoriesByMenuId(
                    Integer.parseInt(menuId)));
        } catch (JsonSyntaxException e) {
            System.out.println(e);
            return null;
        }
    }

    public void updateCategory(String categoryAsJson) {
        System.out.println(categoryAsJson);
        try {
            Category category = gson.fromJson(categoryAsJson, Category.class);
            manageCategories.updateCategory(category);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(String categoryId) {
        try {
            manageCategories.deleteCategory(Integer.parseInt(categoryId));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
