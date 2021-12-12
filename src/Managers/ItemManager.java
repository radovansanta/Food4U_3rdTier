package Managers;

import DatabaseAccess.ManageItems;
import Models.Item;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ItemManager {
    ManageItems manageItems;
    Gson gson = new Gson();

    public void addItem(String itemAsJson)
    {
        System.out.println(itemAsJson);
        try{
            Item item = gson.fromJson(itemAsJson, Item.class);
            manageItems.addItem(item);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public String getItems(String categoryId){
        try{
            return gson.toJson(manageItems.getItemsByCategoryId(
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
            manageItems.updateItem(item);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(String itemId){
        try{
            manageItems.deleteItem(Integer.parseInt(itemId));
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public String getItem(String itemId){
        try{
            return gson.toJson(manageItems.getItemByItemId(
                    Integer.parseInt(itemId)));
        } catch (JsonSyntaxException e) {
            System.out.println(e);
            return null;
        }
    }
}
