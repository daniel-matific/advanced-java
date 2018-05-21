package mmn16.exercise2;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

    private static ArrayList<Forecast> forecastDatabase;

    public static void main(String[] args)
    {
        /*try{
            DatagramSocket socket = new DatagramSocket(7777);
            System.out.println("Server's Ready");
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String response = "Hello";
            buf = response.getBytes();
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
        }
        catch(IOException e){}*/
        forecastDatabase = new ArrayList<>();
        File forecast = new File("forecast.txt");
        convertFileToForecast(forecast);
    }

    // Reads the menu file and turns each 3 rows to item in the list
    private static void convertFileToForecast(File forecastFile) {
        String[] splitInput;
        Scanner input = null;
        try {
            input = new Scanner(forecastFile);
            while(input.hasNext()) {
                splitInput = input.nextLine().split("/");
                Forecast forecast = new Forecast(splitInput[0], splitInput[1], Integer.parseInt(splitInput[2]), splitInput[3], splitInput[4]);
                forecastDatabase.add(forecast);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Forecast file not found!");
        } finally {
            if(input != null) {
                input.close();
            }
        }
    }
}
