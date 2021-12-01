package Managers;

import DatabaseAccess.Food4UDAO;
import Models.User;
import com.google.gson.Gson;

public class UserManager
{
  Food4UDAO food4UDAO = Food4UDAO.getInstance();
  Gson gson = new Gson();

  public String ValidateUser(String username){
    return gson.toJson(food4UDAO.getRestaurant(username));
  }
}
