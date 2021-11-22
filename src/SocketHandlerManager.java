import Models.Request;
import com.google.gson.Gson;

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

    public SocketHandlerManager(Socket socket, UserManager chatManager)
    {
      this.socket = socket;
      this.userManager = chatManager;

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
          restaurantManager.AddRestaurant(request.getContext());
      }

    }
  }




