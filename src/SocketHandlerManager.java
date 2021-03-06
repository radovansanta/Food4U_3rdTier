import Managers.*;
import Models.Request;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class SocketHandlerManager implements Runnable {
    private Socket socket;
    private RestaurantManager restaurantManager;
    private MenuManager menuManager;
    private CategoryManager categoryManager;
    private ItemManager itemManager;
    private CustomerManager customerManager;
    private OrderManager orderManager;
    private DriverManager driverManager;
    private DeliveryOptionsManager deliveryOptionsManager;

    private OutputStream outToClient;
    private InputStream inFromClient;
    private String message;

    public SocketHandlerManager(Socket socket, ManagerFactory managerFactory) {
        this.socket = socket;
        this.restaurantManager = managerFactory.getRestaurantManager();
        this.menuManager = managerFactory.getMenuManager();
        this.categoryManager = managerFactory.getCategoryManager();
        this.itemManager = managerFactory.getItemManager();
        this.customerManager = managerFactory.getCustomerManager();
        this.orderManager = managerFactory.getOrderManager();
        this.driverManager = managerFactory.getDriverManager();
        this.deliveryOptionsManager = managerFactory.getDeliveryOptionsManager();

    }

    @Override
    public void run() {
        try {
            outToClient = this.socket.getOutputStream();
            inFromClient = this.socket.getInputStream();

            byte[] lenbytes = new byte[1024 * 4];
            int read = inFromClient.read(lenbytes, 0, lenbytes.length);
            message = new String(lenbytes, 0, read);
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("MESSAGE IS: " + message);
        Request request = new Gson().fromJson(message, Request.class);
        System.out.println(request.getContext());
        System.out.println(request.getType());

        // *****RESTAURANT stuffs*****
        // Add Restaurant
        if (request.getType().equals("AddRestaurant")) {
            System.out.println("I got a request to add Restaurant" + request.getContext());
            try {
                restaurantManager.addRestaurant(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Get Restaurant
        if (request.getType().equals("GetRestaurant")) {
            System.out.println("I got a request to get Restaurant" + request.getContext());
            String response = restaurantManager.getRestaurant(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Validate Restaurant
        if (request.getType().equals("ValidateRestaurant")) {
            System.out.println("I got a request to validate Restaurant" + request.getContext());
            String response = restaurantManager.getRestaurant(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Update Restaurant
        if (request.getType().equals("UpdateRestaurant")) {
            System.out.println("I got a request to update a Restaurant" + request.getContext());
            try {
                restaurantManager.updateRestaurant(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // TODO: 12.12.2021 what are we sending back here to tier2????
        // Delete Restaurant
        if (request.getType().equals("DeleteRestaurant")) {
            System.out.println("I got a request to remove a Restaurant" + request.getContext());
            try {
                String response = restaurantManager.getRestaurant(request.getContext());
                restaurantManager.deleteRestaurant(request.getContext());
                byte[] responseAsBytes = response.getBytes();
                try {
                    outToClient.write(responseAsBytes, 0, responseAsBytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Get Restaurants
        if (request.getType().equals("GetRestaurants")) {
            System.out.println("I got a request to get all Restaurants");
            String response = restaurantManager.getRestaurants();
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // ****DELIVERY OPTION stuffs****
        // Add Delivery Option
        if (request.getType().equals("AddDeliveryOption")) {
            System.out.println("I got a request to add Delivery option" + request.getContext());

            try {
                deliveryOptionsManager.addDeliveryOption(request.getContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Get Delivery Options by restaurant username
        if(request.getType().equals("GetDeliveryOptionsByUsername")){
            System.out.println("I got a request to get delivery options by restaurant username" + request.getContext());
            String response = deliveryOptionsManager.getDeliveryOptionsByUsername(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try{
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Get Delivery Option
        if(request.getType().equals("GetDeliveryOption")){
            System.out.println("I got a request to get delivery option" + request.getContext());
            String response = deliveryOptionsManager.getDeliveryOption(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try{
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Update Delivery Option
        if (request.getType().equals("UpdateDeliveryOption")){
            System.out.println("I got a request to update Delivery option" + request.getContext());

            try {
                deliveryOptionsManager.updateDeliveryOption(request.getContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Delete Delivery Option
        if (request.getType().equals("DeleteDeliveryOption")) {
            System.out.println("I got a request to delete Delivery option" + request.getContext());

            try {
                deliveryOptionsManager.deleteDeliveryOption(request.getContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // *****MENU stuffs*****
        // Add Menu
        if (request.getType().equals("AddMenu")) {
            System.out.println("I got a request to add Menu" + request.getContext());

            try {
                menuManager.addMenu(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Get Menu
        if (request.getType().equals("GetMenu")) {
            System.out.println("I got a request to get Menu" + request.getContext());
            String response = menuManager.getMenu(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Get Menu by restaurant
        if (request.getType().equals("GetMenuByRestaurant")) {
            System.out.println("I got a request to get Menu by restaurant" + request.getContext());
            String response = menuManager.getMenuByRestaurant(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Update Menu
        if (request.getType().equals("UpdateMenu")) {
            System.out.println("I got a request to update Menu" + request.getContext());

            try {
                menuManager.updateMenu(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Delete Menu
        if (request.getType().equals("DeleteMenu")) {
            System.out.println("I got a request to delete Menu" + request.getContext());

            try {
                menuManager.deleteMenu(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        // *****Category stuffs*****
        // Add Category
        if (request.getType().equals("AddCategory")) {
            System.out.println("I got a request to add Category" + request.getContext());

            try {
                categoryManager.addCategory(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Get Category
        if (request.getType().equals("GetCategory")) {
            System.out.println("I got a request to get Category" + request.getContext());
            String response = categoryManager.getCategory(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Get Categories
        if (request.getType().equals("GetCategories")) {
            System.out.println("I got a request to get Categories" + request.getContext());
            String response = categoryManager.getCategories(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Update Category
        if (request.getType().equals("UpdateCategory")) {
            System.out.println("I got a request to update Category" + request.getContext());

            try {
                categoryManager.updateCategory(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        // Delete Category
        if (request.getType().equals("DeleteCategory")) {
            System.out.println("I got a request to delete Category" + request.getContext());

            try {
                categoryManager.deleteCategory(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        // *****Item stuffs*****
        // Add Item
        if (request.getType().equals("AddItem")) {
            System.out.println("I got a request to add Item" + request.getContext());

            try {
                itemManager.addItem(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Get Items
        if (request.getType().equals("GetItems")) {
            System.out.println("I got a request to get Items" + request.getContext());
            String response = itemManager.getItems(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Get Item
        if (request.getType().equals("GetItem")) {
            System.out.println("I got a request to get Item" + request.getContext());
            String response = itemManager.getItem(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // Update Item
        if (request.getType().equals("UpdateItem")) {
            System.out.println("I got a request to update Item" + request.getContext());

            try {
                itemManager.updateItem(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Order Item
        if(request.getType().equals("OrderItems")){
            System.out.println("I got a request to order items" + request.getContext());

            try{
                itemManager.orderItems(request.getContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //GetOrderedItems
        if(request.getType().equals("GetOrderedItems")){
            System.out.println("I got a request to get ordered items" + request.getContext());

            try{
                String response = itemManager.getItemsOrdered(request.getContext());
                byte[] responseAsBytes = response.getBytes();
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Delete Item
        if (request.getType().equals("DeleteItem")) {
            System.out.println("I got a request to delete Item" + request.getContext());
        /*
        try
        {
          //TODO Missing GetItem Api - noticed 9.12 01:19
          String response = itemManager.getItem(request.getContext());
          itemManager.deleteItem(request.getContext());
          byte[] responseAsBytes = response.getBytes();
          try
          {
            outToClient.write(responseAsBytes, 0, responseAsBytes.length);
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
         */
        }


        // *****CUSTOMER stuffs*****
        // Add Customer
        if (request.getType().equals("AddCustomer")) {
            System.out.println("I got a request to add Customer" + request.getContext());
            try {
                customerManager.addCustomer(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Get Customer
        if (request.getType().equals("GetCustomer")) {
            System.out.println("I got a request to get Customer" + request.getContext());
            String response = customerManager.getCustomer(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Validate Customer
        if (request.getType().equals("ValidateCustomer")) {
            System.out.println("I got a request to validate Customer" + request.getContext());
            String response = customerManager.getCustomer(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Update Customer
        if (request.getType().equals("UpdateCustomer")) {
            System.out.println("I got a request to update Customer" + request.getContext());

            try {
                customerManager.updateCustomer(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // TODO: 12.12.2021  what are we sending back here to tier2????
        // Delete Customer
        if (request.getType().equals("DeleteCustomer")) {
            System.out.println("I got a request to delete Customer" + request.getContext());
            try {
                String response = customerManager.getCustomer(request.getContext());
                customerManager.deleteCustomer(request.getContext());
                byte[] responseAsBytes = response.getBytes();
                try {
                    outToClient.write(responseAsBytes, 0, responseAsBytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        // *****ORDER stuff*****
        // Add order
        if (request.getType().equals("AddOrder")) {
            System.out.println("I got a request to add Order" + request.getContext());
            try {
                orderManager.addOrder(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //Get order
        if (request.getType().equals("GetOrder")) {
            System.out.println("I got a request to get Order" + request.getContext());
            String response = orderManager.getOrder(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Update order
        if (request.getType().equals("UpdateOrder")) {
            System.out.println("I got a request to update Order" + request.getContext());
            try {
                orderManager.updateOrder(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //Get incoming orders
        if (request.getType().equals("GetIncomingOrders")) {
            System.out.println("I got a request to get incoming orders" + request.getContext());
            try {
                String response = orderManager.getIncomingOrders(request.getContext());
                byte[] responseAsBytes = response.getBytes();
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //Get accepted orders
        if (request.getType().equals("GetAcceptedOrders")) {
            System.out.println("I got a request to get accepted orders" + request.getContext());
            try {
                String response = orderManager.getAcceptedOrders(request.getContext());
                byte[] responseAsBytes = response.getBytes();
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Get previous orders
        if (request.getType().equals("GetPreviousOrders")) {
            System.out.println("I got a request to get previous orders" + request.getContext());
            try {
                String response = orderManager.getPreviousOrders(request.getContext());
                byte[] responseAsBytes = response.getBytes();
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Get ready for pick up orders
        if (request.getType().equals("GetReadyForPickUpOrders")) {
            System.out.println("I got a request to get ready for pick up orders" + request.getContext());
            try {
                String response = orderManager.getReadyForPickUpOrders();
                byte[] responseAsBytes = response.getBytes();
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        // *****DRIVER stuffs*****
        // Add Driver
        if (request.getType().equals("AddDriver")) {
            System.out.println("I got a request to add Driver" + request.getContext());
            try {
                driverManager.addDriver(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Get Driver
        if (request.getType().equals("GetDriver")) {
            System.out.println("I got a request to get Driver" + request.getContext());
            String response = driverManager.getDriver(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Validate Driver
        if (request.getType().equals("ValidateDriver")) {
            System.out.println("I got a request to validate Driver" + request.getContext());
            String response = driverManager.getDriver(request.getContext());
            byte[] responseAsBytes = response.getBytes();
            try {
                outToClient.write(responseAsBytes, 0, responseAsBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Update Driver
        if (request.getType().equals("UpdateDriver")) {
            System.out.println("I got a request to update Driver" + request.getContext());

            try {
                driverManager.updateDriver(request.getContext());
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        // TODO: 12.12.2021 what are we sending back here to tier2????
        // Delete Driver
        if (request.getType().equals("DeleteDriver")) {
            System.out.println("I got a request to delete Driver" + request.getContext());
            try {
                String response = driverManager.getDriver(request.getContext());
                driverManager.deleteDriver(request.getContext());
                byte[] responseAsBytes = response.getBytes();
                try {
                    outToClient.write(responseAsBytes, 0, responseAsBytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        try
        {
            socket.close();
            outToClient.close();
            inFromClient.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}




