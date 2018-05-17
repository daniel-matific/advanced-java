package mmn16.exercise1_try2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(7777);
            Socket connectionA, connectionB;
            connectionA = server.accept();
            connectionB = server.accept();
            new ServerThread(connectionA, connectionB).start();
        } catch(IOException e) {}

    }
}
