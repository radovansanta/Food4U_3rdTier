import Managers.*;

import Managers.MenuManager;
import Managers.RestaurantManager;


public class RunServer {
  public static void main(String[] args) {

    Server ss = new Server(new RestaurantManager(), new MenuManager(), new CategoryManager(), new ItemManager(),
            new CustomerManager(), new OrderManager(), new DriverManager());
    ss.startServer();
  }
} 