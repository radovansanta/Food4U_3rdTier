package DatabaseAccess;

import Models.Order;

import java.util.ArrayList;

public interface ManageOrders {
    void addOrder(Order order);
    ArrayList<Order> getIncomingOrders(String restaurantUsername);
}
