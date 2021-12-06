package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Category;
import Models.Menu;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CategoryManager {
    Food4UDAO food4UDAO = Food4UDAO.getInstance();
    Gson gson = new Gson();

    public void addCategory(String categoryAsJson){
        System.out.println(categoryAsJson);
        try{
            Category category = gson.fromJson(categoryAsJson, Category.class);
            food4UDAO.addCategory(category);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(String categoryAsJson) {
        System.out.println(categoryAsJson);
        try {
            // TODO: 06.12.2021 this need to be modified to support two objects (oldCategory and newCategory)
            Category category = gson.fromJson(categoryAsJson, Category.class);
            //food4UDAO.updateCategory(category);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }
    public void deleteCategory(String categoryAsJson) {

    }

    public void RemoveCategory(String categoryName)
    {
        try
        {
            food4UDAO.deleteCategory(categoryName);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
