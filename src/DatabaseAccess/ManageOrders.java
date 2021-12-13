package DatabaseAccess;

import Models.Order;

import java.util.ArrayList;

public interface ManageOrders {
    void addOrder(Order order);
    Order getOrder(int orderId);
    ArrayList<Order> getIncomingOrders(String restaurantUsername);
    ArrayList<Order> getAcceptedOrders(String restaurantUsername);
    ArrayList<Order> getPreviousOrders(String customerUsername);
    ArrayList<Order> getReadyForPickUpOrders();
    void updateOrder(Order order);
}
