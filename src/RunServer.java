import Managers.ManagerFactory;

public class RunServer {
    public static void main(String[] args) {
        ManagerFactory managerFactory = ManagerFactory.getInstance();
        Server ss = new Server(managerFactory);
        ss.startServer();
    }
} 