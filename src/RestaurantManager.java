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
}
