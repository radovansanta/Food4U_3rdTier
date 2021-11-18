public class RunServer {
  public static void main(String[] args) {

    Server ss = new Server(new UserManager());
    ss.startServer();
  }
}