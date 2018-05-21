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
            byte[] buf = new byte[256];
            InetAddress a = InetAddress.getByName("localhost");
            DatagramPacket p = new DatagramPacket(buf, buf.length, a, 7777);
            socket.send(p);
            p = new DatagramPacket(buf, buf.length);
            socket.receive(p);
            String data = new String(p.getData(), 0, p.getLength());
            System.out.println("Server:" + data);
        }
        catch(IOException e){}
    }
}
