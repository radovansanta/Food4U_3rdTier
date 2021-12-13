package Managers;

import DatabaseAccess.*;

public class ManagerFactory {

    private static ManagerFactory instance;
    private CategoryManager categoryManager;
    private CustomerManager customerManager;
    private DeliveryOptionsManager deliveryOptionsManager;
    private DriverManager driverManager;
    private ItemManager itemManager;
    private MenuManager menuManager;
    private OrderManager orderManager;
    private RestaurantManager restaurantManager;

    private ManagerFactory() {
    }

    public static ManagerFactory getInstance() {
        if (instance == null)
            instance = new ManagerFactory();
        return instance;
    }

    public CategoryManager getCategoryManager() {
        if (categoryManager == null)
            categoryManager = new CategoryManager(new ManageCategoriesDAO());
        return categoryManager;
    }

    public CustomerManager getCustomerManager() {
        if (customerManager == null)
            customerManager = new CustomerManager(new ManageCustomersDAO());
        return customerManager;
    }

    public DeliveryOptionsManager getDeliveryOptionsManager() {
        if (deliveryOptionsManager == null)
            deliveryOptionsManager = new DeliveryOptionsManager(new ManageDeliveryOptionsDAO());
        return deliveryOptionsManager;
    }

    public DriverManager getDriverManager() {
        if (driverManager == null)
            driverManager = new DriverManager(new ManageDriversDAO());
        return driverManager;
    }

    public ItemManager getItemManager() {
        if (itemManager == null)
            itemManager = new ItemManager(new ManageItemsDAO());
        return itemManager;
    }

    public MenuManager getMenuManager() {
        if (menuManager == null)
            menuManager = new MenuManager(new ManageMenusDAO());
        return menuManager;
    }

    public OrderManager getOrderManager() {
        if (orderManager == null)
            orderManager = new OrderManager(new ManageOrdersDAO());
        return orderManager;
    }

    public RestaurantManager getRestaurantManager() {
        if (restaurantManager == null)
            restaurantManager = new RestaurantManager(new ManageRestaurantsDAO());
        return restaurantManager;
    }
}
