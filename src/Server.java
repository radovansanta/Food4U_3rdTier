import Managers.ManagerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ManagerFactory managerFactory;

    public Server(ManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

    public void startServer() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(2910);
            while (true) {
                Socket socket = welcomeSocket.accept();
                System.out.println("Accepted");
                SocketHandlerManager handler = new SocketHandlerManager(socket, managerFactory);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}