import Managers.*;
import Managers.MenuManager;
import Managers.RestaurantManager;
import Managers.UserManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  //public static void main(String[] args) throws Exception{

    /*
    ServerSocket server = new ServerSocket(2910);
    Gson gson = new Gson();
    while (true)
    {
      System.out.println("Server started..");

      Socket socket = server.accept();
      System.out.println("Client connected");

      // read from client
      InputStream inputStream = socket.getInputStream();
      byte[] lenbytes = new byte[1024];
      int read = inputStream.read(lenbytes, 0, lenbytes.length);
      String message = new String(lenbytes, 0, read);
      Models.User deserializedUser = gson.fromJson(message, Models.User.class);
      System.out.println(deserializedUser.Username);
      if (deserializedUser.Username.equals("Radovan"))
      {
        OutputStream outputStream = socket.getOutputStream();
        String response = "Ano je to Radovan";
        byte[] responseAsBytes = response.getBytes();
        outputStream.write(responseAsBytes, 0, responseAsBytes.length);
      }
      else
      System.out.println(deserializedUser.Password);

    }

     */

    private UserManager userManager;
    private RestaurantManager restaurantManager;
    private MenuManager menuManager;
    private CategoryManager categoryManager;

     public Server(UserManager userManager, RestaurantManager restaurantManager, MenuManager menuManager, CategoryManager categoryManager) {
      this.userManager = userManager;
      this.restaurantManager = restaurantManager;
      this.menuManager = menuManager;
      this. categoryManager = categoryManager;
    }

    public void startServer() {
      try {
        ServerSocket welcomeSocket = new ServerSocket(2910);
        while (true) {
          Socket socket = welcomeSocket.accept();
          System.out.println("Accepted");
          SocketHandlerManager handler = new SocketHandlerManager(socket, userManager, restaurantManager, menuManager, categoryManager);
          new Thread(handler).start();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}