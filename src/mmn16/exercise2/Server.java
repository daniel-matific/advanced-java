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

public class Server extends JFrame {

    private ArrayList<Forecast> forecastDatabase;

    public Server() {
        forecastDatabase = new ArrayList<>();
    }

    public static void main(String[] args)
    {
        Server server = new Server();
        File forecast = new File("forecast.txt");
        server.convertFileToForecast(forecast);
        try{
            DatagramSocket socket = new DatagramSocket(7777);
            System.out.println("Server's Ready");
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String response = server.analyzeRequest(new String(packet.getData(), 0, packet.getData().length));
            buffer = response.getBytes();
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(packet);
        }
        catch(IOException e){}
    }

    // Reads the menu file and turns each 3 rows to item in the list
    private void convertFileToForecast(File forecastFile) {
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

    // Analyzes the packet from Client
    private String analyzeRequest(String request) {
        String result = "", city;
        request = request.substring(0, request.indexOf('\0'));
        for(Forecast forecast : forecastDatabase) {
            city = forecast.getCity();
            if(city.equals(request)) {
                result += forecast.toString() + "\n";
            }
        }
        return result;
    }
}
