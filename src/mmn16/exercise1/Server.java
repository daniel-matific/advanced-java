package mmn16.exercise1;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args)
    {
        ServerSocket srv;
        boolean listening = true;
        try {
            srv = new ServerSocket(7777);
            //    srv.setSoTimeout(5000);
            System.out.println("Server's ready");
            Socket socketA, socketB;

            while(listening)
            {
                socketA = srv.accept();
                socketB = srv.accept();
                new ServerThread(socketA, socketB).start();
            }
        }
        catch(InterruptedIOException e)
        {
            System.out.println("Time out");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }



    }
}
