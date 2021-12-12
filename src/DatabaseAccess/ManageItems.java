package DatabaseAccess;


import Models.Item;

import java.util.ArrayList;

public interface ManageItems {
    void addItem(Item item);
    Item getItemByItemId(int itemId);
    void updateItem(Item item);
    void deleteItem(int itemId);
    ArrayList<Item> getItemsByCategoryId(int categoryId);

}
