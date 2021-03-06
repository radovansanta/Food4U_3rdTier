package Managers;

import DatabaseAccess.ManageOrders;
import Models.Order;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class OrderManager {
    ManageOrders manageOrders;
    Gson gson;

    public OrderManager(ManageOrders manageOrders) {
        this.manageOrders = manageOrders;
        this.gson = new Gson();
    }

    public void addOrder(String orderAsJson) {
        try {
            Order order = gson.fromJson(orderAsJson, Order.class);
            manageOrders.addOrder(order);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getOrder(String orderId) {
        try {
            return gson.toJson(manageOrders.getOrder(Integer.parseInt(orderId)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getIncomingOrders(String restaurantUsername) {
        try {
            return gson.toJson(manageOrders.getIncomingOrders(restaurantUsername));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getAcceptedOrders(String restaurantUsername) {
        try {
            return gson.toJson(manageOrders.getAcceptedOrders(restaurantUsername));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getPreviousOrders(String customerUsername) {
        try {
            return gson.toJson(manageOrders.getPreviousOrders(customerUsername));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getReadyForPickUpOrders() {
        try {
            return gson.toJson(manageOrders.getReadyForPickUpOrders());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateOrder(String orderAsJson) {
        try {
            Order order = gson.fromJson(orderAsJson, Order.class);
            manageOrders.updateOrder(order);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

}
