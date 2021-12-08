package DatabaseAccess;


import Models.Item;

import java.util.ArrayList;

public interface ManageItems {
    void addItem(Item item);
    Item getItemByItemID(int itemID);
    void updateItem(Item item);
    void deleteItem(int itemID);
    ArrayList<Item> getItemsByCategoryId(int categoryId);

}
