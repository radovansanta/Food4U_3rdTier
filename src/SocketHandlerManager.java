import Managers.*;
import Managers.MenuManager;
import Managers.RestaurantManager;
import Models.Order;
import Models.Request;
import Models.Restaurant;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

  public class SocketHandlerManager implements Runnable
  {

    private Socket socket;
    private RestaurantManager restaurantManager;
    private MenuManager menuManager;
    private CategoryManager categoryManager;
    private ItemManager itemManager;
    private CustomerManager customerManager;
    private OrderManager orderManager;

    private OutputStream outToClient;
    private InputStream inFromClient;
    private String message;

    public SocketHandlerManager(Socket socket, RestaurantManager restaurantManager, MenuManager menuManager,
        CategoryManager categoryManager, ItemManager itemManager,CustomerManager customerManager, OrderManager orderManager)
    {
      this.socket = socket;
      this.restaurantManager = restaurantManager;
      this.menuManager = menuManager;
      this.categoryManager = categoryManager;
      this.itemManager = itemManager;
      this.customerManager = customerManager;
      this.orderManager=orderManager;

      try
      {
        outToClient = this.socket.getOutputStream();
        inFromClient = this.socket.getInputStream();

        byte[] lenbytes = new byte[1024*4];
        int read = inFromClient.read(lenbytes, 0, lenbytes.length);
        message = new String(lenbytes, 0, read);
        System.out.println(message);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    @Override public void run()
    {
      System.out.println("MESSAGE IS: " + message);
      Request request = new Gson().fromJson(message, Request.class);
      System.out.println(request.getContext());
      System.out.println(request.getType());

      // *****RESTAURANT stuffs*****
      // Add Restaurant
      if (request.getType().equals("AddRestaurant"))
      {
        System.out.println("I got a request to add Restaurant" + request.getContext());
        try
        {
          restaurantManager.AddRestaurant(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }

      // Get Restaurant
      if (request.getType().equals("GetRestaurant"))
      {
        System.out.println("I got a request to get Restaurant" + request.getContext());
        String response = restaurantManager.GetRestaurant(request.getContext());
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

      // Validate Restaurant
      if (request.getType().equals("ValidateRestaurant"))
      {
        System.out.println("I got a request to validate Restaurant" + request.getContext());
        String response = restaurantManager.ValidateLogin(request.getContext());
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

      // Update Restaurant
      if (request.getType().equals("UpdateRestaurant"))
      {
        System.out.println("I got a request to update a Restaurant" + request.getContext());
        try
        {
          restaurantManager.UpdateRestaurant(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }

      // Delete Restaurant
      if (request.getType().equals("RemoveRestaurant"))
      {
        System.out.println("I got a request to remove a Restaurant" + request.getContext());
        try
        {
          String response = restaurantManager.GetRestaurant(request.getContext());
          restaurantManager.RemoveRestaurant(request.getContext());
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
      }

      // Get Restaurants
      if (request.getType().equals("GetRestaurants"))
      {
        System.out.println("I got a request to get all Restaurants");
        String response = restaurantManager.GetRestaurants();
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

      // Accept order
      if (request.getType().equals("AcceptOrder"))
      {
        System.out.println("I got a request to accept an order" + request.getContext());

        try
        {
          restaurantManager.AcceptOrder(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }


        // Decline order
        if (request.getType().equals("DeclineOrder")){
          System.out.println("I got a request to accept an order" + request.getContext());

          try
          {
            restaurantManager.DeclineOrder(request.getContext());
          }
          catch (Exception e){
            System.out.println(e);
          }
        }


      // *****MENU stuffs*****
      // Add Menu
      if (request.getType().equals("AddMenu"))
      {
        System.out.println("I got a request to add Menu" + request.getContext());

        try
        {
          menuManager.AddMenu(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }

      // Get Menu
      if (request.getType().equals("GetMenu"))
      {
        System.out.println("I got a request to get Menu" + request.getContext());
        String response = menuManager.GetMenu(request.getContext());
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

      // Update Menu
      if (request.getType().equals("UpdateMenu"))
      {
        System.out.println("I got a request to update Menu" + request.getContext());

        try
        {
          menuManager.updateMenu(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }


      // *****Category stuffs*****
      // Add Category
      if (request.getType().equals("AddCategory"))
      {
        System.out.println("I got a request to add Category" + request.getContext());

        try
        {
          categoryManager.addCategory(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }

      // Get Category
      if (request.getType().equals("GetCategory"))
      {
        System.out.println("I got a request to get Category" + request.getContext());
        String response = categoryManager.getCategory(request.getContext());
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

      // Get Categories
      if (request.getType().equals("GetCategories"))
      {
        System.out.println("I got a request to get Categories" + request.getContext());
        String response = categoryManager.getCategories(request.getContext());
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

      // Update Category
      if (request.getType().equals("UpdateCategory"))
      {
        System.out.println("I got a request to update Category" + request.getContext());

        try
        {
          categoryManager.updateCategory(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }


// Delete Category
      if (request.getType().equals("DeleteCategory"))
      {
        System.out.println("I got a request to delete Category" + request.getContext());

        try
        {
          categoryManager.deleteCategory(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }


      // *****Item stuffs*****
      // Add Item
      if (request.getType().equals("AddItem"))
      {
        System.out.println("I got a request to add Item" + request.getContext());

        try
        {
          itemManager.addItem(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }

      // Get Items
      if (request.getType().equals("GetItems"))
      {
        System.out.println("I got a request to get Items" + request.getContext());
        String response = itemManager.getItems(request.getContext());
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


      // Update Item
      if (request.getType().equals("UpdateItem"))
      {
        System.out.println("I got a request to update Item" + request.getContext());

        try
        {
          itemManager.updateItem(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }

      // Delete Item
      if (request.getType().equals("DeleteItem"))
      {
        System.out.println("I got a request to delete Item" + request.getContext());

        try
        {
          itemManager.deleteItem(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }


      // *****CUSTOMER stuffs*****
      // Add Customer
      if (request.getType().equals("AddCustomer")){
        System.out.println("I got a request to add Customer" + request.getContext());
        try{
          customerManager.AddCustomer(request.getContext());
        }
        catch (Exception e){
          System.out.println(e);
        }
      }

      // Get Customer
      if (request.getType().equals("GetCustomer")){
        System.out.println("I got a request to get Customer" + request.getContext());
        String response = customerManager.GetCustomer(request.getContext());
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

      // Validate Customer
      if (request.getType().equals("ValidateCustomer")){
        System.out.println("I got a request to validate Customer" + request.getContext());
        String response = customerManager.GetCustomer(request.getContext());
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

      // Update Customer
      if (request.getType().equals("UpdateCustomer"))
      {
        System.out.println("I got a request to update Customer" + request.getContext());

        try
        {
          customerManager.UpdateCustomer(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }


      // Delete Customer
      if (request.getType().equals("DeleteCustomer"))
      {
        System.out.println("I got a request to delete Customer" + request.getContext());

        try
        {
          customerManager.deleteCustomer(request.getContext());
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }

      // *****ORDER stuff*****
      // Add order
      if (request.getType().equals("AddOrder")){
        System.out.println("I got a request to add Order" + request.getContext());
        try{
          orderManager.addOrder(request.getContext());
        }
        catch (Exception e){
          System.out.println(e);
        }
      }

      //Get incoming orders
      if (request.getType().equals("GetIncomingOrders")){
        System.out.println("I got a request to get incoming orders" + request.getContext());
        try{
          orderManager.getIncomingOrders(request.getContext());
        }
        catch (Exception e){
          System.out.println(e);
        }
      }



    }
  }




