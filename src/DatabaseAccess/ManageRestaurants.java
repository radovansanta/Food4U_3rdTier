package DatabaseAccess;

import Models.Restaurant;

public interface ManageRestaurants
{
    void addRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(String username);
    void updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(String username);
}
