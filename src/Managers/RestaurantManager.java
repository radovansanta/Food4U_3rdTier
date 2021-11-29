package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Restaurant;
import com.google.gson.Gson;

public class RestaurantManager {
    Food4UDAO food4UDAO = Food4UDAO.getInstance();
    Gson gson = new Gson();

    public void AddRestaurant(String restaurantAsJson) {
        System.out.println(restaurantAsJson);
        try {
            Restaurant restaurant = gson.fromJson(restaurantAsJson, Restaurant.class);
            food4UDAO.addRestaurant(restaurant);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void UpdateRestaurant(String restaurantAsJson) {
        try {
            Restaurant restaurant = gson.fromJson(restaurantAsJson, Restaurant.class);
            food4UDAO.updateRestaurant(restaurant);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void RemoveRestaurant(String restaurantAsJson) {
        System.out.println(restaurantAsJson);
        try {
            //MISSING FUNCTION;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
