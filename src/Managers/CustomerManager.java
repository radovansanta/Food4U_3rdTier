package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Restaurant;
import com.google.gson.Gson;

public class CustomerManager
{
  Food4UDAO food4UDAO = Food4UDAO.getInstance();
  Gson gson = new Gson();

  public void AddCustomer(String customerAsJson)
  {
    System.out.println(customerAsJson);
    try
    {
      //Custome = gson.fromJson(restaurantAsJson, Restaurant.class);
      //food4UDAO.addRestaurant(restaurant);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
}
