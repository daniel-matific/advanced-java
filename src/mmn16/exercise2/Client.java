package mmn16.exercise2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client extends JFrame {

    private JButton connect, disconnect, send;
    private String[] cities = {"Paris","London","Berlin","Rome"};
    private JComboBox<String> citiesMenu;
    private String serverIP;
    private int port;
    private DatagramSocket socket;

    public static void main(String[] args)
    {
        Client client = new Client();
        client.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // constructs the ui and handles the events that happen when pressing the buttons
    public Client(){
        super("Client");

        JPanel rightPanel = new JPanel(new GridLayout(2, 1));
        connect = new JButton("Connect");
        connect.setBackground(Color.GREEN);
        connect.addActionListener(event -> new Thread(() -> {
            serverIP = JOptionPane.showInputDialog(null, "Please enter server IP:");
            try {
                port = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter server port:"));
                socket = new DatagramSocket();
                send.setEnabled(true);
                connect.setEnabled(false);
                disconnect.setEnabled(true);
            }
            catch(NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, "Port must be a number!");
            }
            catch (SocketException e) {
                JOptionPane.showMessageDialog(null, "Socket could not be opened!");
            }
                }).start()
        );
        disconnect = new JButton("Disconnect");
        disconnect.setBackground(new Color(215, 0, 0));
        disconnect.addActionListener(event -> {
                serverIP = "";
                port = 0;
                socket.close();
                disconnect.setEnabled(false);
                send.setEnabled(false);
                connect.setEnabled(true);
            }
        );
        disconnect.setEnabled(false);
        rightPanel.add(connect);
        rightPanel.add(disconnect);
        add(rightPanel, BorderLayout.EAST);
        JPanel leftPanel = new JPanel(new GridLayout(2, 1));
        send = new JButton("Send");
        send.addActionListener(event -> startRunning());
        send.setEnabled(false);
        citiesMenu = new JComboBox<>(cities);
        leftPanel.add(citiesMenu);
        leftPanel.add(send);
        add(leftPanel, BorderLayout.CENTER);
        setSize(250, 200);
        setVisible(true);
    }

    private void startRunning(){
        try {
            byte[] buffer = new byte[256];
            buffer = ((String)citiesMenu.getSelectedItem()).getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(serverIP), port);
            socket.send(packet);
            buffer = new byte[256];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String data = new String(packet.getData(), 0, packet.getLength());
            JOptionPane.showMessageDialog(null, data);
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "I/O Exception occurred.");
        }
    }
}
