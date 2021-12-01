import Managers.*;
import Managers.MenuManager;
import Managers.RestaurantManager;
import Managers.UserManager;
import Models.Request;
import Models.Restaurant;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

  public class SocketHandlerManager implements Runnable
  {

    private Socket socket;
    private UserManager userManager;
    private RestaurantManager restaurantManager;
    private MenuManager menuManager;
    private CategoryManager categoryManager;
    private ItemManager itemManager;

    private OutputStream outToClient;
    private InputStream inFromClient;
    private String message;

    public SocketHandlerManager(Socket socket, UserManager chatManager, RestaurantManager restaurantManager, MenuManager menuManager,
        CategoryManager categoryManager, ItemManager itemManager)
    {
      this.socket = socket;
      this.userManager = chatManager;
      this.restaurantManager = restaurantManager;
      this.menuManager = menuManager;
      this.categoryManager = categoryManager;
      this.itemManager = itemManager;

      try
      {
        outToClient = this.socket.getOutputStream();
        inFromClient = this.socket.getInputStream();

        byte[] lenbytes = new byte[1024];
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
      Request request = new Gson().fromJson(message, Request.class);
      System.out.println(request.getContext());
      System.out.println(request.getType());


      // *****USER stuffs*****
      // Validate User
      if (request.getType().equals("ValidateUser")){
        String response = userManager.ValidateUser(request.getContext());
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

      // *****RESTAURANT stuffs*****
      // Add Restaurant
      if (request.getType().equals("AddRestaurant")){
          System.out.println("I got a request to add Restaurant" + request.getContext());
          try{
              restaurantManager.AddRestaurant(request.getContext());
          }
          catch (Exception e){
            System.out.println(e);
          }
      }

      // Get Restaurant
      if (request.getType().equals("GetRestaurant")){
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
      if (request.getType().equals("ValidateRestaurant")){
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
      if (request.getType().equals("UpdateRestaurant")){
        System.out.println("I got a request to update a Restaurant" + request.getContext());
        try{
          restaurantManager.UpdateRestaurant(request.getContext());
        }
        catch (Exception e){
          System.out.println(e);
        }
      }

      // Delete Restaurant
      if (request.getType().equals("RemoveRestaurant")){
        System.out.println("I got a request to remove a Restaurant" + request.getContext());
        try{
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
        catch (Exception e){
          System.out.println(e);
        }
      }

      // *****MENU stuffs*****
      // Add Menu
      if (request.getType().equals("AddMenu"))
      {
        System.out.println("I got a request to add Menu" + request.getContext());
      }
      try
      {
        menuManager.AddMenu(request.getContext());
      }
      catch (Exception e)
      {
        System.out.println(e);
      }

      // Update Menu
      if (request.getType().equals("UpdateMenu"))
      {
        System.out.println("I got a request to update Menu" + request.getContext());
      }
      try
      {
        menuManager.updateMenu(request.getContext());
      }
      catch (Exception e)
      {
        System.out.println(e);
      }

      // *****Category stuffs*****
      // Add Category
      if (request.getType().equals("AddCategory"))
      {
        System.out.println("I got a request to add Category" + request.getContext());
      }
      try
      {
        categoryManager.addCategory(request.getContext());
      }
      catch (Exception e)
      {
        System.out.println(e);
      }

      // Update Category
      if (request.getType().equals("UpdateCategory"))
      {
        System.out.println("I got a request to update Category" + request.getContext());
      }
      try
      {
        categoryManager.updateCategory(request.getContext());
      }
      catch (Exception e)
      {
        System.out.println(e);
      }

      // *****Item stuffs*****
      // Add Item
      if (request.getType().equals("AddItem"))
      {
        System.out.println("I got a request to add Item" + request.getContext());
      }
      try
      {
        itemManager.addItem(request.getContext());
      }
      catch (Exception e)
      {
        System.out.println(e);
      }

      // Update Item
      if (request.getType().equals("UpdateItem"))
      {
        System.out.println("I got a request to update Item" + request.getContext());
      }
      try
      {
        itemManager.updateItem(request.getContext());
      }
      catch (Exception e)
      {
        System.out.println(e);
      }



    }
  }




