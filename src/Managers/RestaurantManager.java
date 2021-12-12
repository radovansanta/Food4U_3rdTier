package Managers;

import DatabaseAccess.ManageRestaurants;
import Models.Restaurant;
import com.google.gson.Gson;

public class RestaurantManager {
  ManageRestaurants manageRestaurants;
  Gson gson = new Gson();

  public void addRestaurant(String restaurantAsJson) {
    System.out.println(restaurantAsJson);
    try {
      Restaurant restaurant = gson.fromJson(restaurantAsJson, Restaurant.class);
      manageRestaurants.addRestaurant(restaurant);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public String getRestaurant(String username) {
    try {
      return gson.toJson(manageRestaurants.getRestaurant(username));
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public void updateRestaurant(String restaurantAsJson) {
    try {
      Restaurant restaurant = gson.fromJson(restaurantAsJson, Restaurant.class);
      System.out.println("Restaurant object is: " + restaurant);
      manageRestaurants.updateRestaurant(restaurant);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void deleteRestaurant(String username) {
    try {
      manageRestaurants.deleteRestaurant(username);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public String getRestaurants() {
    try {
      return gson.toJson(manageRestaurants.getRestaurants());
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}