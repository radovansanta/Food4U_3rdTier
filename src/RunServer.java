public class RunServer {
  public static void main(String[] args) {

    Server ss = new Server(new UserManager(), new RestaurantManager(), new MenuManager());
    ss.startServer();
  }
}