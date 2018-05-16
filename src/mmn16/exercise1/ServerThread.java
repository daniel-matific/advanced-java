package mmn16.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket clientA, clientB;
    private PrintWriter clientAOut, clientBOut;
    private BufferedReader clientAIn, clientBIn;

    public ServerThread(Socket clientA, Socket clientB) {
        this.clientA = clientA;
        this.clientB = clientB;
        try {
            clientAOut = new PrintWriter(clientA.getOutputStream(), true);
            clientAIn = new BufferedReader(new InputStreamReader(clientA.getInputStream()));
            clientBOut = new PrintWriter(clientB.getOutputStream(), true);
            clientBIn = new BufferedReader(new InputStreamReader(clientB.getInputStream()));
        }
        catch(IOException e){ e.printStackTrace(); }
    }
    public void run()
    {
        String inputA, inputB;
        try {
            inputA = clientAIn.readLine();
            inputB = clientBIn.readLine();
            while(inputA != null && inputB != null)
            {
                clientAOut.println("Server: " + inputA);
                clientBOut.println("Server: " + inputB);
                clientAOut.println("Server: " + inputB);
                clientBOut.println("Server: " + inputA);
                inputA = clientAIn.readLine();
                inputB = clientBIn.readLine();
            }
            clientAIn.close();
            clientAOut.close();
            clientBIn.close();
            clientBOut.close();
            //new ClientThread(clientAOut, clientAIn, clientBOut).start();
            //new ClientThread(clientBOut, clientBIn, clientAOut).start();
            clientA.close();
            clientB.close();
        }
        catch(IOException e) { e.printStackTrace(); }
    }
}
