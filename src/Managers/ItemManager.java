package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Category;
import Models.Item;
import Models.Menu;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ItemManager {
    Food4UDAO food4UDAO = Food4UDAO.getInstance();
    Gson gson = new Gson();

    public void addItem(String itemAsJson)
    {
        System.out.println(itemAsJson);
        try{
            Item item = gson.fromJson(itemAsJson, Item.class);
            food4UDAO.addItem(item);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public String getItems(String categoryId){
        try{
            return gson.toJson(food4UDAO.getItemsByCategoryId(
                Integer.parseInt(categoryId)));
        } catch (JsonSyntaxException e) {
            System.out.println(e);
            return null;
        }
    }

    public void updateItem(String itemAsJson)
    {
        System.out.println(itemAsJson);
        try{
            Item item = gson.fromJson(itemAsJson, Item.class);
            food4UDAO.updateItem(item);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(String itemId){
        try{
            food4UDAO.deleteItem(Integer.parseInt(itemId));
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }
}
