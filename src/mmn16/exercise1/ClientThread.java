package mmn16.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientThread extends Thread {

    private PrintWriter clientAOut, clientBOut;
    private BufferedReader clientIn;

    public ClientThread(PrintWriter clientAOut, BufferedReader clientIn, PrintWriter clientBOut) {
        this.clientAOut = clientAOut;
        this.clientIn = clientIn;
        this.clientBOut = clientBOut;
    }

    @Override
    public void run() {
        String input;
        try {
            input = clientIn.readLine();
            while(input != null)
            {
                clientAOut.println("Server: " + input);
                clientBOut.println("Server: " + input);
                input = clientIn.readLine();
            }
            clientAOut.close();
            clientIn.close();
            clientBOut.close();
        }
        catch(IOException e) { e.printStackTrace(); }
    }
}
