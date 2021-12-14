package DatabaseAccess;

import Managers.*;
import Models.*;

import java.util.ArrayList;

public class TestDatabase4
{
    public static void main(String[] args) {

        Restaurant restaurant1 = new Restaurant("restaurant1", "pass1", "name1",
                "address1", "1", "monday1", "tuesday1", "wednesday1",
                "thursday1", "friday1", "closed", "closed","description1",
                true);
        Restaurant restaurant2 = new Restaurant("restaurant2", "pass2", "name2",
                "address2", "2", "monday2", "tuesday2", "wednesday2",
                "thursday2", "friday2", "saturday2", "sunday2","description2",
                false);

        ManageRestaurantsDAO manageRestaurantsDAO = new ManageRestaurantsDAO();
        //manageRestaurantsDAO.addRestaurant(restaurant1);
        //manageRestaurantsDAO.addRestaurant(restaurant2);
        //System.out.println(manageRestaurantsDAO.getRestaurant("restaurant1"));
        //System.out.println(manageRestaurantsDAO.getRestaurants());
        //manageRestaurantsDAO.updateRestaurant(restaurant1);
        //manageRestaurantsDAO.deleteRestaurant("restaurant2");

        Menu menu1 = new Menu();
        menu1.setDescription("old menu for this restaurant");
        menu1.setUsername("restaurant1");

        ManageMenusDAO manageMenusDAO = new ManageMenusDAO();
        //manageMenusDAO.addMenu(menu1);
        //System.out.println(manageMenusDAO.getMenu(1));
        //menu1.setMenuID(1);
        //manageMenusDAO.updateMenu(menu1);
        //manageMenusDAO.deleteMenu(2);
        //System.out.println(manageMenusDAO.getMenuByRestaurant("restaurant1"));

        Category category1 = new Category();
        category1.setName("old starters");
        category1.setMenuId(1);
        category1.setCategoryId(1);

        ManageCategoriesDAO manageCategoriesDAO = new ManageCategoriesDAO();
        //manageCategoriesDAO.addCategory(category1);
        //System.out.println(manageCategoriesDAO.getCategory(1));
        //manageCategoriesDAO.updateCategory(category1);
        //System.out.println(manageCategoriesDAO.getCategoriesByMenuId(1));
        //manageCategoriesDAO.deleteCategory(1);

        Item item1 = new Item();
        item1.setDescription("item2");
        item1.setPrice(200);
        item1.setName("old name");
        item1.setCategoryId(1);
        item1.setDiscount(10);
        item1.setItemID(1);

        Item item2 = new Item();
        item2.setDescription("item3");
        item2.setPrice(200);
        item2.setName("difoeu");
        item2.setCategoryId(1);
        item2.setDiscount(0);
        item2.setItemID(2);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        ManageItemsDAO manageItemsDAO = new ManageItemsDAO();
        //manageItemsDAO.addItem(item1);
        //manageItemsDAO.addItem(item2);
        //System.out.println(manageItemsDAO.getItemByItemId(2));
        //System.out.println(manageItemsDAO.getItemsByCategoryId(2));
        //manageItemsDAO.updateItem(item1);
        //manageItemsDAO.deleteItem(3);
        //manageItemsDAO.orderItems(items, 2);
        //System.out.println(manageItemsDAO.getItemsOrdered(2));

        DeliveryOption deliveryOption1 = new DeliveryOption();
        deliveryOption1.setDeliveryID(2);
        deliveryOption1.setUsername("restaurant1");
        deliveryOption1.setDeliveryName("takeaway");
        deliveryOption1.setPrice(200);

        ManageDeliveryOptionsDAO manageDeliveryOptionsDAO = new ManageDeliveryOptionsDAO();
        //manageDeliveryOptionsDAO.addDeliveryOption(deliveryOption1);
        //System.out.println(manageDeliveryOptionsDAO.getDeliveryOption(1));
        //System.out.println(manageDeliveryOptionsDAO.getDeliveryOptionsByUsername("restaurant1"));
        //manageDeliveryOptionsDAO.updateDeliveryOption(deliveryOption1);
        //manageDeliveryOptionsDAO.deleteDeliveryOption(1);

        Customer customer1 = new Customer();
        customer1.setUsername("customer1");
        customer1.setPassword("pass");
        customer1.setAddress("new address");
        customer1.setPhoneNumber("3039");
        customer1.setFirstName("firstname1");
        customer1.setLastName("lastname1");
        customer1.setEmail("email");

        ManageCustomersDAO manageCustomersDAO = new ManageCustomersDAO();
        //manageCustomersDAO.addCustomer(customer1);
        //manageCustomersDAO.updateCustomer(customer1);
        //System.out.println(manageCustomersDAO.getCustomer("customer1"));
        //manageCustomersDAO.deleteCustomer("customer2");

        Driver driver1 = new Driver();
        driver1.setAddress("address");
        driver1.setLicenseNumber("license");
        driver1.setEmail("email");
        driver1.setPhoneNumber("39489");
        driver1.setPassword("pass");
        driver1.setLastName("lastname1");
        driver1.setFirstName("first name1");
        driver1.setUsername("driver1");

        ManageDriversDAO manageDriversDAO = new ManageDriversDAO();
        //manageDriversDAO.addDriver(driver1);
        //manageDriversDAO.updateDriver(driver1);
        //System.out.println(manageDriversDAO.getDriver("driver1"));
        //manageDriversDAO.deleteDriver("driver2");

        Order order1 = new Order();
        order1.setDate("25.07.2009");
        order1.setDeliveryID(1);
        order1.setPrice(200);
        order1.setAddress("add");
        order1.setRestaurantUsername("restaurant1");
        order1.setDriverUsername("driver1");
        order1.setCustomerUsername("customer1");
        order1.setStatus("driver pick up");
        order1.setOrderID(1);
        Order order2 = new Order();
        order2.setDate("25.07.2009");
        order2.setDeliveryID(1);
        order2.setPrice(200);
        order2.setAddress("add");
        order2.setRestaurantUsername("restaurant1");
        order2.setDriverUsername("driver1");
        order2.setCustomerUsername("customer1");
        order2.setStatus("Incoming");
        order2.setOrderID(2);
        Order order3 = new Order();
        order3.setDate("25.07.2009");
        order3.setDeliveryID(1);
        order3.setPrice(200);
        order3.setAddress("add");
        order3.setRestaurantUsername("restaurant1");
        order3.setDriverUsername("driver1");
        order3.setCustomerUsername("customer1");
        order3.setStatus("Accepted");
        order3.setOrderID(3);
        Order order4 = new Order();
        order4.setDate("25.07.2009");
        order4.setDeliveryID(1);
        order4.setPrice(200);
        order4.setAddress("add");
        order4.setRestaurantUsername("restaurant1");
        order4.setDriverUsername("driver1");
        order4.setCustomerUsername("customer1");
        order4.setStatus("Completed");
        order4.setOrderID(4);

        ManageOrdersDAO manageOrdersDAO = new ManageOrdersDAO();
        //manageOrdersDAO.addOrder(order1);
        //manageOrdersDAO.addOrder(order2);
        //manageOrdersDAO.addOrder(order3);
        //manageOrdersDAO.addOrder(order3);
        //System.out.println(manageOrdersDAO.getOrder(2));
        //manageOrdersDAO.updateOrder(order1);
        //manageOrdersDAO.updateOrder(order2);
        //manageOrdersDAO.updateOrder(order3);
        //manageOrdersDAO.updateOrder(order4);
        //System.out.println(manageOrdersDAO.getIncomingOrders("restaurant1"));
        //System.out.println(manageOrdersDAO.getReadyForPickUpOrders());
        //System.out.println(manageOrdersDAO.getPreviousOrders("customer1"));
    }
}
