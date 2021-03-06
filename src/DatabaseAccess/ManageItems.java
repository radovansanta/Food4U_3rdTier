package DatabaseAccess;


import Models.Item;
import Models.Order;

import java.util.ArrayList;

public interface ManageItems {
    void addItem(Item item);
    Item getItemByItemId(int itemId);
    void updateItem(Item item);
    void deleteItem(int itemId);
    ArrayList<Item> getItemsByCategoryId(int categoryId);
    void orderItems(Order order);
    ArrayList<Item> getItemsOrdered(int orderId);
}
