package DatabaseAccess;

import Models.Restaurant;

public interface ManageRestaurants
{
    void addRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(int restaurantID);
    void updateRestaurant(Restaurant restaurant);
    Restaurant getRestaurantByName(String name);
    void deleteRestaurant(int restaurantID);
}
