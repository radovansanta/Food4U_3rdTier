package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Menu;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MenuManager
{
  Food4UDAO food4UDAO = Food4UDAO.getInstance();
  Gson gson = new Gson();

  public void AddMenu(String menuAsJson)
  {
    System.out.println(menuAsJson);
    try
    {
      Menu menu = gson.fromJson(menuAsJson, Menu.class);
      // TODO: 29.11.2021 fix it 
      //food4UDAO.addMenu(menu);
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
