package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Menu;
import Models.Restaurant;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MenuManager
{
  Food4UDAO food4UDAO = Food4UDAO.getInstance();
  Gson gson = new Gson();
  Restaurant restaurant;

  public void AddMenu(String menuAsJson)
  {
    System.out.println(menuAsJson);
    try
    {
      Menu menu = gson.fromJson(menuAsJson, Menu.class);
      food4UDAO.addMenu(menu, restaurant.getRestaurantID());
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }

  public void updateMenu(String menuAsJson)
  {
    System.out.println(menuAsJson);
    try{
      Menu menu = gson.fromJson(menuAsJson, Menu.class);
      food4UDAO.updateMenu(menu);
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    }
  }
}
