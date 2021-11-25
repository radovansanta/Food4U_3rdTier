import DatabaseAccess.Food4UDAO;
import Models.Restaurant;
import Models.User;
import com.google.gson.Gson;

public class UserManager
{
  Food4UDAO food4UDAO = Food4UDAO.getInstance();
  Gson gson = new Gson();

  public String ValidateUser(String username){
    return gson.toJson(food4UDAO.getUser(username));
  }

  public void AddUser(String userAsJson){
    try
    {
      User user = gson.fromJson(userAsJson, User.class);
      food4UDAO.addUser(user);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
}
