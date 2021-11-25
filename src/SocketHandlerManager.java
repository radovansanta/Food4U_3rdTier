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

    private OutputStream outToClient;
    private InputStream inFromClient;
    private String message;

    public SocketHandlerManager(Socket socket, UserManager chatManager, RestaurantManager restaurantManager)
    {
      this.socket = socket;
      this.userManager = chatManager;
      this.restaurantManager = restaurantManager;

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

      if (request.getType().equals("AddRestaurant")){
          System.out.println("I got a request to add Restaurant" + request.getContext());
          try{
              restaurantManager.AddRestaurant(request.getContext());
          }
          catch (Exception e){
            System.out.println(e);
          }
      }

      if (request.getType().equals("AddUser")){
        System.out.println("I got a request to add User" + request.getContext());
        try{
          userManager.AddUser(request.getContext());
        }
        catch (Exception e){
          System.out.println(e);
        }
      }

    }
  }




