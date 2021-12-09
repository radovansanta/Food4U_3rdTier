package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Menu;
import Models.Order;
import com.google.gson.Gson;

public class OrderManager
{
  Food4UDAO food4UDAO = Food4UDAO.getInstance();
  Gson gson = new Gson();

  public void addOrder(String orderAsJson)
  {
    try
    {
      Order order = gson.fromJson(orderAsJson, Order.class);
      food4UDAO.addOrder(order);
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
      return null;
      //return gson.toJson(food4UDAO.getIncomingOrders(restaurantUsername));
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

}
