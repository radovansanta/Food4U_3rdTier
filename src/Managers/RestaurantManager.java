package Managers;

import DatabaseAccess.ManageRestaurants;
import Models.Restaurant;
import com.google.gson.Gson;

public class RestaurantManager
{
  ManageRestaurants manageRestaurants;
  Gson gson = new Gson();

  public void AddRestaurant(String restaurantAsJson){
    System.out.println(restaurantAsJson);
    try
    {
      Restaurant restaurant = gson.fromJson(restaurantAsJson, Restaurant.class);
      manageRestaurants.addRestaurant(restaurant);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }

  public String GetRestaurant(String username){
    try
    {
      return gson.toJson(manageRestaurants.getRestaurant(username));
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }

  public String ValidateLogin(String username){
    try
    {
      return gson.toJson(manageRestaurants.getRestaurant(username));
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }

  public void UpdateRestaurant(String restaurantAsJson){
    try{
      Restaurant restaurant = gson.fromJson(restaurantAsJson, Restaurant.class);
      System.out.println("Restaurant object is: "+restaurant);
      manageRestaurants.updateRestaurant(restaurant);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
  public void RemoveRestaurant(String username){
    try
    {
      manageRestaurants.deleteRestaurant(username);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }

  public String GetRestaurants(){
    try
    {
      return gson.toJson(manageRestaurants.getRestaurants());
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }

  public void AcceptOrder(String orderId)
  {
    try
    {
      // gson.toJson(food4UDAO.acceptOrders());
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }

  public void DeclineOrder(String orderId)
  {
    try
    {
      // gson.toJson(food4UDAO.declineOrders());
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }
}
