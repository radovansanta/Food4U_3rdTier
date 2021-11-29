import Managers.RestaurantManager;
import Managers.UserManager;
import Models.Request;
import Models.Restaurant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.Socket;

  public class SocketHandlerManager implements Runnable
  {

    private Socket socket;
    private UserManager userManager;
    private RestaurantManager restaurantManager;
    private MenuManager menuManager;

    private OutputStream outToClient;
    private InputStream inFromClient;
    private String message;

    public SocketHandlerManager(Socket socket, UserManager chatManager, RestaurantManager restaurantManager, MenuManager menuManager)
    {
      this.socket = socket;
      this.userManager = chatManager;
      this.restaurantManager = restaurantManager;
      this.menuManager = menuManager;

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

      // Add User
      if (request.getType().equals("AddUser")){
        System.out.println("I got a request to add User" + request.getContext());
        try{
          userManager.AddUser(request.getContext());
        }
        catch (Exception e){
          System.out.println(e);
        }
      }

      // Update User
      if (request.getType().equals("UpdateUser")){
        System.out.println("I got a request to update User" + request.getContext());
        try{
          //userManager. MISSING FUNCTION;
        }
        catch (Exception e){
          System.out.println(e);
        }
      }

      // Delete User
      if (request.getType().equals("DeleteUser")){
        System.out.println("I got a request to delete User" + request.getContext());
        try{
          //userManager. MISSING FUNCTION;
        }
        catch (Exception e){
          System.out.println(e);
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
        String response = restaurantManager.GetRestaurant(Integer.parseInt(request.getContext()));
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
          String response = restaurantManager.GetRestaurant(Integer.parseInt(request.getContext()));
          restaurantManager.RemoveRestaurant(Integer.parseInt(request.getContext()));
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

    }
  }




