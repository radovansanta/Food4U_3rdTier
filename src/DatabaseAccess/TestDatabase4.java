package DatabaseAccess;

import Models.Restaurant;
import Models.User;

public class TestDatabase4
{
    public static void main(String[] args) {
        Food4UDAO food4UDAO = Food4UDAO.getInstance();

        System.out.println(food4UDAO.getUser("bianca.militaru"));

        Restaurant restaurant = new Restaurant(1, "name", "address",
                "phone_number", "opening_hours", "description");

        //food4UDAO.addRestaurant(restaurant);

        User user = new User("usernmae", "password");
        food4UDAO.addUser(user);
    }
}
