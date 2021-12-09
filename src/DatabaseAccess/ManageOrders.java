package DatabaseAccess;

import Models.Order;

import java.util.ArrayList;

public interface ManageOrders {
    void addOrder(Order order);
    ArrayList<Order> getIncomingOrders(String restaurantUsername);
    ArrayList<Order> getAcceptedOrders(String restaurantUsername);
    ArrayList<Order> getPreviousOrders(String customerUsername);
    void updateOrder(Order order);
}
