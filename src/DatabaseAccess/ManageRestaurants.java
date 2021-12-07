package DatabaseAccess;

import Models.Order;
import Models.Restaurant;

import java.util.ArrayList;

public interface ManageRestaurants
{
    void addRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(String username);
    void updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(String username);
    ArrayList<Restaurant> getRestaurants();
    void acceptOrder(Order order);
}
