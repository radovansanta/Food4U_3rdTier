package Managers;

import DatabaseAccess.ManageMenus;
import Models.Menu;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MenuManager
{
  ManageMenus manageMenus;
  Gson gson = new Gson();

  public void AddMenu(String menuAsJson)
  {
    System.out.println(menuAsJson);
    try
    {
      Menu menu = gson.fromJson(menuAsJson, Menu.class);
      manageMenus.addMenu(menu);
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }

  public String GetMenu(String menuId){
    try
    {
      return gson.toJson(manageMenus.getMenu(Integer.parseInt(menuId)));
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }

  public void updateMenu(String menuAsJson)
  {
    System.out.println(menuAsJson);
    try{
      Menu menu = gson.fromJson(menuAsJson, Menu.class);
      manageMenus.updateMenu(menu);
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    }
  }
}
