package mmn16.exercise1;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args)
    {
        Socket socket;
        PrintWriter out;
        BufferedReader in;
        String host = "localhost";
        try{
            socket = new Socket(host, 7777);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("After connection");
            String s = JOptionPane.showInputDialog(null, "Enter a string to send:");
            while(s != null)
            {
                out.println(s);
                System.out.println( in.readLine());
                s = JOptionPane.showInputDialog(null, "Enter a string to send:");
            }

            out.close();
            in.close();
            socket.close();
        }
        catch(UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
