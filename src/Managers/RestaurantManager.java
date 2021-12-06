package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Restaurant;
import com.google.gson.Gson;

public class RestaurantManager
{
  Food4UDAO food4UDAO = Food4UDAO.getInstance();
  Gson gson = new Gson();

  public void AddRestaurant(String restaurantAsJson){
    System.out.println(restaurantAsJson);
    try
    {
      Restaurant restaurant = gson.fromJson(restaurantAsJson, Restaurant.class);
      food4UDAO.addRestaurant(restaurant);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }

  public String GetRestaurant(String username){
    try
    {
      return gson.toJson(food4UDAO.getRestaurant(username));
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }

  public String ValidateLogin(String username){
    try
    {
      return gson.toJson(food4UDAO.getRestaurant(username));
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
      food4UDAO.updateRestaurant(restaurant);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
  public void RemoveRestaurant(String username){
    try
    {
      food4UDAO.deleteRestaurant(username);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }

  public String GetRestaurants(){
    try
    {
      return gson.toJson(food4UDAO.getRestaurants());
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }
}
