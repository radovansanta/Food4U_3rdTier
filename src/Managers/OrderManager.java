package Managers;

import DatabaseAccess.ManageOrders;
import Models.Order;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class OrderManager
{
  ManageOrders manageOrders;
  Gson gson = new Gson();

  public void addOrder(String orderAsJson)
  {
    try
    {
      Order order = gson.fromJson(orderAsJson, Order.class);
      manageOrders.addOrder(order);
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }
    //TODO getIncomingOrders
  public String getIncomingOrders(String restaurantUsername)
  {
    try
    {
      return gson.toJson(manageOrders.getIncomingOrders(restaurantUsername));
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }
    //TODO getAcceptedOrders
  public String getAcceptedOrders(String restaurantUsername)
  {
    try
    {
      return null;
      //return gson.toJson(food4UDAO.getAcceptedOrders(restaurantUsername));
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }

  //TODO getPreviousOrders
  public String getPreviousOrders(String customerUsername)
  {
    try
    {
      return null;
      //return gson.toJson(food4UDAO.getPreviousOrders(restaurantUsername));
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }

  public void updateOrder(String orderAsJson){
    try{
      Order order = gson.fromJson(orderAsJson, Order.class);
      manageOrders.updateOrder(order);
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    }
  }

}
