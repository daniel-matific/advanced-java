package mmn16.exercise2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args)
    {
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] buffer = new byte[256];
            InetAddress a = InetAddress.getByName("localhost");
            String test = "Paris";
            buffer = test.getBytes();
            DatagramPacket p = new DatagramPacket(buffer, buffer.length, a, 7777);
            socket.send(p);
            buffer = new byte[256];
            p = new DatagramPacket(buffer, buffer.length);
            socket.receive(p);
            String data = new String(p.getData(), 0, p.getLength());
            System.out.println(data);
        }
        catch(IOException e){}
    }
}
