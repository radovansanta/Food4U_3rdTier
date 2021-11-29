package DatabaseAccess;

import Models.DeliveryOption;
import Models.Menu;
import Models.Restaurant;
import Models.User;

public class TestDatabase4
{
    public static void main(String[] args) {
        Food4UDAO food4UDAO = Food4UDAO.getInstance();
        User user1 = new User("user", "password");
        DeliveryOption deliveryOption1 = new DeliveryOption(1,"takeaway", 0);
        DeliveryOption deliveryOption2 = new DeliveryOption(2,"delivery", 199);
        Restaurant restaurant1 = new Restaurant(1, "new_name", "new_address", "098754",
                "new_monday", "new_tuesday","new_wednesday",
                "new_thursday", "new_friday", "saturday",
                "new_sunday", "new_description", deliveryOption1, deliveryOption2);
        Menu menu = new Menu(2, "new_description");

        //add to database
        //food4UDAO.addUser(user1);
        //food4UDAO.addRestaurant(restaurant1);
        //food4UDAO.addMenu(menu, 2);

        //update
        //food4UDAO.updateRestaurant(restaurant1);
        //food4UDAO.updateDeliveryOption(deliveryOption1);
        //food4UDAO.updateDeliveryOption(deliveryOption2);
        food4UDAO.updateMenu(menu);

        //get from database
        //System.out.println(food4UDAO.getUser("user"));
        //System.out.println(food4UDAO.getRestaurant(1));
        //System.out.println(food4UDAO.getDeliveryOption(1));
        //System.out.println(food4UDAO.getDeliveryOption(2));

        //delete from database
        //food4UDAO.deleteRestaurant(1);
    }
}
