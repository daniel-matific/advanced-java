package mmn16.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ServerThread(Socket socket) {
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch(IOException e){ e.printStackTrace(); }
    }
    public void run()
    {
        String input;
        try {
            input = in.readLine();
            while(input != null)
            {
                out.println(input);
                input = in.readLine();
            }
            in.close();
            out.close();
            socket.close();
        }
        catch(IOException e) { e.printStackTrace(); }
    }
}
