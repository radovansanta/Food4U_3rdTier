package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Category;
import Models.Item;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ItemManager {
    Food4UDAO food4UDAO = Food4UDAO.getInstance();
    Gson gson = new Gson();
    Category category;

    public void addItem(String itemAsJson)
    {
        System.out.println(itemAsJson);
        try{
            Item item = gson.fromJson(itemAsJson, Item.class);
            food4UDAO.addItem(item, category.getName());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }
}
